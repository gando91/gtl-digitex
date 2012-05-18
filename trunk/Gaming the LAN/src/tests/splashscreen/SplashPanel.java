package tests.splashscreen;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class SplashPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private ImageIcon sfondo=new ImageIcon(getClass().getResource("BattleshipInitial.png"));
	
	
	public SplashPanel(){
		
		setBackground(Color.BLACK);
		setVisible(true);
		
	}
	@Override
	protected void paintComponent(Graphics arg0) {
		
		super.paintComponent(arg0);
		arg0.drawImage(sfondo.getImage(),0,0,null);
	}
}
