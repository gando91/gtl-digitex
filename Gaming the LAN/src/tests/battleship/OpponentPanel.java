package tests.battleship;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 * 
 * this class describe the opponent panel
 * with the sub panel of hit situation
 *
 */

public class OpponentPanel extends JPanel implements MouseListener{
	
	private static final long serialVersionUID = 1L;
	private static int rows=11;
	private static int cols=11;
	private int ncol,nrow;
	private static String lett[];
	
	
	 OpponentPanel(){
		Color c = new Color (0, 0, 0, 0);
		setBackground(c); 
		setOpaque(true);
		//setBorder(BorderFactory.createEtchedBorder());
		setLayout(new GridLayout(11, 11));
		setVisible(true);
		
		
	}
	//designed by communication architect
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (Integer i = 0; i < rows; i++) {
			for (Integer j = 0; j < cols; j++) {
				g.setColor(Color.BLUE);
				g.fillRect((780/22)*j, (750/22)*i, (780/22), (750/22));
				g.setColor(Color.WHITE);
				g.drawRect((780/22)*j, (750/22)*i, (780/22), (750/22));
				
				if(j==0 && i!=0)
					g.drawString(i.toString(),(780/44)-5, (i*(750/22))+(750/22)-9);
				
				drawLetters(g, i, j);
				
			}
		}
	}
	
	public void checkhit(Graphics g, int x, int y){
		
		if(x!=0 && y!=0){
	
				g.setColor(Color.RED);
				g.fillRect((780/22)*y, (750/22)*x, (780/22),(750/22));
			
		}
	}
	
	
	public int getNcol() {
		return ncol;
	}
	public void setNcol(int ncol) {
		this.ncol = ncol;
	}
	public int getNrow() {
		return nrow;
	}
	public void setNrow(int nrow) {
		this.nrow = nrow;
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
	public void mouseClicked(MouseEvent e) {
		
		int posx=e.getX();
		int posy=e.getY();
		
		setNcol(posx/(780/22));
		setNrow(posy/(750/22));
		System.out.println(ncol);
		System.out.println(nrow);
		
		this.checkhit(this.getGraphics(), nrow, ncol);
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
	public void mousePressed(MouseEvent e) {
		// TODO
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
