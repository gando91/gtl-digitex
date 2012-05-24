package battleship.server;

import java.io.IOException;
import java.util.HashMap;

import battleship.client.MissilePacket;
import battleship.client.ResponsePacket;
import gamingthelan.netutils.ConnectionHandler;
import gamingthelan.netutils.IPacket;
import gamingthelan.netutils.servicepackets.DisconnectionPacket;
import gamingthelan.server.Server;

public class ServerHandler implements ConnectionHandler {
	
public static final int MAXPLAYERS = 2;
	
	private HashMap<String, Boolean> players = new HashMap<String, Boolean>();
	private int nready = 0;
	private String first;
	private String second;
	ResponsePacket p;
	
	/*Implementiamo qui il metodo onReceivedPacket della classe ConnectionHandler, scegliendo come deve comportarsi il nostro 
	 * server nel momento in cui arriva un pacchetto */
	@Override
	public void onReceivedPacket(IPacket packet) {
		
		
		if(packet instanceof ResponsePacket){
		
			if ( ((ResponsePacket)packet).getResponse() == 0 ){
				ResponsePacket p = new ResponsePacket(null, packet.getSender(), 0);
				
				//Se il giocatore non c'è
				if ( !players.containsKey(packet.getSender()))
					players.put(packet.getSender(), Boolean.FALSE);
				
				Server.getInstance().sendMessage(p);
				
			}
			
			if(((ResponsePacket)packet).getResponse() == 500){
				
				System.out.println(packet.getSender());
				if(players.containsKey(packet.getSender()))
				{
					players.put(packet.getSender(), Boolean.TRUE);
					if(nready==0)
						first = packet.getSender();
					else
						second = packet.getSender();
					nready++;
				}
				
				if (nready == MAXPLAYERS)
				{
					
					ResponsePacket p = new ResponsePacket(null, null, 1000);
					try {
						Server.getInstance().broadcastMessage(p);
						ResponsePacket q = new ResponsePacket(null, first, 1500);
						Server.getInstance().sendMessage(q);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					nready = 0;
				}
				
				
			}
			
			if ( ((ResponsePacket)packet).getResponse() == 1 || ((ResponsePacket)packet).getResponse() == 2 ){
				
				if(packet.getSender().equals(first)){
					p = new ResponsePacket(null, second, ((ResponsePacket)packet).getResponse());
				}
				else{
					p = new ResponsePacket(null, first, ((ResponsePacket)packet).getResponse());
				}
				
				Server.getInstance().sendMessage(p);
				
			}
		}
		if(packet instanceof MissilePacket){
			if(packet.getSender().equals(first)){
				MissilePacket p = new MissilePacket(null, second, ((MissilePacket) packet).getRow(), ((MissilePacket) packet).getCol());
				Server.getInstance().sendMessage(p);
			}
			else{
				MissilePacket p = new MissilePacket(null, first, ((MissilePacket) packet).getRow(), ((MissilePacket) packet).getCol());
				Server.getInstance().sendMessage(p);
			}
		}
		
		
			
	}

	@Override
	public void onDisconnectedClient(DisconnectionPacket packet) {
		// TODO 
	}

}
