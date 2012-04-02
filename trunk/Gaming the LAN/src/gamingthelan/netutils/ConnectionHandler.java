package gamingthelan.netutils;

public interface ConnectionHandler {
	/**
	 * Called when a packet is received by a connection
	 * @param packet : The packet's object
	 */
	public void onReceivedPacket(IPacket packet);
	
}
