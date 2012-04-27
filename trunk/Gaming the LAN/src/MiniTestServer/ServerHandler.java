package MiniTestServer;

import java.io.IOException;

import gamingthelan.netutils.ConnectionHandler;
import gamingthelan.netutils.GenericObjectPacket;
import gamingthelan.netutils.IPacket;
import gamingthelan.server.Server;

public class ServerHandler implements ConnectionHandler {

	@Override
	public void onReceivedPacket(IPacket packet) {
		GenericObjectPacket p = (GenericObjectPacket)packet;
		
		System.out.println(p.getContent().toString());
		p.setContent("Risposta dal server");
		
		try {
			Server.getInstance().broadcastMessage(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
