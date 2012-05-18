package tests.connection;

import javax.swing.JFrame;

public class AppConnection extends JFrame {

	private static final long serialVersionUID = 1L;
	
	
	
	public AppConnection(ConnectionPanel cp){
		
		setSize(400, 200);
		setTitle("CONNESSIONE");
		setResizable(false);
		add(cp);
		setVisible(true);
	}



	private void settings() {
		
		
		
	}
	

}
