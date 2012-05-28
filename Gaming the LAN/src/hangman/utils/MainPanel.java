package hangman.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MainPanel extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JPanel p;
	private JMenuBar mb;
	private JMenu m;	
	private JTextArea word;
	private KeyBoardPanel lb;
	private Words words;
	
	public MainPanel(Words words){
		
		this.words = words;
		
		setTitle("The Hangman");
		setSize(350, 350);
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		
		mb = new JMenuBar();
		mb.setBounds(0, 0, 350, 30);
		m = new JMenu("New word");		
		m.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				// Set the current word using the getRndWord() method of words
				// that returns a random word from the list of words.
				CurrentWord.getInstance().setCurrentWord(getWords().getRndWord());
				
				word.setText(CurrentWord.getInstance().getVisibleString());				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		mb.add(m);		
		
		word = new JTextArea();
		word.setBounds(100, 100, 150, 50);
		word.setFont(new Font("Arial", Font.BOLD, 20));
		word.setEditable(false);
		
		// This is the panel that contains the text-area with the visible word.
		p = new JPanel();
		p.setLayout(null);
		p.setBounds(0, 0, 350, 350 - 350/3-31);
		p.setBackground(Color.ORANGE);
		p.add(word);		
		
		// This is the panel that contains the keyboard.
		lb = new KeyBoardPanel(word);
		lb.setBounds(0, 350 - 350/3-31, 349, 350/3);
		
		add(mb);
		add(p);		
		add(lb);
		
		setVisible(true);
	}

	public Words getWords() {
		return words;
	}
	
}
