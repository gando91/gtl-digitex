package tests.splashscreen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import tests.connection.AppConnection;
import tests.connection.ConnectionPanel;

public class SplashPanel extends JPanel implements KeyListener{

	private static final long serialVersionUID = 1L;
	private static final int StringX = 40;
	private static final int StringY = 100;
	private static final int StringStep = 50;
	
	//Immagini
	private ImageIcon sfondo=new ImageIcon(getClass().getResource("BattleshipInitial.png"));
	private ImageIcon missile=new ImageIcon(getClass().getResource("missile.png"));
	
	private String play="PLAY";
	private String info="HOW TO PLAY";
	private String credits="CREDITS";
	private String exit="EXIT";
	private String[] vector=new String[4];
	private int focus=0;
	
	public SplashPanel(){
		vector[0]=play;
		vector[1]=info;
		vector[2]=credits;
		vector[3]=exit;
		
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
		
		String tmp;
		
		for (int i = 0; i < vector.length; i++) {
			if(focus == i){
				tmp = "    " + vector[i];
				
				g.setFont(new Font("Homoarakhn", Font.BOLD, 30));
				g.setColor(Color.RED);
				g.drawString(tmp, StringX-2, StringY - 2 + StringStep * i);
				g.setColor(Color.ORANGE);
				
				g.drawImage(missile.getImage(), StringX, StringY + StringStep*i - 20, null);
			}
			else{
				tmp = vector[i];
				g.setColor(Color.CYAN);
				g.setFont(new Font("Homoarakhn", Font.BOLD, 25));
			}
			g.drawString(tmp, StringX, StringY + StringStep*i);
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
