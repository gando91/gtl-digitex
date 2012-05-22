package tests.connection;

import gamingthelan.netutils.ConnectionHandler;
import gamingthelan.netutils.IPacket;
import gamingthelan.netutils.ObjectPacket;

public class PacketHandler implements ConnectionHandler{

	private ObjectPacket packet;

	@Override
	public void onReceivedPacket(IPacket packet) {
		
		this.packet = (ObjectPacket) packet;
		System.out.println(this.packet.getContent().toString());
	}

}
