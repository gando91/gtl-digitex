package hangman.connection;


import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;


public class AppConnection extends JFrame {

	private static final long serialVersionUID = 1L;	
	private ConnectionPanel cp;
	
	public AppConnection(ConnectionPanel cp){
		
		setSize(400, 300);
		setTitle("Connessione");
		setResizable(false);
		this.cp = cp;
		
		this.cp.getConnetti().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				doConnect();
			}
		});
		
		add(cp);
		setVisible(true);
	}	
	
	private void doConnect() {
		this.cp.connect();
		closeFrame();
	}
	
    public void closeFrame() {
        WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
    }

}
