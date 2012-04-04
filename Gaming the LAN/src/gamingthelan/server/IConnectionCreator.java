package gamingthelan.server;

import java.net.Socket;

import gamingthelan.netutils.ConnectionHandler;
import gamingthelan.netutils.IConnection;

public interface IConnectionCreator {
	public IConnection createConnection(Socket socket, ConnectionHandler handler);

}
