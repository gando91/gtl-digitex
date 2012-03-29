package tests.battleship;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private OpponentPanel opponentpanel=new OpponentPanel();
	private Image sfondo=new ImageIcon().getImage();
	
	public MainPanel(){
		
		
		setLayout(new GridLayout(2, 2));	
		//setBorder(BorderFactory.createEtchedBorder());
		setVisible(true);
		
		
		add(opponentpanel);
		
		//prova pannelli successivi
		add(new JLabel("blocco 2"));
		add(new MyPanel());
		add(new JLabel("blocco 4"));
		
		
	}
	@Override
	protected void paintComponent(Graphics arg0) {
		
		super.paintComponent(arg0);
		arg0.drawImage(sfondo,0,0,null);
	}
}
