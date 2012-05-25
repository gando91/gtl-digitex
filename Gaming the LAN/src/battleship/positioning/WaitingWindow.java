package battleship.positioning;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WaitingWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	public WaitingWindow() {
		
		setTitle("Please Wait ...");
		setSize(300, 200);
		
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		p.add(new JLabel("Waiting for the enemy..."));
		
		//TODO : Aggiungere GIF
		
		add(p);
		setVisible(true);
	}
	
    public void closeFrame() {
        WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
    }
}
