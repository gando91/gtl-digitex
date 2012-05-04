package tests.positioning;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import tests.game.MatrixModel;
import tests.game.Status;

public class ShipController implements MouseListener, MouseMotionListener {
	
	private static final int CELL_DIMENSION = 11;
	private static final int DEFAULT_HEIGHT = 696;
	private static final int DEFAULT_WIDTH = 727;
	private MatrixModel model;
	private ProxyShip proxyship;
	
	public  ShipController(MatrixModel model, ProxyShip proxyship) {
		super();
		this.model=model;
		this.proxyship=proxyship;
	 
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		int posx = e.getX();
		int posy = e.getY();
		
		int ncol = (posx/(DEFAULT_WIDTH/CELL_DIMENSION));
		int nrow = (posy/(DEFAULT_HEIGHT/CELL_DIMENSION));
		
		if(ncol != 0 && nrow != 0){			
			model.setstatus(nrow, ncol, Status.HIT);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		int xp=e.getX();
		int yp=e.getY();
		
		int ncol = (xp/(DEFAULT_WIDTH/CELL_DIMENSION));
		int nrow = (yp/(DEFAULT_HEIGHT/CELL_DIMENSION));
		
		Status mymatrix[][]=model.getStatusmatrix();
		if(mymatrix[ncol][nrow]==Status.VIRGIN){
			
			model.setstatus(nrow, ncol, Status.SHIP);
			
		}
		
		
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
