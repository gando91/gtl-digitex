package tests.positioning;

import java.util.Observable;

public class ProxyShip extends Observable implements IShip{
	
	private IShip ship;
	
	
	public ProxyShip(IShip ship) {
		super();
		this.ship=ship;
	}
	
	public void update(){
		setChanged();
		notifyObservers();
	}

	public void setShip(IShip ship) {
		this.ship = ship;
	}

	@Override
	public int getShipLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setShipLength(int length) {
		// TODO Auto-generated method stub
		
	}

}
