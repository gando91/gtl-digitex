package gamingthelan.server;

import gamingthelan.netutils.IConnection;
import gamingthelan.netutils.IPacket;

import java.util.LinkedList;
import java.util.List;


public class Server implements IServer {

	private List<IConnection> clients = new LinkedList<IConnection>();
	private static Server instance;
	
	private Server(){
		//TODO Auto-generated method stub
	}
	
	public static Server getInstance() {
		
		if (instance == null) {
			instance = new Server();
		}
		
		return instance;
	}
	
	@Override
	public void addConnection(IConnection connessione) {
		// TODO Auto-generated method stub

		
	}

	@Override
	public void rmConnection(IConnection connessione) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void broadcastMessage(IPacket pacchetto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendMessage(IPacket pacchetto, IConnection connessione) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onReceivedPacket(IPacket packet) {
		// TODO Auto-generated method stub
		
	}
	
}
