package gamingthelan.netutils;

import gamingthelan.netutils.servicepackets.DisconnectionPacket;

/**
 * this is the interface for a generic ConnectionHandler
 */

public interface ConnectionHandler {
	/**
	 * Called when a packet is received by a connection
	 * @param packet : The packet's object
	 */
	public void onReceivedPacket(IPacket packet);
	
	public void onDisconnectedClient(DisconnectionPacket packet);
	
}
