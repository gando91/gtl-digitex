package hangman.server;


import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


import gamingthelan.netutils.ConnectionHandler;
import gamingthelan.netutils.IPacket;
import gamingthelan.netutils.servicepackets.DisconnectionPacket;
import gamingthelan.server.Server;
import hangman.packets.DeadPacket;
import hangman.packets.LetterPacket;
import hangman.packets.ProtocolPacket;
import hangman.packets.WordPacket;
import hangman.packets.WrongPacket;

public class ServerHandler implements ConnectionHandler {
	
	public static final int MAXPLAYERS = 2;
	public static final int HANGMANDEATH = 10;
	
	private HashMap<String, Boolean> players = new HashMap<String, Boolean>();	
	private String[] player = new String[MAXPLAYERS];
	private int nready = 0;
	private int turn = 0;	
	private Words words;
	private List<String> parole = new LinkedList<String>();
	private ProtocolPacket p;
	
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
				
				if(players.containsKey(packet.getSender())){
					
					players.put(packet.getSender(), Boolean.TRUE);
					player[nready]=packet.getSender();
					nready++;
				}
				
				if (nready == MAXPLAYERS){
					
					ProtocolPacket p = new ProtocolPacket(null, null, 1000);
					
					try {
						// Dico a tutti che abbiamo raggiunto il tetto massimo di giocatori pronti
						Server.getInstance().broadcastMessage(p);							
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println(player[turn]);
					
					WordPacket w = new WordPacket(null, null, CurrentWord.getInstance().getVisibleString());
					
					try {
						// Mando a tutti la parola da indovinare.
						Server.getInstance().broadcastMessage(w);
						
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					// Dico al primo giocatore che è il suo turno. 
					ProtocolPacket q = new ProtocolPacket(null, player[turn], 1500);
					Server.getInstance().sendMessage(q);									
					
					System.out.println("Partita Avviata !");
					
					nready = 0;
				}				
			}			
		}
		
		if(packet instanceof LetterPacket){
			
			int answer = CurrentWord.getInstance().letterCheck(((LetterPacket)packet).getLetter());			
			
			// Se la lettera non è corretta.
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
				
				else{
					
					try {
						Server.getInstance().broadcastMessage(new DeadPacket());
						
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}			
			
			// Se la lettera è corretta ma non ha vinto nessuno.
			if(answer == 1){
				WordPacket wp = new WordPacket(null, null, CurrentWord.getInstance().getVisibleString());
				
				try {
					Server.getInstance().broadcastMessage(wp);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
			
			// Se la lettera è corretta e ha vinto il giocatore di turno.
			if(answer == 2){
				WordPacket wp = new WordPacket(player[turn], "9002", CurrentWord.getInstance().getVisibleString());
				
				try {
					Server.getInstance().broadcastMessage(wp);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
			
			turnGoOn();
		}
		
		// Se un client mi ha mandato un pacchetto "I FEEL LUCKY" che è effettivamente un WordPacket
		if(packet instanceof WordPacket){
			
			WordPacket wp;
			
			// Se la parola corrente è uguale a quella inviata dal giocatore di turno
			if(CurrentWord.getInstance().getWord().equalsIgnoreCase(((WordPacket)packet).getWord()))
				wp = new WordPacket(player[turn], "9002", CurrentWord.getInstance().getWord());				
			else
				wp = new WordPacket(player[turn], "9003", CurrentWord.getInstance().getWord());
			
			try {
				Server.getInstance().broadcastMessage(wp);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			turnGoOn();
		}		
		
	}
			

	@Override
	public void onDisconnectedClient(DisconnectionPacket packet) {
		// TODO 
	}
	
	public void turnGoOn(){
		
		turn++;
		
		if(turn == MAXPLAYERS)
			turn = 0;
		
		ProtocolPacket q = new ProtocolPacket(null, player[turn], 1500);
		Server.getInstance().sendMessage(q);
	}

}
