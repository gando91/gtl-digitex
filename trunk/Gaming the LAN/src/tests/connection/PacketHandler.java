package tests.connection;

import gamingthelan.client.ClientConnectionHandler;
import gamingthelan.client.IClient;
import gamingthelan.netutils.IPacket;
import gamingthelan.netutils.ObjectPacket;

public class PacketHandler extends ClientConnectionHandler{

	public PacketHandler(IClient client) {
		super(client);
	}

	private ObjectPacket packet;

	@Override
	public void onReceivedPacket(IPacket packet) {
		
		this.packet = (ObjectPacket) packet;
		System.out.println(this.packet.getContent().toString());
	}

}
