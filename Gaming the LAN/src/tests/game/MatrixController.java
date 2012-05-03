package tests.game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MatrixController implements MouseListener{
	
	private static final int CELL_DIMENSION = 22;
	private static final int DEFAULT_HEIGHT = 750;
	private static final int DEFAULT_WIDTH = 780;
	private MatrixModel model;
	
	public MatrixController(MatrixModel model){
		this.model = model;
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
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
