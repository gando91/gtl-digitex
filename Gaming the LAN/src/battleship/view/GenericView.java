package battleship.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

import battleship.game.MatrixModel;
import battleship.game.Status;

public abstract class GenericView extends JPanel implements Observer{


	private static final long serialVersionUID = 1L;
	private MatrixModel model;
	
	public void paint(Graphics g){
		
		Status statusmatrix[][] = model.getStatusmatrix();
		
		//creo griglia
		for (Integer i = 0; i < 11; i++) {
			for (Integer j = 0; j < 11; j++) {
				
				
				if(statusmatrix[i][j]==Status.VIRGIN){
					g.setColor(Color.BLUE);
				}
				if(statusmatrix[i][j]==Status.HIT){
					g.setColor(Color.RED);
				}
				if(statusmatrix[i][j]==Status.MISSED){
					g.setColor(Color.CYAN);
				}
				
				if(statusmatrix[i][j]==Status.SHIP){
					g.setColor(Color.ORANGE);
				}
				
				drawGrid(i,j,g);
			}
		}	
		
	}
	
	public MatrixModel getModel() {
		return model;
	}	
	
	public void setModel(MatrixModel model) {
		this.model = model;
	}

	public abstract void drawGrid(Integer i,Integer j,Graphics g);

	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();		
	}

}
