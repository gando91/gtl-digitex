package gamingthelan.server;

import java.net.Socket;

import gamingthelan.netutils.Connection;
import gamingthelan.netutils.ConnectionHandler;
import gamingthelan.netutils.IConnection;

public class ConnectionCreator implements IConnectionCreator {

	private static ConnectionCreator instance;
	
	private ConnectionCreator(){
		
	}
	
	public static ConnectionCreator getInstance() {
		
		if (instance == null) {
			instance = new ConnectionCreator();
		}
		
		return instance;
	}
	
	@Override
	public IConnection createConnection(Socket socket, ConnectionHandler handler) {
		System.out.println("test1");
		Connection tmp = new Connection(socket, handler);

		Thread t = new Thread(tmp);
		t.start();
		return tmp;
	}

}
