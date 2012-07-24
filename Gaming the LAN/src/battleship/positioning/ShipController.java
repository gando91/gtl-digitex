package battleship.positioning;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import battleship.game.MatrixModel;
import battleship.game.Status;
import battleship.game.MatrixModel.Memento;


public class ShipController extends KeyAdapter implements MouseListener, MouseMotionListener {
	
	private static final int CELL_DIMENSION = 11;
	private static final int DEFAULT_HEIGHT = 650;
	private static final int DEFAULT_WIDTH = 750;
	
	private MatrixModel model;
	private ProxyShip proxyship;
	private Memento ricordoModel;
	private battleship.positioning.ProxyShip.Memento ricordoProxy;
	
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
		int counter = 0;
		int counter2 = 0;
		
		
		if(proxyship.isRotated()==false){
			
				
					for (int i = 0; i < proxyship.getShipLength(); i++) {
						if(nrow+i > 10)
							counter2 ++;
						else
							{
								if(model.getStatusmatrix()[nrow + i][ncol] == Status.SHIP)
									counter ++;
							}
						
					}

					if(counter == 0 && counter2 == 0 && ncol != 0 && nrow != 0){
						if(proxyship.getShipAmount() < proxyship.getMaxAmount() && counter2 == 0){
							ricordoProxy = proxyship.generateMemento();
							proxyship.incrementShipAmount();
							
							//Genero un ricordo del modello prima di modificarlo
							ricordoModel = model.generateMemento();
							
							for (int i = 0; i < proxyship.getShipLength(); i++) {
								model.setstatus(nrow + i, ncol, Status.SHIP);
						
							}
							model.addShip(proxyship.getShip().copy());
					}
			}
		}
		else{	
			
				for (int i = 0; i < proxyship.getShipLength(); i++) {
					if(ncol+i > 10)
						counter2 ++;
					else
					{	
						if(model.getStatusmatrix()[nrow][ncol + i] == Status.SHIP)
							counter ++;
					}
				}
			
				if(counter == 0 && counter2 == 0 && ncol != 0 && nrow != 0){
					if(proxyship.getShipAmount() < proxyship.getMaxAmount() && counter2 == 0){
						ricordoProxy = proxyship.generateMemento();
						proxyship.incrementShipAmount();
						
					//Genero un ricordo del modello prima di modificarlo
					ricordoModel = model.generateMemento();

					for (int i = 0; i < proxyship.getShipLength(); i++) {
						model.setstatus(nrow, ncol + i, Status.SHIP);
					}
	

					model.addShip(proxyship.getShip().copy());
				}
			
		}
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

	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		
		if(e.getKeyCode()==KeyEvent.VK_R)
			proxyship.rotate();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void undo() {
		ricordoModel.restore();
		ricordoProxy.restore();
	}

}
