package battleship.positioning;

public class TorpedoBoat extends Ship{

	public TorpedoBoat() {
		super(DefaultDimensions.TORPEDO_BOAT_LENGTH.getValue());
	}
	
	@Override
	public void incrementShipAmount() {
		if(super.getShipAmount() < DefaultDimensions.TORPEDO_BOAT_MAXNUM.getValue());
		super.incrementShipAmount();
	}
	@Override
	public int getMaxAmount(){
		return DefaultDimensions.TORPEDO_BOAT_MAXNUM.getValue();
	}

	@Override
	protected IShip MySelf() {
		return new TorpedoBoat();
	}
	

}
