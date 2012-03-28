package tests.battleship;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class OpponentCell extends JPanel {
	
private static final long serialVersionUID = 1L;
	
	public OpponentCell(){
		
		setVisible(true);
		setBackground(Color.blue);
		setBorder(BorderFactory.createEtchedBorder());
		
	}

}
