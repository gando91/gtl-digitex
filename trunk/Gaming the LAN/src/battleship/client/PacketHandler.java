package battleship.client;

import javax.swing.JOptionPane;

import battleship.game.MatrixModel;
import battleship.positioning.AppPositioning;
import battleship.positioning.ProxyShip;
import battleship.positioning.SettingsView;


import gamingthelan.client.ClientConnectionHandler;
import gamingthelan.client.IClient;
import gamingthelan.netutils.IPacket;
import gamingthelan.netutils.ObjectPacket;
import gamingthelan.netutils.servicepackets.DisconnectionPacket;

public class PacketHandler extends ClientConnectionHandler{
	
	private boolean started = false;

	public PacketHandler(IClient client) {
		super(client);
	}

	private ObjectPacket packet;

	@Override
	public void onReceivedPacket(IPacket packet) {
		
		if(started == false){		
			//TODO
		}
		
		if(started){
			//TODO: implementare la gestione del pacchetto durante la partita
		}
	}

	@Override
	public void onDisconnectedClient(DisconnectionPacket packet) {
		// TODO Auto-generated method stub		
	}

}
