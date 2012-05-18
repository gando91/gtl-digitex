package tests.splashscreen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class SplashPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private ImageIcon sfondo=new ImageIcon(getClass().getResource("BattleshipInitial.png"));
	private String play="PLAY";
	private String info="HOW TO PLAY";
	private String credits="CREDITS";
	private String exit="EXIT";
	
	public SplashPanel(){
		
		setBackground(Color.BLACK);
		setVisible(true);
	}
	@Override
	protected void paintComponent(Graphics arg0) {
		
		super.paintComponent(arg0);
		arg0.drawImage(sfondo.getImage(),0,0,null);
	}
	
	@Override
	public void paint(Graphics g) {
		
		super.paint(g);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Homoarakhn", 0, 30));
		g.drawString(play, 40, 100);
		g.drawString(info, 40, 150);
		g.drawString(credits, 40, 200);
		g.drawString(exit, 40, 250);
	}
}
