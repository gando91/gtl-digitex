package tests.positioning;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import tests.game.MatrixModel;

public class AppPositioning extends JFrame{

	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_HEIGHT = 727;
	private static final int DEFAULT_WIDTH=696;
	
	
	public static void main(String[] args) {
		
		ProxyShip ps = new ProxyShip(new AircraftCarrier());
		SettingsView mp = new SettingsView(ps, new MatrixModel());//FIXME devo usare sempre lo stesso modello
		AppPositioning ap = new AppPositioning(mp);
		
		
		JMenuBar bar = new JMenuBar();
		bar.add(new ShipMenu(ps));
		ap.setJMenuBar(bar);
		
		
		
		ap.setVisible(true);
		
	}
	public AppPositioning(SettingsView mp){
		
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setTitle("Ship Positioning");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		add(mp);	
		
		
	}
	
	

}
