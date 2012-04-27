package miniTestClient;

import gamingthelan.client.ClientConnectionHandler;
import gamingthelan.client.IClient;
import gamingthelan.netutils.IPacket;
import gamingthelan.netutils.GenericObjectPacket;

public class TestHandler extends ClientConnectionHandler {

	public TestHandler(IClient client) {
		super(client);
	}

	@Override
	public void onReceivedPacket(IPacket packet) {
		GenericObjectPacket p  = (GenericObjectPacket)packet;
		
		String s = (String)p.getContent();
		System.out.println("Ricevuto pacchetto " + s);
		
		p.setContent("Risposta");
		sendPacket(p);
		
	}

}
