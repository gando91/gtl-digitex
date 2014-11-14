package gamingthelan.server;

import gamingthelan.netutils.ConnectionHandler;
import gamingthelan.netutils.IConnection;
import gamingthelan.netutils.IPacket;
import gamingthelan.netutils.servicepackets.CheckPacket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *   
 * Allows you to create Server's object as a Singleton.
 * It's able to create a connection to a specific port.
 * It's also able to manages every packet and to identify the client to ban,to unban and to send a massage.
 * 
 * @author Digitex Group
 * 
 */



public class Server implements IServer {

	private List<IConnection> clients = new LinkedList<IConnection>();
	private List<InetAddress> banlist = new LinkedList<InetAddress>();
	private Thread serverThread;
	
	private boolean response = false;
	
	private static Server instance;
	
	private Server(){
		
		serverThread = new Thread(this);
		serverThread.start();
		
	}
	
	
	public static Server getInstance() {
		
		if (instance == null) {
			instance = new Server();
		}
		
		return instance;
	}
	
	
	public List<IConnection> getClients() {
		return clients;
	}

	@Override
	public void addConnection(IConnection connection) {
		if(banlist.contains(connection.getSocket().getInetAddress()))
			return;
		
		clients.add(connection);	
	}

	@Override
	public void rmConnection(IConnection connection) {
		
		clients.remove(connection);		
	}

	@Override
	public void broadcastMessage(IPacket packet) throws IOException {
		
		for (IConnection c : clients) {
			c.sendPacket(packet);
		}		
	}

	@Override
	public void sendMessage(IPacket pacchetto) {
		
		for (Iterator<String> iterator = pacchetto.getReceiver().iterator(); iterator.hasNext();) {
			
			String nickName = (String) iterator.next();		
			
			for (Iterator<IConnection> iterator2 = Server.getInstance().clients.iterator(); iterator2.hasNext();) {
				
				ServerConnection c = (ServerConnection) iterator2.next();	
				
				if(c.getNickName().equals(nickName) && c.isAlive()){
					try {
						c.sendPacket(pacchetto);
					} catch (IOException e) {
						System.err.println("Errore di I/O su " + c.toString());
					}
				}
				
			}
		}		
				
	}

	@Override
	public boolean ban(InetAddress address) {
		
		banlist.add(address);
		for (IConnection c : clients) {
			if(c.getSocket().getInetAddress() == address)
				rmConnection(c);
		}
		return true;
	}

	@Override
	public boolean unban(InetAddress address) {
		
		banlist.remove(address);
		return true;
	}

	@Override
	public void createConnection(Socket socket, ConnectionHandler handler) {
		
		addConnection(ConnectionCreator.getInstance().createConnection(socket, handler));		
	}

	@Override
	public void run() {
		while(true){
			for (IConnection conn : clients) {
				
				try {
					
					response = false;
					conn.sendPacket(new CheckPacket("Server", conn.getNickName()));
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					//Se la connessione interpellata non risponde
					if ( !response ) {
						conn.disconnect();
					}
					
				} catch (IOException e) {
					//vuol dire che conn è certamente morta
					conn.disconnect();
				}
				
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void wakeUp(){
		response = true;
	}
	
	
}
