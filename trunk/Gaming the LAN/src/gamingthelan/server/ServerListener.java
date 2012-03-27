package gamingthelan.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerListener implements IListener, Runnable {
	
	private IServer mediator;
	private int port = 1521; 
	private boolean listening;
	
	private ServerListener instance;
	
	private ServerListener() {

	}
	
	public ServerListener getInstance() {
		
		if (instance == null) {
			instance = new ServerListener();
		}
		
		return instance;
	}
	
	
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public void newGame(int port) {
		mediator = Server.getInstance();

		Thread listener = new Thread(this);
		listener.start();
		listening = true;
	}

	@Override
	public void run() {
		
		//FIXME : Istanziare una classe abstract (non zi pote, come fare per farlo fare al programmatore ?)
		ServerSocket s = null;
		
		// Inizializzazione
		try {
			s = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while (listening) {
			
			try {
				Socket socket = s.accept();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			/*
			 * Bisogna creare un nuovo oggetto di tipo IConnection
			 * e avviarlo in un nuovo thread
			 * poi bisogna aggiunegere la nuova connessione al server
			 * 
			 * Il problema è che la nostra connessione è astratta... chi mi da una mano ragazzi ?
			 * 
			Client c = new  Client(socket, count, mediator);
			Thread t = new Thread(c);
			mediatore.addClient(c);
			
			t.start();
			*/

		}
		
	}
}
