package battleship.positioning;

import java.awt.Color;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class WaitingWindow extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private static final int WIDTH = 200;
	private static final int HEIGHT = 100;	
	
	private Timer timer;
	private JPanel p;
	private JLabel l;
	
	private LinkedList<String> dots = new LinkedList<String>();
	private int index = 0;

	public WaitingWindow() {
		
		setTitle("Please Wait");
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		
		dots.add(".");
		dots.add("..");
		dots.add("...");
		dots.add("..");
		
		l = new JLabel("   Waiting for the enemy");
		l.setForeground(Color.WHITE);
		
		p = new JPanel();
		p.setBackground(Color.BLACK);			
		p.setLayout(new GridLayout());
		
		p.add(l);
		
		add(p);		
		setVisible(true);
		
		timer = new Timer(5,this);
		timer.setDelay(1000);
		timer.start();
	}
	
    public void closeFrame() {
        WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
				
		l.setText("   Waiting for the enemy" + dots.get(index));
		index++;
		
		if(index==4)
			index=0;
	}
}
