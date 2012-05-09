package tests.positioning;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import tests.game.MatrixModel;
import tests.game.OpponentView;


public class SettingsView extends OpponentView {

	private static final long serialVersionUID = 1L;
	private static final int CELL_WIDTH = 880/11;
	private static final int CELL_HEIGHT = 770/11; 
	
	private ProxyShip proxyship;	
	
	public SettingsView(ProxyShip proxyship, MatrixModel model){
		
		super(model);
		this.proxyship=proxyship;
		getModel().addObserver(this);
		addMouseMotionListener(new ShipController(getModel(), proxyship));
		
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
}
