package gamingthelan.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import gamingthelan.netutils.ConnectionHandler;
import gamingthelan.netutils.IConnection;
import gamingthelan.netutils.IPacket;


public interface IServer {
	
	public void createConnection(Socket socket, ConnectionHandler handler);
	
	public void addConnection(IConnection connessione);
	public void rmConnection(IConnection connessione);
	
	public void broadcastMessage(IPacket pacchetto) throws IOException;
	public void sendMessage(IPacket pacchetto, IConnection connessione);
	
	public boolean ban(InetAddress address);
	public boolean unban(InetAddress address);
	
	
}