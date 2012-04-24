package gamingthelan.netutils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import gamingthelan.server.IServer;
import gamingthelan.server.Server;

public class Connection implements IConnection, Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7609843393259243743L;

	private Socket socket;
	
	private ObjectInputStream inStream;
    private ObjectOutputStream outStream;
    
    private ConnectionHandler handler;
    
    private boolean connected = true;
    
	IServer mediator;
	
	public Connection(Socket socket, ConnectionHandler handler) {
		
		mediator = Server.getInstance();
		this.socket = socket;
		
		try {
			outStream = new ObjectOutputStream(socket.getOutputStream());
			outStream.flush();
            inStream = new ObjectInputStream(socket.getInputStream());
            
            System.out.println("Connessione : Stream creati");
            
		} catch (IOException e) {
            System.err.println("Errore durante la creazione degli stream di connessione");
		}
		
		this.handler = handler;
		
	}
	
	public Socket getSocket() {
		return socket;
	}

	@Override
	public void sendPacket(IPacket packet) throws IOException {
		System.out.println("Connessione : inizio invio pacchetto");
		outStream.writeObject(packet);
		outStream.flush();
		System.out.println("Connessione : Pacchetto spedito");
	}

	/*
	 * Questo è il thread che legge quello che arriva dalla rete
	 * Quando arriverà un pacchetto lo dice al mediator
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		
		IPacket received = null;
		
		while (connected) {
			
			try {
				
				received = (IPacket) inStream.readObject();
				System.out.println("Pacchetto ricevuto");
				
				handler.onReceivedPacket(received);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				connected = false;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				connected = false;
				
			}
			
			
		}
		
		
	}

}
