package battleship.waitingroom;

import java.awt.GridLayout;
import javax.swing.JPanel;

import battleship.client.PacketHandler;

public class WaitingRoomPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	//private JButton ready, disconnect;
	private PacketHandler handler;

	public WaitingRoomPanel(PacketHandler handler) {
		
		this.handler = handler;
		
		setLayout(new GridLayout(1,2));
		
	}
	
	public PacketHandler getHandler(){
		return handler;
	}

}
