package hangman.utils;

import javax.swing.JFrame;

public class HangmanFrame extends JFrame {

	private static final long serialVersionUID = 8409932111971291291L;
	private static final int DEFAULT_HEIGHT = 150;
	private static final int DEFAULT_WIDTH= 150;
	
	HangmanPanel panel=new HangmanPanel();
	public HangmanFrame(){
		
		setTitle("Hangman!");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		add(panel);
		
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		HangmanFrame frame=new HangmanFrame();
	}
}
