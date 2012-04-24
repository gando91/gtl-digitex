package miniTestClient;

import gamingthelan.netutils.ConnectionHandler;
import gamingthelan.netutils.IPacket;
import gamingthelan.netutils.Packet;

public class TestHandler implements ConnectionHandler{

	@Override
	public void onReceivedPacket(IPacket packet) {
		Packet p  = (Packet)packet;
		
		String s = (String)p.getContent();
		System.out.println("Ricevuto pacchetto " + s);
		
	}

}
