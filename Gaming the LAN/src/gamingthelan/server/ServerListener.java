package gamingthelan.server;

import gamingthelan.netutils.ConnectionHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerListener implements IListener, Runnable {
	
	private IServer mediator;
	private int port = 1521; 
	private boolean listening;
	
	private ConnectionHandler handler;
	
	private static ServerListener instance;
	
	private ServerListener() {

	}
	
	public static ServerListener getInstance() {
		
		if (instance == null) {
			instance = new ServerListener();
		}
		
		return instance;
	}
	
	
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		if ( port > 80 && port < 99999)
			this.port = port;
	}

	@Override
	public void newGame(int port, ConnectionHandler handler) {
		mediator = Server.getInstance();
		
		this.handler = handler;
		setPort(port);
		
		Thread listener = new Thread(this);
		listening = true;
		listener.start();		
	}

	@Override
	public void run() {
		
		ServerSocket s = null;
		
		// Inizializzazione
		try {
			s = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Gestire eccezione apertura porta
			System.err.println("Errore durante l'apertura della porta");
		}
		
		while (listening) {			
			
			/*
			 * Bisogna progettare qualcosa per lasciare al programmatore
			 * la possibilità di ottenere informazioni sulla connessione in arrivo
			 */
			
			try {
				
				//TODO : Dare la possibilità al programmatore di decidere cosa fare della richiesta
				Socket socket = s.accept();				
				
				mediator.createConnection(socket, handler);
				
			} catch (IOException e) {
				// TODO Gestione eccezione in ascolto
				System.err.println("Errore durante la creazione della connessione per il client");
			}

		}
		
	}
}
