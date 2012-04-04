package tests.battleship.MVC;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MatrixController implements MouseListener{
	
	private MatrixModel model;
	
	public MatrixController(MatrixModel model){
		this.model = model;
		//TODO
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int posx=e.getX();
		int posy=e.getY();
		int ncol =(posx/(780/22));
		int nrow = (posy/(750/22));
		
		if(ncol!=0 && nrow!=0){			
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
