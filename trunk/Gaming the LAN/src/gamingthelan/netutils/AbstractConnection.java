package gamingthelan.netutils;

import gamingthelan.server.IServer;

public abstract class AbstractConnection implements IConnection, Runnable {

	IServer mediator;
	
	
	@Override
	public void sendPacket(IPacket packet) {
		// TODO Auto-generated method stub
		
	}
	
	//Questo lo lasciamo implementare all'utente delle librerie
	@Override
	public abstract void onReceivedPacket(IPacket packet);
	
	
	@Override
	public void run() {
		// TODO Gestisce e chiama il metodo onReceivedPacket()
		
	}
	
}
