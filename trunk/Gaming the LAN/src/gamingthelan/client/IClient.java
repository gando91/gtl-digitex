package gamingthelan.client;

import java.io.IOException;

import gamingthelan.netutils.IConnection;
import gamingthelan.netutils.IPacket;

/**
 * Interface for generic Client
 * 
 * @author Digitex Group
 */

public interface IClient {
	
	/**
	 * Interacts with a client object, allowing you to send packets outside the handler object.
	 * 
	 * @param packet  packet to send
	 * @throws IOException 
	 */
	public void sendPacket(IPacket packet) throws IOException;

	public IConnection getConnection();
	
	/**
	 * Connect this client to the server.
	 * Starts a new thread in order to deal the communication.
	 * All incoming packets are passed to your handler.
	 * @throws IOException 
	 */
	public void connect() throws IOException;
	
	/**
	 *  Disconnect this client from the server 
	 */
	
	
	public void disconnect();
}
