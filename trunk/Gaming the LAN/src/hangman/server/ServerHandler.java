package hangman.server;


import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


import gamingthelan.netutils.ConnectionHandler;
import gamingthelan.netutils.IPacket;
import gamingthelan.netutils.servicepackets.DisconnectionPacket;
import gamingthelan.server.Server;
import hangman.packets.LetterPacket;
import hangman.packets.ProtocolPacket;
import hangman.packets.WordPacket;
import hangman.packets.WrongPacket;

public class ServerHandler implements ConnectionHandler {
	
	public static final int MAXPLAYERS = 2;
	public static final int HANGMANDEATH = 10;
	
	private HashMap<String, Boolean> players = new HashMap<String, Boolean>();
	private int nready = 0;
	private String[] player = new String[MAXPLAYERS];
	private ProtocolPacket p;
	private List<String> parole = new LinkedList<String>();
	private Words words;
	private int turn = 0;
	private int hangmanstatus;
	
	/*Implementiamo qui il metodo onReceivedPacket della classe ConnectionHandler, scegliendo come deve comportarsi il nostro 
	 * server nel momento in cui arriva un pacchetto */
	public ServerHandler(){
		parole.add("dagrada");
		parole.add("maiocchi");
		parole.add("villa");
		parole.add("guantanamo");
		parole.add("asterisco");
		parole.add("zuzzurellone");
		parole.add("maiocchiculo");
		
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
						System.out.println("CACCA");
						ProtocolPacket q = new ProtocolPacket(null, player[turn], 1500);
						Server.getInstance().sendMessage(q);
						System.out.println(player[turn]);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					WordPacket w = new WordPacket(null, null, CurrentWord.getInstance().getVisibleString());
					try {
						Server.getInstance().broadcastMessage(w);
						System.out.println(CurrentWord.getInstance().getVisibleString());
					} catch (IOException e) {
						e.printStackTrace();
					}
					System.out.println("Partita Avviata !");
					nready = 0;
				}				
			}			
		}
		
		if(packet instanceof LetterPacket){
			
			int answer = CurrentWord.getInstance().letterCheck(((LetterPacket)packet).getLetter());			
			
			if(answer == 0){
				hangmanstatus++;
				if(hangmanstatus != HANGMANDEATH){
					WrongPacket a = new WrongPacket(packet.getSender(), ((LetterPacket)packet).getLetter(), hangmanstatus);
					
					try {
						Server.getInstance().broadcastMessage(a);
						
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}			
			
			if(answer == 1){
				WordPacket wp = new WordPacket(null, null, CurrentWord.getInstance().getVisibleString());
				try {
					Server.getInstance().broadcastMessage(wp);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
			
			if(answer == 2){
				WordPacket wp = new WordPacket(player[turn], null, CurrentWord.getInstance().getVisibleString());
				try {
					Server.getInstance().broadcastMessage(wp);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
			
			turnGoOn();
		}
		
		if(packet instanceof WordPacket){
			
			WordPacket wp;
			
			if(CurrentWord.getInstance().getWord() == ((WordPacket)packet).getWord()){
				wp = new WordPacket(player[turn], null, CurrentWord.getInstance().getWord());
				
			}
			else
				wp = new WordPacket(null, null, CurrentWord.getInstance().getWord());
			
			try {
				Server.getInstance().broadcastMessage(wp);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}				
		}
		
		turnGoOn();
	}
			

	@Override
	public void onDisconnectedClient(DisconnectionPacket packet) {
		// TODO 
	}
	
	public void turnGoOn(){
		if(turn == MAXPLAYERS){
			turn++;
		}
		else
			turn = 0;
		
		ProtocolPacket q = new ProtocolPacket(null, player[turn], 1500);
		Server.getInstance().sendMessage(q);
	}

}
