package tests.positioning;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class AppPositioning extends JFrame{

	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_HEIGHT = 727;
	private static final int DEFAULT_WIDTH=696;
	
	public AppPositioning(MainPanel mp){
		
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setTitle("Ship Positioning");
		setResizable(false);
		
		add(mp);
		
		
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		
		MainPanel mp = new MainPanel();
		AppPositioning ap = new AppPositioning(mp);
		
		ProxyShip ps = new ProxyShip(null); //TODO
		
		JMenuBar bar = new JMenuBar();
		bar.add(new ShipMenu(ps));
		ap.setJMenuBar(bar);
	}

}
