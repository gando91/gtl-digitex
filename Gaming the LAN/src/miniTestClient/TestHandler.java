package miniTestClient;

import gamingthelan.netutils.ConnectionHandler;
import gamingthelan.netutils.IPacket;

public class TestHandler implements ConnectionHandler{

	@Override
	public void onReceivedPacket(IPacket packet) {
		String s = (String) packet.getContent();
		System.out.println("Ricevuto pacchetto dall'indirizzo ip: "+packet.getSender().getSocket()+", contenente il messaggio cifrato: "+s);
		
	}

}
