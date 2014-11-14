package gamingthelan.netutils;

import gamingthelan.netutils.servicepackets.DisconnectionPacket;

/**
 * Interface for a generic ConnectionHandler
 * 
 * @author Digitex Group
 */

public interface ConnectionHandler {
	/**
	 * Called when a packet is received by a connection
	 * @param packet : The packet's object
	 */
	public void onReceivedPacket(IPacket packet);
	
	public void onDisconnectedClient(DisconnectionPacket packet);
	
	/**
	 * Callback method to let know the client software that the connection is closed or not available anymore
	 * Added in version 152 WARNING : Updating the library will break your client, they need to implement this method 
	 */
	public void onClosedConnection(String nickname);
}
