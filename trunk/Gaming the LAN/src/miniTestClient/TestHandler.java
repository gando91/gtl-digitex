package miniTestClient;

import javax.swing.JOptionPane;

import gamingthelan.client.ClientConnectionHandler;
import gamingthelan.client.IClient;
import gamingthelan.netutils.IPacket;
import gamingthelan.netutils.ObjectPacket;

public class TestHandler extends ClientConnectionHandler {

	public TestHandler(IClient client) {
		super(client);
	}

	@Override
	public void onReceivedPacket(IPacket packet) {
		ObjectPacket p  = (ObjectPacket)packet;
		
		if ( p.getContent() instanceof java.lang.String) {
			String s = (String)p.getContent();
			JOptionPane.showMessageDialog(null, s, "Pacchetto stringa ricevuto", JOptionPane.INFORMATION_MESSAGE);
		} else 
		{
			Integer s = (Integer)p.getContent();
			JOptionPane.showMessageDialog(null, s.toString(), "Pacchetto 'Integer' ricevuto", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}

}
