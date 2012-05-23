package battleship.splashscreen;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class CreditsPanel extends JPanel{
	
	private ImageIcon sfondo=new ImageIcon(getClass().getResource("credits.png"));
	
	public CreditsPanel(){

		setBackground(Color.BLACK);
		setVisible(true);
	}
	@Override
	protected void paintComponent(Graphics arg0) {
		
		super.paintComponent(arg0);
		arg0.drawImage(sfondo.getImage(),0,0,null);
	}

}
