package gamingthelan.server;

import java.net.Socket;

import gamingthelan.netutils.ConnectionHandler;
import gamingthelan.netutils.IConnection;

/**  Generic creator connection interface  **/
public interface IConnectionCreator {
	
	/** create a connection to target socket and with valid handler
	 * 
	 * @param socket
	 * @param handler
	 * @return IConnection
	 */
	public IConnection createConnection(Socket socket, ConnectionHandler handler);
	

}
