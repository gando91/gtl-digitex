package battleship.positioning;

public abstract class Ship implements IShip{
	
	private int shiplength;
	private int xposition;
	private int yposition;
	private int shipamount=0;
	private boolean rotated = false;
	
	@Override
	public int getShipAmount() {
		return shipamount;
	}

	public void incrementShipAmount() {
		shipamount=shipamount+1;
	}
	
	@Override
	public void setShipAmount(int ShipAmount) {
		this.shipamount = ShipAmount;
		
	}

	public Ship(int shiplength,int xposition,int yposition){
		super();
		this.shiplength=shiplength;
		this.xposition=xposition;
		this.yposition=yposition;
		
	}
	
	public boolean isRotated() {
		return rotated;
	}

	public void setRotated(boolean rotated) {
		this.rotated = rotated;
	}

	public Ship(int shiplength){
		super();
		this.shiplength=shiplength;
		this.xposition=0;
		this.yposition=0;
		
	}

	@Override
	public int getShipLength() {
		
		return shiplength;
	}

	@Override
	public void setShipLength(int length) {
		this.shiplength=length;
		
	}

	@Override
	public int getXPosition() {
		
		return xposition;
	}

	@Override
	public int getYPosition() {
		
		
		return yposition;
	}

	@Override
	public void setXPosition(int x) {
		
		this.xposition=x;
		
	}

	@Override
	public void setYPosition(int y) {
		
		this.yposition=y;
	}

	@Override
	public void resetShipAmount() {
		shipamount = 0;
		
	}
	
	@Override
	public IShip copy() {
		IShip ship = MySelf();
		ship.setXPosition(getXPosition());
		ship.setYPosition(getYPosition());
		ship.setRotated(isRotated());
		return ship;
	}
	
	protected abstract IShip MySelf();

}
