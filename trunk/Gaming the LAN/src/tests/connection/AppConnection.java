package tests.connection;

import javax.swing.JFrame;

public class AppConnection extends JFrame {

	private static final long serialVersionUID = 1L;
	
	
	
	public AppConnection(){
		
		settings();
	}



	private void settings() {
		setSize(780, 780);
		setTitle("CONNESSIONE");
		setLayout(null);
		
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		AppConnection ac=new AppConnection();
		
		
	}
	
	

}
