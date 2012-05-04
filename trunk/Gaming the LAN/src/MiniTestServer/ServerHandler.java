package MiniTestServer;

import java.io.IOException;

import gamingthelan.netutils.ConnectionHandler;
import gamingthelan.netutils.ObjectPacket;
import gamingthelan.netutils.IPacket;
import gamingthelan.server.Server;

public class ServerHandler implements ConnectionHandler {

	@Override
	public void onReceivedPacket(IPacket packet) {
		ObjectPacket p = (ObjectPacket)packet;
		
		System.out.println(p.getContent().toString());
		p.setContent("Risposta dal server");
		
		try {
			Server.getInstance().broadcastMessage(p);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
