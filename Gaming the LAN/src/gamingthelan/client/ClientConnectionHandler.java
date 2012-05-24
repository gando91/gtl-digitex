package gamingthelan.client;

import java.io.IOException;

import gamingthelan.netutils.ConnectionHandler;
import gamingthelan.netutils.IPacket;

public abstract class ClientConnectionHandler implements ConnectionHandler {
	
	protected IClient client;
	
	public ClientConnectionHandler(IClient client) {
		this.client = client;
	}
	
	protected void sendPacket(IPacket packet) throws IOException {
		client.sendPacket(packet);
	}
	
}
