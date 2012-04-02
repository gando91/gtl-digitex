package tests.battleship;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

/**
 * 
 * This is the class application that  launches
 * the battleship test game
 * 
 */
public class Frame extends JFrame  {
	
	private static final long serialVersionUID = 1L;

	
	/** create the frame 
	 * 
	 */
	public Frame(){
		
		setTitle("Battleship!");
		setSize(780,780);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		MainPanel mainpanel=new MainPanel();
		getContentPane().add(mainpanel);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		
		Frame frame=new Frame();

	}

}
