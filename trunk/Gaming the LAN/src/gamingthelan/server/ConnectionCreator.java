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
		Connection tmp = new Connection(socket, handler);
		System.out.println("ConnectionCreator istanza creata");
		Thread t = new Thread(tmp);
		t.start();
		System.out.println("ConnectionCreator thread creato");
		return tmp;
	}

}
