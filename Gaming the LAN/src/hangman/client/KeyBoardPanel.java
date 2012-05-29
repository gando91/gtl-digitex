package hangman.client;

import gamingthelan.client.IClient;

import java.awt.GridLayout;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class KeyBoardPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private static final long totalbuttons = 21;
	
	private List<KeyButton> buttons;
	private Iterator iterator;
	
	public KeyBoardPanel(JLabel word, IClient client){
		
		setLayout(new GridLayout(3,7));
		
		buttons = new LinkedList<KeyButton>();	
		
		buttons.add(new KeyButton("a", word, client));
		buttons.add(new KeyButton("b", word, client));
		buttons.add(new KeyButton("c", word, client));
		buttons.add(new KeyButton("d", word, client));
		buttons.add(new KeyButton("e", word, client));
		buttons.add(new KeyButton("f", word, client));
		buttons.add(new KeyButton("g", word, client));
		buttons.add(new KeyButton("h", word, client));
		buttons.add(new KeyButton("i", word, client));
		buttons.add(new KeyButton("l", word, client));
		buttons.add(new KeyButton("m", word, client));
		buttons.add(new KeyButton("n", word, client));
		buttons.add(new KeyButton("o", word, client));
		buttons.add(new KeyButton("p", word, client));
		buttons.add(new KeyButton("q", word, client));
		buttons.add(new KeyButton("r", word, client));
		buttons.add(new KeyButton("s", word, client));
		buttons.add(new KeyButton("t", word, client));
		buttons.add(new KeyButton("u", word, client));
		buttons.add(new KeyButton("v", word, client));
		buttons.add(new KeyButton("z", word, client));
		
		for (iterator = buttons.iterator(); iterator.hasNext();) {
			KeyButton button = (KeyButton) iterator.next();
			this.add(button);
		}
			
	}
	
	public void setEnabled(boolean b){
		
		for (iterator = buttons.iterator(); iterator.hasNext();) {
			KeyButton button = (KeyButton) iterator.next();
			button.setEnabled(b);
		}	
	}
}
