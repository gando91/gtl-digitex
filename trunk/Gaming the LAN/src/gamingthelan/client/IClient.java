package gamingthelan.client;

import gamingthelan.netutils.IConnection;
import gamingthelan.netutils.IPacket;

public interface IClient {
	
	/**
	 * A method to interact with a client object, allowing you to send packets outside the handler object.
	 * @param packet The packet to send
	 */
	public void sendPacket(IPacket packet);
	
	public IConnection getConnection();
}
