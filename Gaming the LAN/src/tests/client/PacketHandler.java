package tests.client;

import javax.swing.JOptionPane;

import tests.positioning.AppPositioning;
import tests.positioning.ProxyShip;
import tests.positioning.SettingsView;

import gamingthelan.client.ClientConnectionHandler;
import gamingthelan.client.IClient;
import gamingthelan.netutils.IPacket;
import gamingthelan.netutils.ObjectPacket;
import gamingthelan.netutils.servicepackets.DisconnectionPacket;

public class PacketHandler extends ClientConnectionHandler{
	
	private boolean ready = false;
	private boolean started = false;

	public PacketHandler(IClient client) {
		super(client);
	}

	private ObjectPacket packet;

	@Override
	public void onReceivedPacket(IPacket packet) {
		
		if(ready && started == false){		
			if(packet instanceof StartPacket){
				started = true;
				JOptionPane.showMessageDialog(null, "Partita iniziata!", "Info", JOptionPane.INFORMATION_MESSAGE);
				
				//TODO: qui è necessario aprire la finestra di gioco
				AppPositioning ap = new AppPositioning(null);
			}
		}
		
		if(started){
			//TODO: implementare la gestione del pacchetto durante la partita
		}
	}

	@Override
	public void onDisconnectedClient(DisconnectionPacket packet) {
		// TODO Auto-generated method stub		
	}
	
	public void ready(){
		this.ready = true;
	}

}
