package miniTestClient;

import gamingthelan.client.ClientConnectionHandler;
import gamingthelan.client.IClient;
import gamingthelan.netutils.IPacket;
import gamingthelan.netutils.ObjectPacket;

public class TestHandler extends ClientConnectionHandler {

	public TestHandler(IClient client) {
		super(client);
	}

	@Override
	public void onReceivedPacket(IPacket packet) {
		ObjectPacket p  = (ObjectPacket)packet;
		
		String s = (String)p.getContent();
		System.out.println("Ricevuto pacchetto " + s);
		
	}

}
