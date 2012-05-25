package battleship.game;

import gamingthelan.client.IClient;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import battleship.client.MissilePacket;

public class MatrixController implements MouseListener{
	
	private static final int CELL_DIMENSION = 22;
	private static final int DEFAULT_HEIGHT = 750;
	private static final int DEFAULT_WIDTH = 780;
	private MatrixModel model;
	private IClient client;
	private boolean myTurn = false;
	
	private int ncol, nrow;
	
	public MatrixController(MatrixModel model, IClient client){
		this.model = model;
		this.client = client;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		int posx = e.getX();
		int posy = e.getY();
		
		ncol = (posx/(DEFAULT_WIDTH/CELL_DIMENSION));
		nrow = (posy/(DEFAULT_HEIGHT/CELL_DIMENSION));
		
		if(ncol != 0 && nrow != 0){		
			if(myTurn == true && model.getCellStatus(nrow, ncol) == Status.VIRGIN){
				try {
					client.sendPacket(new MissilePacket(client.getConnection().getNickName(), "other", nrow, ncol));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
				
			//model.setstatus(nrow, ncol, Status.HIT);
		}
	}
	
	public void changeTurn(){
		myTurn = !myTurn;
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

	/**
	 * @return the ncol
	 */
	public int getNcol() {
		return ncol;
	}

	/**
	 * @return the nrow
	 */
	public int getNrow() {
		return nrow;
	}
	
	

}
