package hangman.client;

import gamingthelan.client.IClient;
import hangman.packets.LetterPacket;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;

public class KeyButton extends JButton{

	private static final long serialVersionUID = 1L;

	private char letter;
	private JLabel word;
	private IClient client;
	private ActionListener l;
	
	public KeyButton(String letter, JLabel word, IClient client){
		this.client = client;
		this.letter = letter.charAt(0);
		this.word = word;
		
		this.setText(letter);
		
		l = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					getClient().sendPacket(new LetterPacket(getClient().getConnection().getNickName(), getLetter()));
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}			
		};
		
	}

	public char getLetter() {
		return letter;
	}

	public JLabel getWord() {
		return word;
	}	
	
	public void setEnabled(boolean b){
		if(b)
			this.addActionListener(l);
		else
			this.removeActionListener(l);
	}
	
	public IClient getClient(){
		return this.client;
	}
	
}
