package battleship.server;

import battleship.client.ResponsePacket;
import battleship.game.AppGame;
import battleship.positioning.AppPositioning;
import gamingthelan.netutils.ConnectionHandler;
import gamingthelan.netutils.IPacket;
import gamingthelan.netutils.ObjectPacket;
import gamingthelan.netutils.servicepackets.DisconnectionPacket;
import gamingthelan.server.Server;

public class ServerHandler extends MiniTestServer.ServerHandler {

	private int state = 0;
	/*Implementiamo qui il metodo onReceivedPacket della classe ConnectionHandler, scegliendo come deve comportarsi il nostro 
	 * server nel momento in cui arriva un pacchetto */
	@Override
	public void onReceivedPacket(IPacket packet) {
		
		
		if (state == 0)
		{
			if ( ((ResponsePacket)packet).getResponse() == 0 ){
				ResponsePacket p = new ResponsePacket(null, packet.getSender(), 0);
				Server.getInstance().sendMessage(p);
				state = 1;
			}
			
		}else if (state == 1) {
			if(((ResponsePacket)packet).getResponse() == 1000){
				
				state = 2;
			}
			
		} else if (state == 2) {
			
		}
		
//		ObjectPacket p = (ObjectPacket)packet;
//		
//		System.out.println(p.getContent().toString());
//		
//		//Per semplicità, in questa applicazione di test, mandiamo il pacchetto ricevuto a tutti i client connessi
//		Server.getInstance().sendMessage(p);
	}

	@Override
	public void onDisconnectedClient(DisconnectionPacket packet) {
		// TODO Auto-generated method stub		
	}

}
