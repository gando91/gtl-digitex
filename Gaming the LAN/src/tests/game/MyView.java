package tests.game;

import java.awt.Color;
import java.awt.Graphics;

import view.GenericView;


public class MyView extends GenericView {

	private static final long serialVersionUID = 1L;
	
	private static final int CELL_WIDTH = 420/22;
	private static final int CELL_HEIGHT = 405/22;
	
	private static String lett[];
	
	public MyView(MatrixModel mm){
		
		setModel(mm);
		getModel().addObserver(this);
		Color c = new Color (0, 0, 0, 0);
		setBackground(c); 
		setOpaque(true);
		setLayout(null);		
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
			g.drawString(lett[j-1], j*(420/22)+(420/22)+6,(405/44)+25);
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);						
	}
	
	@Override
	public void drawGrid(Integer i, Integer j, Graphics g) {
		
		g.fillRect(((CELL_WIDTH)*j)+20, ((CELL_HEIGHT)*i)+20, (CELL_WIDTH), (CELL_HEIGHT));
		
		g.setColor(Color.WHITE);
		
		g.drawRect(((CELL_WIDTH)*j)+20, ((CELL_HEIGHT)*i)+20, (CELL_WIDTH), (CELL_HEIGHT));
		
		if(j==0 && i!=0)
			g.drawString(i.toString(),(CELL_WIDTH/2)+15, (i*(CELL_HEIGHT))+(CELL_HEIGHT)+14);
		
		drawLetters(g, i, j);		
	}

}
