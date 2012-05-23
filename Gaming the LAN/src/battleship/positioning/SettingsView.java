package battleship.positioning;

import java.awt.Color;
import java.awt.Graphics;

import battleship.game.MatrixModel;
import battleship.game.OpponentView;
import battleship.game.Status;



public class SettingsView extends OpponentView {

	private static final long serialVersionUID = 1L;
	private static final int CELL_WIDTH = 750/11;
	private static final int CELL_HEIGHT = 636/11; 
	
	private ProxyShip proxyship;
	private boolean positioning=true;
	
	public SettingsView(ProxyShip proxyship, MatrixModel model){
		
		super(model);
		this.proxyship=proxyship;
		
		getModel().addObserver(this);
		this.proxyship.addObserver(this);
		
		addMouseListener(new ShipController(getModel(), proxyship));
		addMouseMotionListener(new ShipController(getModel(), proxyship));
		addKeyListener(new ShipController(getModel(), proxyship));
		setVisible(true);	
	}
		
	
	@Override
	public void drawLetters(Graphics g, int i, int j) {
		String[] lett=new String[10];
		
		lett[0]="A";
		lett[1]="B";
		lett[2]="C";
		lett[3]="D";
		lett[4]="E";
		lett[5]="F";
		lett[6]="G";
		lett[7]="H";
		lett[8]="I";
		lett[9]="L";
		
		if(i==0 && j!=0)
			g.drawString(lett[j-1], j*(CELL_WIDTH)+(CELL_WIDTH)-35,(CELL_HEIGHT/2)+5);		
	}
	

	@Override
	public void drawGrid(Integer i, Integer j, Graphics g) {
		g.fillRect(CELL_WIDTH*j, CELL_HEIGHT*i, CELL_WIDTH, CELL_HEIGHT);
		
		g.setColor(Color.WHITE);
		
		g.drawRect(CELL_WIDTH*j, CELL_HEIGHT*i, CELL_WIDTH, CELL_HEIGHT);
		
		if(j==0 && i!=0)
			g.drawString(i.toString(),(CELL_WIDTH/2)-5, (i*CELL_HEIGHT)+CELL_HEIGHT-20);
		
		drawLetters(g, i, j);	
		
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(proxyship.isRotated() == false){
			for (int i = 0; i < proxyship.getShipLength(); i++) {
				if(super.getModel().getStatusmatrix()[proxyship.getXPosition() + i][proxyship.getYPosition()] == Status.SHIP || proxyship.getXPosition() ==0 || proxyship.getYPosition() == 0 )
					g.setColor(Color.RED);
				else{
					g.setColor(Color.GREEN);
				}
				drawGrid(proxyship.getXPosition() + i, proxyship.getYPosition(), g);
			}
		}
		else{
			for (int i = 0; i < proxyship.getShipLength(); i++) {
				if(super.getModel().getStatusmatrix()[proxyship.getXPosition()][proxyship.getYPosition() + i] == Status.SHIP || proxyship.getXPosition() ==0 || proxyship.getYPosition() == 0 )
					g.setColor(Color.RED);
				else{
					g.setColor(Color.GREEN);
				}
				drawGrid(proxyship.getXPosition(), proxyship.getYPosition() + i, g);
			}
		}
	}
		
	
	
}
