package gamingthelan.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import gamingthelan.client.NickPacket;
import gamingthelan.netutils.ConnectionHandler;
import gamingthelan.netutils.IConnection;
import gamingthelan.netutils.IPacket;

public class ServerConnection implements IConnection, Runnable{
	
	private static final long serialVersionUID = -7609843393259243743L;
	
	private IServer mediator;
	private String nickname;
	private Socket socket;	
	private ObjectInputStream inStream;
    private ObjectOutputStream outStream;    
    private ConnectionHandler handler;    
    private boolean connected = true;    
	
	public ServerConnection(Socket socket, ConnectionHandler handler) {		
		
		mediator = Server.getInstance();
		this.socket = socket;
		
		try {
			outStream = new ObjectOutputStream(socket.getOutputStream());
			outStream.flush();
            inStream = new ObjectInputStream(socket.getInputStream());
            
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
		outStream.writeObject(packet);
		outStream.flush();
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
				
				if(received instanceof NickPacket){
					this.nickname = ((NickPacket) received).getNickName();
				}
				else{
					handler.onReceivedPacket(received);
				}				
				
			} catch (IOException e) {
				connected = false;
			} catch (ClassNotFoundException e) {
				connected = false;				
			}			
		}
		
		try {
			
			mediator.rmConnection(this);
			
			outStream.close();
			inStream.close();
			socket.close();
			
		} catch (IOException e) {
			//TODO : E' poco carino sopprimere un'eccezione. Tuttavia, quando arrivo quì può essere successo di tutto. La connessione è persa. Forse non importa a nessuno di raccogliere questa eccezione.
		}		
	}

	@Override
	public void addToPacketQueue(IPacket packet) throws IOException {
		outStream.writeObject(packet);		
	}

	@Override
	public void sendQueue() throws IOException {
		outStream.flush();		
	}

	@Override
	public boolean isAlive() {
		return connected;
	}
	
	@Override
	public void disconnect() {
		this.connected = false;
	}

}
