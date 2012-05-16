package tests.positioning;

import java.util.Observable;

public class ProxyShip extends Observable implements IShip{
	
	private IShip ship;
	private boolean rotated;
	
	
	public ProxyShip(IShip ship) {
		super();
		this.ship=ship;
	}
	
	public void setShipAmount() {
		ship.setShipAmount();
	}
	
	public void update(){
		setChanged();
		notifyObservers();
	}

	public void setShip(IShip ship) {
		this.ship = ship;
		update();
	}

	@Override
	public int getShipLength() {
		
		return ship.getShipLength();
	}

	@Override
	public void setShipLength(int length) {
		ship.setShipLength(length);
		update();
	}

	@Override
	public int getXPosition() {
		
		return ship.getXPosition();
	}

	@Override
	public int getYPosition() {
		
		return ship.getYPosition();
	}

	@Override
	public void setXPosition(int x) {
		ship.setXPosition(x);
		update();
		
	}

	@Override
	public void setYPosition(int y) {
		ship.setYPosition(y);
		update();
	}
	public void rotate(){
		if(rotated == true)
			rotated = false;
		else
			rotated = true;
		update();
	}

	public boolean isRotated() {
		return rotated;
	}

	@Override
	public int getShipAmount() {
		return ship.getShipAmount();
	}

	@Override
	public int getMaxAmount() {
		return ship.getMaxAmount();
	}

	@Override
	public void resetShipAmount() {
		ship.resetShipAmount();
		
	}
	
}
