package battleship.game;

import java.awt.Graphics;
import java.awt.GridLayout;
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
	
	/*
	 * Queste non sono mai utilizzate, quindi non serve usare memoria per nulla
	private OpponentView view;
	private MyView myview;
	*/
	private ImageIcon sfondo=new ImageIcon(getClass().getResource("Plancia.png"));
	private JLabel turn = new JLabel();
	private String you = new String("It's your turn");
	private String opp = new String("Waiting for opponent");
	public MainPanel(OpponentView view,MyView myview, TimerPanel timerpanel){
		
		setLayout(new GridLayout(2, 2));	
		//setBorder(BorderFactory.createEtchedBorder());
		setVisible(true);
		
			
		add(view);
		
		//prova pannelli successivi
		turn.setText(opp);
		add(turn);
		add(myview);
		add(timerpanel);
		
		
	}
	@Override
	protected void paintComponent(Graphics arg0) {
		
		super.paintComponent(arg0);
		arg0.drawImage(sfondo.getImage(),0,0,null);
	}
	public void turn()
	{
		if(turn.getText()==opp)
			turn.setText(you);
		else
			turn.setText(opp);
	}
}
