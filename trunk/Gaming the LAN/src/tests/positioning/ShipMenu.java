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
				
				AircraftCarrier ac=new AircraftCarrier();
				ShipMenu.this.proxyship.setShip(ac);  
				System.out.println(ac.getShipLength());
			}
		});
		add(aircraft_carrier);
		
		JMenuItem cruiser=new JMenuItem("cruiser");
		
		cruiser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Cruiser c=new Cruiser(); 
				ShipMenu.this.proxyship.setShip(c);
				System.out.println(c.getShipLength());  
				
			}
		});
		add(cruiser);
		
		JMenuItem torpedo_boat=new JMenuItem("torpedo boat");
		
		torpedo_boat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				TorpedoBoat tb=new TorpedoBoat(); 
				ShipMenu.this.proxyship.setShip(tb);
				System.out.println(tb.getShipLength());
				
			}
		});
		add(torpedo_boat);
		
		JMenuItem submarine=new JMenuItem("submarine");
		
		submarine.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Submarine sm=new Submarine(); 
				ShipMenu.this.proxyship.setShip(sm);
				System.out.println(sm.getShipLength());
				
			}
		});
		add(submarine);
	}

	public void setProxyship(ProxyShip proxyship) {
		this.proxyship = proxyship;
	}

}
