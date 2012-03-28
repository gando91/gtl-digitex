package tests.battleship;

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private OpponentPanel opponentpanel=new OpponentPanel();
	
	
	public MainPanel(){
		
		
		setLayout(new GridLayout(2, 2));	
		setBorder(BorderFactory.createEtchedBorder());
		setVisible(true);
		
		add(opponentpanel);
		
		//prova pannelli successivi
		add(new JLabel("blocco 2"));
		add(new JLabel("blocco 3"));
		add(new JLabel("blocco 4"));
		
		
	}
}
