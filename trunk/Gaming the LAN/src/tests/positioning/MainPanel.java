package tests.positioning;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;
import tests.game.MatrixModel;
import tests.game.OpponentView;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private MatrixModel model=new MatrixModel();
	private OpponentView grid=new OpponentView(model);
	private ProxyShip proxyship;
	
	
	public MainPanel(ProxyShip proxyship){
		
		this.proxyship=proxyship;
		
		setBackground(Color.BLUE);
		setLayout(new BorderLayout());
		
		grid.setWidth(1400);
		grid.setHeight(1300);
		model.addObserver(grid);
		this.add(grid);
		grid.addMouseMotionListener(new ShipController(model, proxyship ));
		JButton ready=new JButton("READY");
		add(ready,BorderLayout.SOUTH);
		setVisible(true);
		
		
	}


	public MatrixModel getModel() {
		return model;
	}


	

}
