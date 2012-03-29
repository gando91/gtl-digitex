package tests.battleship;

import javax.swing.JFrame;

public class Frame extends JFrame  {
	
	private static final long serialVersionUID = 1L;

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
