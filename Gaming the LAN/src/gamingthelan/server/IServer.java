package gamingthelan.server;

import gamingthelan.netutils.IConnection;
import gamingthelan.netutils.IPacket;


public interface IServer {
	
	public void addConnection(IConnection connessione);
	public void rmConnection(IConnection connessione);
	
	public void broadcastMessage(IPacket pacchetto);
	public void sendMessage(IPacket pacchetto, IConnection connessione);
	
	public void onReceivedPacket(IPacket packet);
	
}