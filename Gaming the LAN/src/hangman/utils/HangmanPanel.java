package hangman.utils;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class HangmanPanel extends JPanel{

	private static final long serialVersionUID = -4235465505089593172L;
	private int state=0; 
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public HangmanPanel() {
		
		setBackground(Color.BLUE);		
		setVisible(true);
	}
	
	public void goOn(){
		
		state++;
		repaint();
	}
	
	public void reset(){
		
		state=0;
		repaint();
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		
		// TODO: stasìra fuma un pont
		
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		
		if(state==1)
			g.drawLine(20, 100, 100, 100);
		
		if(state==2)
			g.drawLine(20, 100, 20, 20);
			
		if(state==3)
			g.drawLine(20, 20, 70, 20);
			
		if(state==4)
			g.drawLine(70, 20, 70, 30);
			
		if(state==5)
			g.drawOval(63, 30, 15, 15);
		
		if(state==6)
			g.drawLine(70, 45, 70, 75);
			
		if(state==7)
			g.drawLine(70, 47, 80, 57);
		
		if(state==8)
			g.drawLine(70, 47, 60, 57);
		
		if(state==9)
			g.drawLine(70, 75, 80, 85);
		
		if(state==10)
			g.drawLine(70, 75, 60, 85);
			
	}
	

}
