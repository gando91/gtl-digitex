package hangman.server;


import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


import gamingthelan.netutils.ConnectionHandler;
import gamingthelan.netutils.IPacket;
import gamingthelan.netutils.servicepackets.DisconnectionPacket;
import gamingthelan.server.Server;
import hangman.utils.CurrentWord;
import hangman.utils.ProtocolPacket;
import hangman.utils.WordPacket;
import hangman.utils.Words;

public class ServerHandler implements ConnectionHandler {
	
	public static final int MAXPLAYERS = 3;
	
	private HashMap<String, Boolean> players = new HashMap<String, Boolean>();
	private int nready = 0;
	private String[] player = new String[MAXPLAYERS];
	ProtocolPacket p;
	private List<String> parole = new LinkedList<String>();
	Words words;
	
	/*Implementiamo qui il metodo onReceivedPacket della classe ConnectionHandler, scegliendo come deve comportarsi il nostro 
	 * server nel momento in cui arriva un pacchetto */
	public ServerHandler(){
		parole.add("Dagrada");
		parole.add("Maiocchi");
		parole.add("Villa");
		
		words = new Words(parole);
		CurrentWord.getInstance().setCurrentWord(words.getRndWord());
	}
	
	@Override
	public void onReceivedPacket(IPacket packet) {
		
		
		if(packet instanceof ProtocolPacket){
		
			if ( ((ProtocolPacket)packet).getCode() == 0 ){
				ProtocolPacket p = new ProtocolPacket(null, packet.getSender(), 0);
				
				//Se il giocatore non c'è
				if ( !players.containsKey(packet.getSender()))
					players.put(packet.getSender(), Boolean.FALSE);
				
				Server.getInstance().sendMessage(p);
				
			}
			
			if(((ProtocolPacket)packet).getCode() == 500){
				
				System.out.println(packet.getSender() + " è pronto");
				if(players.containsKey(packet.getSender()))
				{
					players.put(packet.getSender(), Boolean.TRUE);
					player[nready]=packet.getSender();
					nready++;
				}
				
				if (nready == MAXPLAYERS)
				{
					
					ProtocolPacket p = new ProtocolPacket(null, null, 1000);
					try {
						Server.getInstance().broadcastMessage(p);
						ProtocolPacket q = new ProtocolPacket(null, player[0], 1500);
						Server.getInstance().sendMessage(q);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					WordPacket w = new WordPacket(null, null, CurrentWord.getInstance().getVisibleString());
					try {
						Server.getInstance().broadcastMessage(w);
					} catch (IOException e) {
						e.printStackTrace();
					}
					System.out.println("Partita Avviata !");
					nready = 0;
				}
				
			}
		}
			
			
		
		
			
	}

	@Override
	public void onDisconnectedClient(DisconnectionPacket packet) {
		// TODO 
	}

}
