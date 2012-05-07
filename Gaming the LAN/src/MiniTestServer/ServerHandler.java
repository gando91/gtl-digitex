package MiniTestServer;

import java.io.IOException;

import gamingthelan.netutils.ConnectionHandler;
import gamingthelan.netutils.ObjectPacket;
import gamingthelan.netutils.IPacket;
import gamingthelan.server.Server;

public class ServerHandler implements ConnectionHandler {

	/*Implementiamo qui il metodo onReceivedPacket della classe ConnectionHandler, scegliendo come deve comportarsi il nostro 
	 * server nel momento in cui arriva un pacchetto */
	@Override
	public void onReceivedPacket(IPacket packet) {
		ObjectPacket p = (ObjectPacket)packet;
		
		System.out.println(p.getContent().toString());
		
		try {
			//Per semplicità, in questa applicazione di test, mandiamo il pacchetto ricevuto a tutti i client connessi
			Server.getInstance().broadcastMessage(p);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
