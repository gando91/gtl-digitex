package hangman.client;

import java.io.IOException;

import javax.swing.JOptionPane;

import gamingthelan.client.ClientConnectionHandler;
import gamingthelan.client.IClient;
import gamingthelan.netutils.IPacket;
import gamingthelan.netutils.servicepackets.DisconnectionPacket;
import hangman.utils.MainPanel;
import hangman.utils.ProtocolPacket;
import hangman.utils.WordPacket;
import hangman.utils.WrongPacket;

public class PacketHandler extends ClientConnectionHandler{
	
	private int state = 0;
	private MainPanel panel;
	
	public PacketHandler(IClient client) {
		super(client);
		
	}

	@Override
	public void onReceivedPacket(IPacket packet) {
		
		
		if (state == 0)
		{
			if ( ((ProtocolPacket)packet).getCode() == 0 ){
				ProtocolPacket p = new ProtocolPacket(this.client.getConnection().getNickName(), null, 500);
				try {
					this.client.sendPacket(p);
					state = 1;
					System.out.println("AAAAAA");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		}
		else if (state == 1) {
			
			if(packet instanceof ProtocolPacket){
				
				if ( ((ProtocolPacket)packet).getCode() == 1000 ){
					panel = new MainPanel(null, this.client);
					System.out.println("ciaooooo");
					
				}
			}
			
			if(packet instanceof WordPacket){
				
				panel.setWord(((WordPacket)packet).getWord());
				state = 2;
			}
		}		
		 else if (state == 2) {
			if(packet instanceof WordPacket){
				panel.setWord(((WordPacket)packet).getWord());
				if(packet.getSender() != null){
					JOptionPane.showMessageDialog(null, packet.getSender()+" ha indovinato la parola !");
					panel.setEnabled(false);
				}
			}
			if(packet instanceof WrongPacket){
				panel.hangUp(((WrongPacket)packet).getStatus());
				JOptionPane.showMessageDialog(null, "La lettera '"+((WrongPacket)packet).getLetter() +"' inserita da " + ((WrongPacket)packet).getDelinquent() + " non è presente");
				panel.setEnabled(false);
			}
			if(packet instanceof ProtocolPacket){
				if(((ProtocolPacket)packet).getCode() == 1500){
					panel.setEnabled(true);
				}
			}
			
		}
}
	

	@Override
	public void onDisconnectedClient(DisconnectionPacket packet) {
		// TODO Auto-generated method stub		
	}

}