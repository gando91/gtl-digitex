package gamingthelan.netutils;

import java.util.List;

import gamingthelan.server.Server;

public class BroadcastPacket extends Packet{
	
	@Override
	public List<IConnection> getReceiver() {
		return Server.getInstance().getClients();
	}

}
