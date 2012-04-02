package gamingthelan.netutils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import gamingthelan.server.IServer;
import gamingthelan.server.Server;

public class Connection implements IConnection, Runnable {

	private ObjectInputStream inStream;
    private ObjectOutputStream outStream;
    
    private ConnectionHandler handler;
    
    private boolean connected = true;
    
	IServer mediator;
	
	public Connection(Socket socket, ConnectionHandler handler) {
		
		mediator = Server.getInstance();
		
		//TODO : Convertire tutto in I/O bufferizzato *se possibile*
		try {
            
            inStream = new ObjectInputStream(socket.getInputStream());
            outStream = new ObjectOutputStream(socket.getOutputStream());
            
		} catch (IOException e) {
            System.err.println("Errore durante la creazione degli stream di connessione");
		}
		
		this.handler = handler;
		
	}
	
	@Override
	public void sendPacket(IPacket packet) throws IOException {
		
		outStream.writeObject(packet);
		
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
