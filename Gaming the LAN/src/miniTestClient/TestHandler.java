package miniTestClient;

import gamingthelan.netutils.ConnectionHandler;
import gamingthelan.netutils.IPacket;

public class TestHandler implements ConnectionHandler{

	@Override
	public void onReceivedPacket(IPacket packet) {
		MyPacket p  = (MyPacket)packet;
		
		String s = p.getContent();
		System.out.println("Ricevuto pacchetto " + s);
		
	}

}
