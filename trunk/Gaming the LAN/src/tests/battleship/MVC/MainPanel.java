package tests.battleship.MVC;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * this class create the main panel 
 * that contains other sub panel
 * 
 */
public class MainPanel extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private OpponentView view;
	private MyView myview;
	private ImageIcon sfondo=new ImageIcon(getClass().getResource("sfondo.jpg"));
	
	
	public MainPanel(OpponentView view,MyView myview, TimerPanel timerpanel){
		
		
		setLayout(new GridLayout(2, 2));	
		//setBorder(BorderFactory.createEtchedBorder());
		setVisible(true);
		
			
		add(view);
		
		//prova pannelli successivi
		add(new JLabel("blocco 2"));
		add(myview);
		add(timerpanel);
		
		
	}
	@Override
	protected void paintComponent(Graphics arg0) {
		
		super.paintComponent(arg0);
		arg0.drawImage(sfondo.getImage(),0,0,null);
	}
}
