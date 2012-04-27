package MiniTestServer;

import gamingthelan.netutils.ConnectionHandler;
import gamingthelan.netutils.GenericObjectPacket;
import gamingthelan.netutils.IPacket;

public class ServerHandler implements ConnectionHandler {

	@Override
	public void onReceivedPacket(IPacket packet) {
		GenericObjectPacket p = (GenericObjectPacket)packet;
		
		System.out.println(p.getContent().toString());
	}

}
