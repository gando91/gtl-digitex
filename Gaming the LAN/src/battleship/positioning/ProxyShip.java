package battleship.positioning;

import java.util.Observable;

public class ProxyShip extends Observable implements IShip{
	
	private IShip ship;

	
	
	public ProxyShip(IShip ship) {
		super();
		this.ship=ship;
	}
	
	public void incrementShipAmount() {
		ship.incrementShipAmount();
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
		if(ship.isRotated() == true)
			ship.setRotated(false);
		else
			ship.setRotated(true);
		update();
	}

	public boolean isRotated() {
		return ship.isRotated();
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

	public IShip getShip() {
		return ship;
	}
	public Memento generateMemento() {
		return new Memento(ship, ship.isRotated());
	}
	
	public class Memento
	{
		private IShip ship;
		private boolean rotated;
		private int amount;
		
		private Memento(IShip ship, boolean rotated){
			this.ship = ship;
			this.rotated = rotated;
			this.amount = ship.getShipAmount();
			
		}
		
		public void restore() {
			ProxyShip.this.ship = ship;
			ProxyShip.this.ship.setRotated(rotated);
			ship.setShipAmount(amount);
		}
	}

	@Override
	public void setShipAmount(int ShipAmount) {
		this.ship.setShipAmount(ShipAmount);
	}

	@Override
	public void setRotated(boolean rotated) {
		ship.setRotated(rotated);
		
	}
	
}
