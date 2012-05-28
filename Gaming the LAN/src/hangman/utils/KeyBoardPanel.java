package hangman.utils;

import gamingthelan.client.IClient;

import java.awt.GridLayout;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class KeyBoardPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private static final long totalbuttons = 21;
	public KeyBoardPanel(JLabel word, IClient client){
		
		setLayout(new GridLayout(3,7));
		
		add(new KeyButton("a",word, client));
		add(new KeyButton("b",word, client));
		add(new KeyButton("c",word, client));
		add(new KeyButton("d",word, client));
		add(new KeyButton("e",word, client));
		add(new KeyButton("f",word, client));
		add(new KeyButton("g",word, client));
		add(new KeyButton("h",word, client));
		add(new KeyButton("i",word, client));
		add(new KeyButton("l",word, client));
		add(new KeyButton("m",word, client));
		add(new KeyButton("n",word, client));
		add(new KeyButton("o",word, client));
		add(new KeyButton("p",word, client));
		add(new KeyButton("q",word, client));
		add(new KeyButton("r",word, client));
		add(new KeyButton("s",word, client));
		add(new KeyButton("t",word, client));
		add(new KeyButton("u",word, client));
		add(new KeyButton("v",word, client));
		add(new KeyButton("z",word, client));
			
	}
	public void setEnabled(boolean b){
		
		for (int j = 0; j < totalbuttons; j++) {
			this.getComponent(j);
		}		
	}
}
