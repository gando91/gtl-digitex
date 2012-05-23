package battleship.splashscreen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import battleship.connection.AppConnection;
import battleship.connection.ConnectionPanel;


public class SplashPanel extends JPanel implements KeyListener{

	private static final long serialVersionUID = 1L;
	private static final int StringX = 40;
	private static final int StringY = 100;
	private static final int StringStep = 50;
	
	//Immagini
	private ImageIcon sfondo=new ImageIcon(getClass().getResource("BattleshipInitial.png"));
	private ImageIcon missile=new ImageIcon(getClass().getResource("missile.png"));
	
	private String[] vector={new String("PLAY"), new String("HOW TO PLAY"), new String("CREDITS"), new String("EXIT")};
	private int focus=0;
	
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
		
		int tmpOffset;
		
		for (int i = 0; i < vector.length; i++) {
			if(focus == i){
				
				tmpOffset = StringX + missile.getIconWidth() + 4;
				
				g.setFont(new Font("Homoarakhn", Font.BOLD, 30));
				g.setColor(Color.RED);
				g.drawString(vector[i], tmpOffset-2, StringY - 2 + StringStep * i);
				g.setColor(Color.ORANGE);
				
				g.drawImage(missile.getImage(), StringX, StringY + StringStep*i - 20, null);
			}
			else{
				tmpOffset = StringX;
				g.setColor(Color.CYAN);
				g.setFont(new Font("Homoarakhn", Font.BOLD, 25));
			}
			g.drawString(vector[i], tmpOffset, StringY + StringStep*i);
		}

	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_DOWN && focus < 3){
			focus++;
			repaint();
		
		}
		if(e.getKeyCode()==KeyEvent.VK_UP && focus > 0){
			focus--;
			repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			
			if(focus==0){
				new AppConnection(new ConnectionPanel());
			}
			
			//TODO: gestire gli altri focus
			
			if(focus == 3){
				System.exit(0);
			}
			
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
	
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
}
