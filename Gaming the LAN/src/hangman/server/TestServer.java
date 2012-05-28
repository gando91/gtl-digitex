package hangman.server;

import gamingthelan.server.ServerListener;
import hangman.server.ServerHandler;

public class TestServer {

	public static void main(String[] args) {
		System.out.println(" --- L'impiccato ---");
		System.out.println(" by Gruppo Digitex  ");
		
		//Istanziamo un nuovo ServerListener, che si occupa di gestire le richieste di connessione da parte dei client
		ServerListener l = ServerListener.getInstance();
		
		System.out.println("Avvio del server listener sulla porta 8080 ...");
		//Il metodo newGame mette il nostro ServerListener in "ascolto" di richieste di connessione in arrivo sulla porta specificata
		l.newGame(8080, new ServerHandler());
		System.out.println("Server avviato correttamente");
	}
	
}