package hangman.utils;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class KeyBoardPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	public KeyBoardPanel(JTextArea word){
		
		setLayout(new GridLayout(3,7));
		
		add(new KeyButton("a",word));
		add(new KeyButton("b",word));
		add(new KeyButton("c",word));
		add(new KeyButton("d",word));
		add(new KeyButton("e",word));
		add(new KeyButton("f",word));
		add(new KeyButton("g",word));
		add(new KeyButton("h",word));
		add(new KeyButton("i",word));
		add(new KeyButton("l",word));
		add(new KeyButton("m",word));
		add(new KeyButton("n",word));
		add(new KeyButton("o",word));
		add(new KeyButton("p",word));
		add(new KeyButton("q",word));
		add(new KeyButton("r",word));
		add(new KeyButton("s",word));
		add(new KeyButton("t",word));
		add(new KeyButton("u",word));
		add(new KeyButton("v",word));
		add(new KeyButton("z",word));
	}
}
