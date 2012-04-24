package tests.positioning;

public class Ship implements IShip{
	
	private int shiplength;
	
	public Ship(int shiplength){
		super();
		this.shiplength=shiplength;
		
	}

	@Override
	public int getShipLength() {
		
		return shiplength;
	}

	@Override
	public void setShipLength(int length) {
		this.shiplength=length;
		
	}

}
