package tests.game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;


public class OpponentView extends JPanel implements Observer{

	private static final long serialVersionUID = 1L;
	private static String lett[];
	private MatrixModel model;
	
	public OpponentView(MatrixModel model){
		this.model = model;
		model.addObserver(this);
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
			g.drawString(lett[j-1], j*(780/22)+(780/22)-20,(750/44)+5);
		
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		Status statusmatrix[][] = model.getStatusmatrix();
		
		//creo griglia
		for (Integer i = 0; i < 11; i++) {
			for (Integer j = 0; j < 11; j++) {
				
				
				if(statusmatrix[i][j]==Status.VIRGIN){
					g.setColor(Color.BLUE);
				}
				if(statusmatrix[i][j]==Status.HIT){
					g.setColor(Color.DARK_GRAY);
				}
				if(statusmatrix[i][j]==Status.MISSED){
					g.setColor(Color.CYAN);
				}
				
				
				g.fillRect((780/22)*j, (750/22)*i, (780/22), (750/22));
				
				g.setColor(Color.WHITE);
				g.drawRect((780/22)*j, (750/22)*i, (780/22), (750/22));
				
				if(j==0 && i!=0)
					g.drawString(i.toString(),(780/44)-5, (i*(750/22))+(750/22)-9);
				
				drawLetters(g, i, j);
				
			}
		}
	}

}
