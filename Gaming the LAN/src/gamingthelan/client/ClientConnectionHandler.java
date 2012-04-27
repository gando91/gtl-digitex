package gamingthelan.client;

import gamingthelan.netutils.ConnectionHandler;
import gamingthelan.netutils.IPacket;

public abstract class ClientConnectionHandler implements ConnectionHandler {
	
	private IClient client;
	
	public ClientConnectionHandler(IClient client) {
		this.client = client;
	}
	
	protected void sendPacket(IPacket packet) {
		client.sendPacket(packet);
	}
	
}
