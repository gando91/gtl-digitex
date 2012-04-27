package gamingthelan.server;

import java.net.Socket;

import gamingthelan.netutils.ConnectionHandler;
import gamingthelan.netutils.IConnection;

/** This is the generic creator connection interface  **/
public interface IConnectionCreator {
	
	/** create a connection to target socket and with valid handler
	 * 
	 * @param socket
	 * @param handler
	 * @return
	 */
	public IConnection createConnection(Socket socket, ConnectionHandler handler);
	

}
