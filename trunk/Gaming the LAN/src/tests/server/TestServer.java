package tests.server;

import gamingthelan.server.ServerListener;

public class TestServer {

	public static void main(String[] args) {
		
		//Istanziamo un nuovo ServerListener, che si occupa di gestire le richieste di connessione da parte dei client
		ServerListener l = ServerListener.getInstance();
		
		//Il metodo newGame mette il nostro ServerListener in "ascolto" di richieste di connessione in arrivo sulla porta specificata
		l.newGame(8080, new ServerHandler());
		
		WaitingRoomPanel wrp = new WaitingRoomPanel();
		AppWaitingRoom awr = new AppWaitingRoom(wrp);
	}
	
}
