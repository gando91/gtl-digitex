package tests.battleship;

import javax.swing.JFrame;

public class Frame extends JFrame  {
	
	public Frame(){
		
		setTitle("Battleship!");
		setSize(1024,768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		
		
		MainPanel mainpanel=new MainPanel();
		
		getContentPane().add(mainpanel);
		
	}

	public static void main(String[] args) {
		
		Frame frame=new Frame();

	}

}
