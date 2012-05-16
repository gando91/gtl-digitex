package tests.positioning;

public interface IShip {
	
	public int getShipLength();
	public void setShipLength(int length);
	
	public void setShipAmount();
	public int getShipAmount();
	public void resetShipAmount();
	public int getMaxAmount();
	
	public int getXPosition();
	public int getYPosition();
	public void setXPosition(int x);
	public void setYPosition(int y);
	

}
