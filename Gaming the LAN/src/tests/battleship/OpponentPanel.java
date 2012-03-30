package tests.battleship;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OpponentPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private static int rows=11;
	private static int coloums=11;
	
	 OpponentPanel(){
		Color c = new Color (0, 0, 0, 0);
		setBackground(c); 
		setOpaque(true);
		//setBorder(BorderFactory.createEtchedBorder());
		setLayout(new GridLayout(11, 11));
		setVisible(true);
		
	}
	//designed by communication architect
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				g.setColor(Color.BLUE);
				g.fillRect((780/22)*j, (750/22)*i, (780/22), (750/22));
				g.setColor(Color.WHITE);
				g.drawRect((780/22)*j, (750/22)*i, (780/22), (750/22));
			}
		}
	}
}
