package hangman.utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class KeyButton extends JButton{

	private static final long serialVersionUID = 1L;

	private char letter;
	private JLabel word;

	public KeyButton(String letter, JLabel word){
		
		this.letter = letter.charAt(0);
		this.word = word;
		
		this.setText(letter);
		
		this.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				CurrentWord.getInstance().letterCheck(getLetter());
				getWord().setText(CurrentWord.getInstance().getVisibleString());
			}			
		});
	}

	public char getLetter() {
		return letter;
	}

	public JLabel getWord() {
		return word;
	}	
	public void setEnabled(boolean b){
		this.setEnabled(b);
	}
}
