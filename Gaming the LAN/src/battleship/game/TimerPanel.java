package battleship.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class TimerPanel extends JPanel implements Observer{

	private static final long serialVersionUID = 1L;
	
	private TimerModel timermodel;
	//private ImageIcon crono=new ImageIcon(getClass().getResource("cronometro.png"));
	
	public TimerPanel(TimerModel timermodel){
		this.timermodel=timermodel;
		
		Color c = new Color (0, 0, 0, 0);
		setBackground(c); 
		setOpaque(true);
		
		timermodel.startTimer();
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		//Questo sembra risolvere il problema su windows. Da testare su altri OS
		//this.paintComponent(getGraphics());
		this.repaint();
		//Dovrebbe essere repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//g.drawImage(crono.getImage(),50,30,null);
		
		g.setFont(new Font("Homoarakhn", 0, 100));
		g.setColor(Color.BLACK);
		g.fillRect(138, 130, 150, 130);
		g.setColor(Color.RED);
		g.drawString(timermodel.toString(), 138, 223);
		
	}

}
