package tests.game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

import view.GenericView;


public class OpponentView extends GenericView {

	private static final long serialVersionUID = 1L;
	private static String lett[];
	
	private static final int CELL_WIDTH = 780/22;
	private static final int CELL_HEIGHT = 745/22;
	
	public OpponentView(MatrixModel mm){
		
		setModel(mm);
		getModel().addObserver(this);
		Color c = new Color (0, 0, 0, 0);
		setBackground(c); 
		setOpaque(true);		
	}
	
	private void drawLetters(Graphics g,int i,int j){
		
		lett=new String[10];
		
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
			g.drawString(lett[j-1], j*(CELL_WIDTH)+(CELL_WIDTH)-20,(CELL_HEIGHT/2)+5);		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);	
	}
	
	@Override
	public void drawGrid(Integer i, Integer j,Graphics g) {

		g.fillRect(CELL_WIDTH*j, CELL_HEIGHT*i, CELL_WIDTH, CELL_HEIGHT);
		
		g.setColor(Color.WHITE);
		
		g.drawRect(CELL_WIDTH*j, CELL_HEIGHT*i, CELL_WIDTH, CELL_HEIGHT);
		
		if(j==0 && i!=0)
			g.drawString(i.toString(),(CELL_WIDTH/2)-5, (i*CELL_HEIGHT)+CELL_HEIGHT-9);
		
		drawLetters(g, i, j);		
	}
}
