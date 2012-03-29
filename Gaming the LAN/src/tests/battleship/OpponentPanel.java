package tests.battleship;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OpponentPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private OpponentCell[] opponentcell;
	private static int rows=11;
	private static int coloums=11;
	
	
	
	public OpponentPanel(){
		
		setBorder(BorderFactory.createEtchedBorder());
		setLayout(new GridLayout(11, 11));
		setVisible(true);
		
		opponentcell=new OpponentCell[rows*coloums]; 
		
	
		
	
		for (Integer i = 0; i < (rows*coloums); i++) {
			
			
			opponentcell[i]=new OpponentCell();
			
			if(i!=0 && i<=10)
				opponentcell[i].add(new JLabel(i.toString()));
						
			
			add(opponentcell[i]);
			
		}
	}

}
