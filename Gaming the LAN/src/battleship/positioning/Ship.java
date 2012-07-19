package battleship.positioning;

public abstract class Ship implements IShip{
	
	private int shiplength;
	private int xposition;
	private int yposition;
	private int shipamount=0;
	
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

}
