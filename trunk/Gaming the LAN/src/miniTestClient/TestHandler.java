package miniTestClient;

import javax.swing.JOptionPane;

import gamingthelan.client.ClientConnectionHandler;
import gamingthelan.client.IClient;
import gamingthelan.netutils.IPacket;
import gamingthelan.netutils.ObjectPacket;
import gamingthelan.netutils.servicepackets.DisconnectionPacket;

public class TestHandler extends ClientConnectionHandler {

	public TestHandler(IClient client) {
		super(client);
	}

	
	/*Implementiamo qui il metodo onReceivedPacket lasciato appositamente astratto all'interno della classe ClientConnectionHandler,
	indicando all'oggetto client le azioni da eseguire quando riceve un pacchetto di dati */
	
	@Override
	public void onReceivedPacket(IPacket packet) {
		ObjectPacket p  = (ObjectPacket)packet;
		
		if ( p.getContent() instanceof java.lang.String) {
			String s = (String)p.getContent();
			JOptionPane.showMessageDialog(null, p.getSender() + " : " + s, "Pacchetto stringa ricevuto", JOptionPane.INFORMATION_MESSAGE);
		} else 
		{
			Integer s = (Integer)p.getContent();
			JOptionPane.showMessageDialog(null,  p.getSender() + " : " + s.toString(), "Pacchetto 'Integer' ricevuto", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}


	@Override
	public void onDisconnectedClient(DisconnectionPacket packet) {
		String s = packet.getSender();
		JOptionPane.showMessageDialog(null,s + " si è disconnesso" , "Disconnessione", JOptionPane.INFORMATION_MESSAGE);
		
	}


	@Override
	public void onClosedConnection(String nickname) {
		// TODO Auto-generated method stub
		
	}

}
