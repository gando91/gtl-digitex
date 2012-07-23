package battleship.positioning;

public class Submarine extends Ship{

	public Submarine() {
		super(DefaultDimensions.SUBMARINE_LENGTH.getValue());
	}
	
	@Override
	public void incrementShipAmount() {
		if(super.getShipAmount() < DefaultDimensions.SUBMARINE_MAXNUM.getValue());
			super.incrementShipAmount();
	}
	
	@Override
	public int getMaxAmount(){
		return DefaultDimensions.SUBMARINE_MAXNUM.getValue();
	}
	
	@Override
	public IShip copy() {
		
		return new Submarine();
	}

}
