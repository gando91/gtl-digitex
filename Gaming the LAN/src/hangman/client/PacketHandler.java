package hangman.client;

import java.io.IOException;

import javax.swing.JOptionPane;

import gamingthelan.client.ClientConnectionHandler;
import gamingthelan.client.IClient;
import gamingthelan.netutils.IPacket;
import gamingthelan.netutils.servicepackets.DisconnectionPacket;
import hangman.connection.WaitingWindow;
import hangman.packets.DeadPacket;
import hangman.packets.ProtocolPacket;
import hangman.packets.WordPacket;
import hangman.packets.WrongPacket;

public class PacketHandler extends ClientConnectionHandler{
	
	private int state = 0;
	private MainPanel panel;
	private WaitingWindow waitingwindow;
	
	public PacketHandler(IClient client) {
		super(client);		
	}

	@Override
	public void onReceivedPacket(IPacket packet) {		
		
		if (state == 0){			
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
		}
		else if (state == 1) {
			
			if(packet instanceof ProtocolPacket){				
				if ( ((ProtocolPacket)packet).getCode() == 1000 ){
					
					closeWaitingWindow();
					panel = new MainPanel(null, this.client);
				}
			}
			
			// Se arriva il pacchetto con la parola da indovinare
			if(packet instanceof WordPacket){
				
				panel.setWord(((WordPacket)packet).getWord());
				state = 2;
			}
		}		
		else if (state == 2) {
			
			if(packet instanceof WordPacket){				
				
				panel.setWord(((WordPacket)packet).getWord());
				
				if(packet.getSender() != null){					
					
					if(((WordPacket)packet).getReceiver().get(0).equalsIgnoreCase("9002")){						
						JOptionPane.showMessageDialog(null, packet.getSender() + " ha indovinato la parola !");					
						System.exit(1);
					}
					
					if(((WordPacket)packet).getReceiver().get(0).equalsIgnoreCase("9003")){
						JOptionPane.showMessageDialog(null, packet.getSender() + " ha pensato alla parola " +
								((WordPacket)packet).getWord() + " ma non è quella giusta !");
					}
				}
				
				panel.setEnabled(false);
			}
			
			if(packet instanceof WrongPacket){
				
				panel.hangUp(((WrongPacket)packet).getStatus());
				JOptionPane.showMessageDialog(null, "La lettera '"+((WrongPacket)packet).getLetter() +"' inserita da " + ((WrongPacket)packet).getDelinquent() + " non è presente");
				
				panel.setEnabled(false);
			}
			
			if(packet instanceof ProtocolPacket){
				
				// Se è il mio turno 
				if(((ProtocolPacket)packet).getCode() == 1500){
					panel.setEnabled(true);
				}
			}
			
			if(packet instanceof DeadPacket){
				panel.hangUp(((DeadPacket)packet).getHangmandeath());
				JOptionPane.showMessageDialog(null, "Nessuno è riuscito a indovinare la parola!");
				
				System.exit(1);
			}
		}
	}
	

	@Override
	public void onDisconnectedClient(DisconnectionPacket packet) {
		// TODO Auto-generated method stub		
	}
	
	public void openWaitingWindow(){
		this.waitingwindow = new WaitingWindow();
	}
	
	private void closeWaitingWindow(){
		this.waitingwindow.closeFrame();
	}

	@Override
	public void onClosedConnection(String nickname) {
		// TODO Auto-generated method stub
		
	}

}