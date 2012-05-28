package hangman.utils;

import javax.swing.JFrame;

public class TestFeelLucky extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private static final int DEFAULT_HEIGHT = 80;
	private static final int DEFAULT_WIDTH= 350;
	
	FellLuckyPanel panel=new FellLuckyPanel();
	public TestFeelLucky() {
		
		
		setTitle("Hangman!");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		add(panel);
		
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		TestFeelLucky frame=new TestFeelLucky();
	}

}
