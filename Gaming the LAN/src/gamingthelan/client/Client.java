package gamingthelan.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import gamingthelan.netutils.ConnectionHandler;
import gamingthelan.netutils.IConnection;
import gamingthelan.netutils.IPacket;


/**
 *   
 * Allows you to create Client's object and to connect it to the Server with a Nickname, a port and a ServerAddress 
 * it also have a ConnectionHandler to manages every packet
 * 
 * @author Digitex Group
 * 
 */

public class Client implements IClient{
	
	private String nickName;
	private String serverAddress;
	private int porta = 8080;
	private int connectionTimeOut = 500;
	
	private Thread connectionThread;
	private ClientConnection myConnection;
	private ConnectionHandler handler;
	
	/* ALCUNI COSTRUTTORI, VEDEREMO SE TENERLI TUTTI I SE RIMUOVERNE QUALCUNO */
	
	public Client(String nickName, String serverAddress, int porta, int connectionTimeOut, ConnectionHandler handler) {
		this.serverAddress = serverAddress;
		this.handler = handler;
		this.connectionTimeOut = connectionTimeOut;
		this.porta = porta;
		this.nickName = nickName;
	}
	
	public Client(String nickName, String serverAddress, ConnectionHandler handler) {
		this.serverAddress = serverAddress;
		this.handler = handler;
		this.nickName = nickName;
	}
	
	public Client(String nickName, String serverAddress) {
		this.serverAddress = serverAddress;
		this.nickName = nickName;
	}
	
	public Client(String nickName, String serverAddress,  int porta, int connectionTimeOut) {
		this.serverAddress = serverAddress;
		this.connectionTimeOut = connectionTimeOut;
		this.porta = porta;
		this.nickName = nickName;
	}
	
	/* ---------------------------- */
	@Override
	public void connect() throws IOException
	{
		
		Socket mySocket = new Socket();
		SocketAddress socketAddress = new InetSocketAddress(serverAddress,porta);
		
		mySocket.connect(socketAddress, connectionTimeOut);

		myConnection = new ClientConnection(mySocket, handler, nickName);
		
		connectionThread = new Thread(myConnection);
		connectionThread.start();
	}

	@Override
	public void sendPacket(IPacket packet) throws IOException {
			myConnection.sendPacket(packet);
	}

	@Override
	public IConnection getConnection() {
		return myConnection;
	}

	public ConnectionHandler getHandler() {
		return handler;
	}

	public void setHandler(ConnectionHandler handler) {
		this.handler = handler;
	}

	@Override
	public void disconnect() {
		
		myConnection.disconnect();
		connectionThread.interrupt();
	}
	
	
	
}
