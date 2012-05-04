package tests.positioning;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		
		ap.setLayout(new BorderLayout());
		
		JMenuBar bar = new JMenuBar();
		bar.add(new ShipMenu(ps));
		ap.setJMenuBar(bar);
		
		ap.add(mp);
		
		JButton ready=new JButton("READY");
		ap.add(ready, BorderLayout.PAGE_END);
		JButton reset=new JButton("RESET");
		ap.add(reset, BorderLayout.PAGE_START);
		ap.setVisible(true);
	}
	
	public AppPositioning(SettingsView mp){
		
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setTitle("Ship Positioning");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
	}
	
}
