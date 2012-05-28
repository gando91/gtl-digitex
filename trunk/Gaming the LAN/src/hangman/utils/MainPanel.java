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
	
	public MainPanel(String sword){
		
		setTitle("The Hangman");
		setSize(350, 350);
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		
			
				
		
		word = new JTextArea();
		word.setBounds(100, 100, 150, 50);
		word.setFont(new Font("Arial", Font.BOLD, 20));
		word.setText(sword);
		word.setEditable(false);
		
		p = new JPanel();
		p.setLayout(null);
		p.setBounds(0, 0, 350, 350 - 350/3-31);
		p.setBackground(Color.ORANGE);
		p.add(word);
		
		
		lb = new KeyBoardPanel(word);
		lb.setBounds(0, 350 - 350/3-31, 349, 350/3);
		
		add(p);		
		add(lb);
		
		setVisible(true);
	}


	
}

