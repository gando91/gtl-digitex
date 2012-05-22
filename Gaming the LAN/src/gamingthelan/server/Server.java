package gamingthelan.server;

import gamingthelan.netutils.CheckPacket;
import gamingthelan.netutils.ConnectionHandler;
import gamingthelan.netutils.IConnection;
import gamingthelan.netutils.IPacket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Server implements IServer {

	private List<IConnection> clients = new LinkedList<IConnection>();
	private List<InetAddress> banlist = new LinkedList<InetAddress>();
	private static Server instance;
	
	private Server(){
		
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
				
				if(c.getNickName().equals(nickName)){
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
		for (IConnection conn : clients) {
			
			try {
				conn.sendPacket(new CheckPacket("Server", conn.getNickName()));
				try {
					this.wait(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (IOException e) {
				//vuol dire che conn è certamente morta
				//TODO : Mandare il famoso pacchetto a tutti
				conn.disconnect();
			}
			
		}
		
	}
	
	
	
}
