package hangman.client;

import java.io.IOException;

import gamingthelan.client.ClientConnectionHandler;
import gamingthelan.client.IClient;
import gamingthelan.netutils.IPacket;
import gamingthelan.netutils.servicepackets.DisconnectionPacket;
import hangman.utils.MainPanel;
import hangman.utils.ProtocolPacket;
import hangman.utils.WordPacket;

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
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
			}
			
		else if (state == 1) {
			if ( ((ProtocolPacket)packet).getCode() == 1000 ){
				panel = new MainPanel(null);
				state = 2;
				
			}
					
		 else if (state == 2) {
			if(packet instanceof WordPacket){
				panel.setWord(((WordPacket)packet).getWord());
			}
			
		}
		}
		}
	}

	@Override
	public void onDisconnectedClient(DisconnectionPacket packet) {
		// TODO Auto-generated method stub		
	}

}