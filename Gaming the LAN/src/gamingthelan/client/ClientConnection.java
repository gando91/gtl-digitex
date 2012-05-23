package gamingthelan.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import gamingthelan.netutils.ConnectionHandler;
import gamingthelan.netutils.IConnection;
import gamingthelan.netutils.IPacket;
import gamingthelan.netutils.servicepackets.CheckPacket;
import gamingthelan.netutils.servicepackets.DisconnectionPacket;
import gamingthelan.netutils.servicepackets.NickPacket;

public class ClientConnection implements IConnection, Runnable {

	private static final long serialVersionUID = -7609843393259243743L;

	private Socket socket;	
	private ObjectInputStream inStream;
    private ObjectOutputStream outStream;    
    private ConnectionHandler handler;    
    private boolean connected = true;    
	private String nickName;
	
	public ClientConnection(Socket socket, ConnectionHandler handler, String nickName) {
		
		this.socket = socket;
		
		try {
			outStream = new ObjectOutputStream(socket.getOutputStream());
			outStream.flush();
            inStream = new ObjectInputStream(socket.getInputStream());
            
		} catch (IOException e) {
            System.err.println("Errore durante la creazione degli stream di connessione");
		}
		
		this.handler = handler;		
		this.nickName = nickName;
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
		
		NickPacket nick = new NickPacket(nickName);
		int retry = 0;
		
		while (retry < 3)
		{
			try {
				sendPacket(nick);
			} catch (IOException e1) {
				retry++;
			}
		}
		
		if (retry >= 3)
			disconnect();
		
		IPacket received = null;
		
		while (connected) {
			
			try {
				
				received = (IPacket) inStream.readObject();
				if(received instanceof DisconnectionPacket){
					handler.onDisconnectedClient((DisconnectionPacket)received);
				} else if (received instanceof CheckPacket)
				{
					//rispondo che ci sono
					sendPacket(received);
				} else
					handler.onReceivedPacket(received);
				
			} catch (IOException e) {
				connected = false;
			} catch (ClassNotFoundException e) {
				connected = false;				
			}			
		}
		
		closeConnection();		
	}

	private void closeConnection() {
		try {
			
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
		closeConnection();
	}

	@Override
	public String getNickName() {
		return nickName;
	}
}
