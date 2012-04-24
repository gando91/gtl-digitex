package tests.positioning;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import tests.game.MatrixController;
import tests.game.MatrixModel;
import tests.game.OpponentView;

public class MainPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private MatrixModel model=new MatrixModel();
	private OpponentView grid=new OpponentView(model);
	
	
	public MainPanel(){
		setBackground(Color.BLUE);
		setLayout(new BorderLayout());
		
		grid.setWidth(1400);
		grid.setHeight(1300);
		
		this.add(grid);
		
		JButton pippo=new JButton("invia navi");
	
		
		add(pippo,BorderLayout.SOUTH);
		
		
		
	}

}
