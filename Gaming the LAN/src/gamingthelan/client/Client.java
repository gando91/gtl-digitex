package gamingthelan.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import gamingthelan.netutils.Connection;
import gamingthelan.netutils.ConnectionHandler;
import gamingthelan.netutils.IConnection;
import gamingthelan.netutils.IPacket;

public class Client implements IClient{
	
	private String serverAddress;
	private int porta = 8080;
	private int connectionTimeOut = 500;
	
	private Thread connectionThread;
	private Connection myConnection;
	private ConnectionHandler handler;
	
	/* ALCUNI COSTRUTTORI, VEDEREMO SE TENERLI TUTTI I SE RIMUOVERNE QUALCUNO */
	
	public Client(String serverAddress, int porta, int connectionTimeOut, ConnectionHandler handler) {
		this.serverAddress = serverAddress;
		this.handler = handler;
		this.connectionTimeOut = connectionTimeOut;
		this.porta = porta;
	}
	
	public Client(String serverAddress, ConnectionHandler handler) {
		this.serverAddress = serverAddress;
		this.handler = handler;
	}
	
	public Client(String serverAddress) {
		this.serverAddress = serverAddress;
	}
	
	public Client(String serverAddress,  int porta, int connectionTimeOut) {
		this.serverAddress = serverAddress;
		this.connectionTimeOut = connectionTimeOut;
		this.porta = porta;
	}
	
	/* ---------------------------- */
	@Override
	public void connect() throws IOException
	{
		
		Socket mySocket = new Socket();
		SocketAddress socketAddress = new InetSocketAddress(serverAddress,porta);
		
		mySocket.connect(socketAddress, connectionTimeOut);

		myConnection = new Connection(mySocket, handler);
		
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
