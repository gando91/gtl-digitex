package tests.battleship.MVC;

import java.awt.Color;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TimerPanel extends JPanel implements Observer{

	private static final long serialVersionUID = 1L;
	
	public TimerPanel(){
		
		
		Color c = new Color (0, 0, 0, 0);
		setBackground(c); 
		setOpaque(true);
		//setLayout(null);
		
		
		JLabel labeltimer = new JLabel("TIMER");
		labeltimer.setBackground(Color.WHITE);
		labeltimer.setOpaque(true);
		labeltimer.setLocation(0, 0);
		labeltimer.setFont(new Font("Comic Sans MS", 0, 30));
		add(labeltimer);
		
		setVisible(true);
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
