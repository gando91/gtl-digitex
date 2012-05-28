package hangman.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MainPanel extends JFrame{

	private static final long serialVersionUID = 1L;	
	
	private static final int WIDTH = 350;
	private static final int HEIGHT = 400;
	
	private JPanel p;
	private JLabel word;
	private HangmanPanel hmp;
	private FeelLuckyPanel flp;
	private KeyBoardPanel lb;
	
	
	public MainPanel(String sword){
		
		setTitle("The Hangman");
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		
		hmp = new HangmanPanel();
		hmp.setBounds(115, 15, 120, 120);
		
		word = new JLabel();		
		word.setFont(new Font(null, Font.BOLD, 20));
		word.setText(sword);
		word.setBounds(10, 145, 150, 30);
		
		flp = new FeelLuckyPanel();
		flp.setBounds(0, 184, WIDTH, 50);
		
		p = new JPanel();
		p.setLayout(null);
		p.setBounds(0, 0, 350, HEIGHT - HEIGHT/3-31);
		p.setBackground(Color.ORANGE);
		
		p.add(hmp);
		p.add(word);
		p.add(flp);		
		
		lb = new KeyBoardPanel(word);
		lb.setBounds(0, HEIGHT - HEIGHT/3-31, WIDTH - 1, HEIGHT/3);
		
		add(p);		
		add(lb);
		
		setVisible(true);
		
	}

	public void setWord(String word){
		this.word.setText(word);
	}

	
}

