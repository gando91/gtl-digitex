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
	
}
