package battleship.positioning;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class ShipMenu extends JMenu{
	
	private static final long serialVersionUID = 1L;
	
	private ProxyShip proxyship;
	private IShip[] ships = new IShip[4];
	private static AircraftCarrier aircraftcarrier=new AircraftCarrier();
	private static Cruiser Cruiser=new Cruiser();
	private static TorpedoBoat torpedoboat=new TorpedoBoat();
	private static Submarine Submarine=new Submarine();
	
	
	public ShipMenu(ProxyShip proxyship){
		super("Ships available");
		
		ships[0] = this.aircraftcarrier;
		ships[1] = this.Cruiser;
		ships[2] = this.torpedoboat;
		ships[3] = this.Submarine;
		this.proxyship=proxyship;
		
		JMenuItem aircraft_carrier=new JMenuItem("aircraft_carrier");
		
		aircraft_carrier.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				ShipMenu.this.proxyship.setShip(ShipMenu.aircraftcarrier);  
				System.out.println(ShipMenu.aircraftcarrier.getShipLength());
			}
		});
		add(aircraft_carrier);
		
		JMenuItem cruiser=new JMenuItem("cruiser");
		
		cruiser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				ShipMenu.this.proxyship.setShip(ShipMenu.Cruiser);
				System.out.println(Cruiser.getShipLength());  
				
			}
		});
		add(cruiser);
		
		JMenuItem torpedo_boat=new JMenuItem("torpedo boat");
		
		torpedo_boat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				ShipMenu.this.proxyship.setShip(ShipMenu.torpedoboat);
				System.out.println(torpedoboat.getShipLength());
				
			}
		});
		add(torpedo_boat);
		
		JMenuItem submarine=new JMenuItem("submarine");
		
		submarine.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				ShipMenu.this.proxyship.setShip(ShipMenu.Submarine);
				System.out.println(Submarine.getShipLength());
				
			}
		});
		add(submarine);
	}

	public static AircraftCarrier getAircraftcarrier() {
		return aircraftcarrier;
	}
	
	public IShip[] getShips(){
		return ships;
	}

	public static Cruiser getCruiser() {
		return Cruiser;
	}

	public static TorpedoBoat getTorpedoboat() {
		return torpedoboat;
	}

	public static Submarine getSubmarine() {
		return Submarine;
	}

	public void setProxyship(ProxyShip proxyship) {
		this.proxyship = proxyship;
	}

}
