package battleship.splashscreen;

import javax.swing.JFrame;

public class SplashFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_HEIGHT = 500;
	private static final int DEFAULT_WIDTH=750;
	
	
	public SplashFrame(SplashPanel panel){
		
		setTitle("BattleShip!");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		this.addKeyListener(panel);
		add(panel);
		
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		SplashPanel panel=new SplashPanel();
		new SplashFrame(panel);
		
		
	}

}
