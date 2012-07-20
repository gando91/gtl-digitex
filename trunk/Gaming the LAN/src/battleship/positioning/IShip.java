package battleship.positioning;

public interface IShip {
	
	public int getShipLength();
	public void setShipLength(int length);
	
	public void incrementShipAmount();
	public int getShipAmount();
	public void setShipAmount(int ShipAmount);
	public void resetShipAmount();
	public int getMaxAmount();
	
	public int getXPosition();
	public int getYPosition();
	public void setXPosition(int x);
	public void setYPosition(int y);
	

	public boolean isRotated();
	public void setRotated(boolean rotated);

	

}
