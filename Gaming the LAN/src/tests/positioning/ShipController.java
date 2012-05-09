package tests.positioning;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import tests.game.MatrixModel;
import tests.game.Status;

public class ShipController implements MouseListener, MouseMotionListener {
	
	private static final int CELL_DIMENSION = 11;
	private static final int DEFAULT_HEIGHT = 770;
	private static final int DEFAULT_WIDTH = 880;
	
	private MatrixModel model;
	private ProxyShip proxyship;
	
	public  ShipController(MatrixModel model, ProxyShip proxyship) {
		super();
		this.model=model;
		this.proxyship=proxyship;
	 
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	
		
		int xp=e.getX();
		int yp=e.getY();
		
		int ncol = ((xp)/(DEFAULT_WIDTH/CELL_DIMENSION));
		int nrow = ((yp)/(DEFAULT_HEIGHT/CELL_DIMENSION));
		
		for (int i = 0; i < proxyship.getShipLength(); i++) {
			model.setstatus(nrow + i, ncol, Status.SHIP);
		}
		
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	
	}

	@Override
	public void mouseMoved(MouseEvent e) {
			
		
			int xp=e.getX();
			int yp=e.getY();
			
			int ncol = ((xp)/(DEFAULT_WIDTH/CELL_DIMENSION));
			int nrow = ((yp)/(DEFAULT_HEIGHT/CELL_DIMENSION));
			
			proxyship.setXPosition(nrow);
			proxyship.setYPosition(ncol);
			
			
	}
	

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

}
