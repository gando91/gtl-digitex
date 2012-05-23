package battleship.client;

import javax.swing.JFrame;

public class AppWaitingRoom extends JFrame{

private static final long serialVersionUID = 1L;	
	
	public AppWaitingRoom(WaitingRoomPanel wrp){
		
		setSize(400, 100);
		setTitle("Waiting Room");
		setResizable(false);
		add(wrp);
		setVisible(true);
	}	
}
