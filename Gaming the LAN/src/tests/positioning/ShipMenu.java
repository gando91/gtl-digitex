package tests.positioning;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class ShipMenu extends JMenu{
	
	private static final long serialVersionUID = 1L;
	private ProxyShip proxyship;
	
	public ShipMenu(ProxyShip proxyship){
		super("Ships available");
		this.proxyship=proxyship;
		
		JMenuItem aircraft_carrier=new JMenuItem("aircraft_carrier");
		
		aircraft_carrier.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ShipMenu.this.proxyship.setShip(null);  //TODO aircraft carrier class
				
			}
		});
		add(aircraft_carrier);
		
		JMenuItem cruiser=new JMenuItem("cruiser");
		
		cruiser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ShipMenu.this.proxyship.setShip(null);  //TODO cruiser class
				
			}
		});
		add(cruiser);
		
		JMenuItem torpedo_boat=new JMenuItem("torpedo boat");
		
		torpedo_boat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ShipMenu.this.proxyship.setShip(null);  //TODO torpedo boat class
				
			}
		});
		add(torpedo_boat);
		
		JMenuItem submarine=new JMenuItem("submarine");
		
		submarine.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ShipMenu.this.proxyship.setShip(null);  //TODO aircraft carrier class
				
			}
		});
		add(submarine);
	}

	public void setProxyship(ProxyShip proxyship) {
		this.proxyship = proxyship;
	}

}
