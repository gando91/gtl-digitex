package gamingthelan.server;

import gamingthelan.netutils.IConnection;
import gamingthelan.netutils.IPacket;

import java.io.IOException;
import java.net.InetAddress;
import java.util.LinkedList;
import java.util.List;


public class Server implements IServer {

	private List<IConnection> clients = new LinkedList<IConnection>();
	private List<InetAddress> banlist = new LinkedList<InetAddress>();
	private static Server instance;
	
	private Server(){
		//TODO Auto-generated method stub
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
		//TODO : Migliorare
		clients.remove(connection);
		
	}

	@Override
	public void broadcastMessage(IPacket packet) throws IOException {
		
		for (IConnection c : clients) {
			c.sendPacket(packet);
		}
		
	}

	@Override
	public void sendMessage(IPacket pacchetto, IConnection connessione) {
		// TODO Auto-generated method stub
		
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
	
}
