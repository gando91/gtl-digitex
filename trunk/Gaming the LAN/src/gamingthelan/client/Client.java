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
	
	private Connection myConnection;
	private ConnectionHandler handler;
	
	
	public Client(String serverAddress, int porta, int connectionTimeOut, ConnectionHandler handler) {
		this.serverAddress = serverAddress;
		this.connectionTimeOut = connectionTimeOut;
		this.porta = porta;
	}
	
	public Client(String serverAddress, ConnectionHandler handler) {
		this.serverAddress = serverAddress;
	}
	
	public void Connect()
	{
		
		Socket mySocket = new Socket();
		SocketAddress socketAddress = new InetSocketAddress(serverAddress,porta);
		
		try {
			mySocket.connect(socketAddress, connectionTimeOut);
		} catch (IOException e) {
			// TODO Gestire le eccezzioni lato client
			e.printStackTrace();
		}
		
		myConnection = new Connection(mySocket, handler);
		
		Thread connectionThread = new Thread(myConnection);
		connectionThread.start();
	}

	@Override
	public void sendPacket(IPacket packet) {
		try {
			myConnection.sendPacket(packet);
		} catch (IOException e) {
			// TODO Gestire eccezioni lato client
			e.printStackTrace();
		}
	}

	@Override
	public IConnection getConnection() {
		return myConnection;
	}
	
}
