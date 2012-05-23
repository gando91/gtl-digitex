package battleship.splashscreen;

import javax.swing.JFrame;

public class CreditsFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_HEIGHT = 500;
	private static final int DEFAULT_WIDTH=755;
	
	
	public CreditsFrame(CreditsPanel panel){
		
		setTitle("BattleShip!");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setResizable(false);
		
		add(panel);
		
		setVisible(true);
		
	}
	

}
