package hangman.client;

import hangman.drawables.StateEight;
import hangman.drawables.StateEleven;
import hangman.drawables.StateFive;
import hangman.drawables.StateFour;
import hangman.drawables.StateNine;
import hangman.drawables.StateOne;
import hangman.drawables.StateSeven;
import hangman.drawables.StateSix;
import hangman.drawables.StateTen;
import hangman.drawables.StateThree;
import hangman.drawables.StateTwo;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

public class HangmanPanel extends JPanel{

	private static final long serialVersionUID = -4235465505089593172L;
	
	private int state=0; 
	private List<Drawable> drawables;
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		repaint();
	}

	public HangmanPanel() {
		
		setBackground(Color.BLUE);		
		setVisible(true);
		
		drawables = new LinkedList<Drawable>();
		
		drawables.add(new StateOne());
		drawables.add(new StateTwo());
		drawables.add(new StateThree());
		drawables.add(new StateFour());
		drawables.add(new StateFive());
		drawables.add(new StateSix());
		drawables.add(new StateSeven());
		drawables.add(new StateEight());
		drawables.add(new StateNine());
		drawables.add(new StateTen());
		drawables.add(new StateEleven());
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
	public void paint(Graphics g) {
		
		drawables.get(state).draw(g);
	}
	

}
