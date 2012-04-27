package tests.positioning;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;
import tests.game.MatrixModel;
import tests.game.OpponentView;
import view.GenericView;

public class SettingsView extends OpponentView {

	private static final long serialVersionUID = 1L;
	
	/*private MatrixModel model=new MatrixModel();
	private OpponentView grid=new OpponentView();*/
	private ProxyShip proxyship;	
	
	public SettingsView(ProxyShip proxyship, MatrixModel model){
		super(model);
		this.proxyship=proxyship;
		
		setBackground(Color.BLUE);
		setLayout(new BorderLayout());
		
		/*grid.setWidth(1400);
		grid.setHeight(1300);*/
		getModel().addObserver(this);
		addMouseMotionListener(new ShipController(getModel(), proxyship));
		
		JButton ready=new JButton("READY");
		add(ready,BorderLayout.SOUTH);
		setVisible(true);	
	}

	@Override
	public void drawGrid(Integer i, Integer j, Graphics g) {
		// TODO Auto-generated method stub
		
	}
}
