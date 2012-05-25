package battleship.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import battleship.positioning.DefaultDimensions;

public class TurnPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private final static String you = new String("It's your turn");
	private final static String opp = new String("Waiting for opponent");
	private String now = opp;
	public TurnPanel(){
		Color c = new Color (0, 0, 0, 0);
		setBackground(c); 
		setOpaque(true);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.setColor(Color.WHITE);
		g.fillRect(DefaultDimensions.DEFAULT_WIDTH.getValue()/9 + 9, DefaultDimensions.DEFAULT_WIDTH.getValue()/6 + 29, 202, 21);
		
		g.setColor(Color.BLACK);
		g.fillRect(DefaultDimensions.DEFAULT_WIDTH.getValue()/9 + 10, DefaultDimensions.DEFAULT_WIDTH.getValue()/6 + 30, 200, 19);
		
		if(now == you){
			g.setColor(Color.GREEN);
		}
		else{
			g.setColor(Color.RED);
		}
		
		//g.setFont(new Font("Homoarakhn", Font.BOLD, 16));
		//Ho messo verdana perchè con l'altro era poco leggibile... e diventava troppo grosso
		g.setFont(new Font("Verdana", Font.BOLD, 16));
		
		g.drawString(now, DefaultDimensions.DEFAULT_WIDTH.getValue()/9 + 10, DefaultDimensions.DEFAULT_WIDTH.getValue()/6 + 45);
	}
	
	@Override
	public void repaint() {
		
		super.repaint();
		
		
	}
	
	public void turn(){
		if(now == opp)
			now = you;
		else
			now = opp;
		repaint();
	}
}
