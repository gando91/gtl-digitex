package gamingthelan.client;

import java.io.IOException;

import gamingthelan.netutils.IConnection;
import gamingthelan.netutils.IPacket;

/**
 * This is the interface of generic Client
 * 
 */

public interface IClient {
	
	/**
	 * A method to interact with a client object, allowing you to send packets outside the handler object.
	 * @param packet The packet to send
	 * @throws IOException 
	 */
	public void sendPacket(IPacket packet) throws IOException;

	public IConnection getConnection();
	
	/**
	 * Connect this client to the server.
	 * This starts a new thread in order to deal the communication.
	 * All incoming packets are passed to your handler.
	 * @throws IOException 
	 */
	public void Connect() throws IOException;
}
