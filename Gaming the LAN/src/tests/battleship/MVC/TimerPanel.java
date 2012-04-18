package tests.battleship.MVC;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

public class TimerPanel extends JPanel implements Observer{

	private static final long serialVersionUID = 1L;
	private TimerModel timermodel;
	
	public TimerPanel(TimerModel timermodel){
		this.timermodel=timermodel;
		
		Color c = new Color (0, 0, 0, 0);
		setBackground(c); 
		setOpaque(true);
		//setLayout(null);
		
		timermodel.startTimer();
		
		setVisible(true);
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		repaint();
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("Homoarakhn", 0, 70));
		g.setColor(Color.BLACK);
		g.fillRect(165, 105, 175, 105);
		g.setColor(Color.GREEN);
		g.drawString(timermodel.toString(), 180, 180);
		
	}

}
