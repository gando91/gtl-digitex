package battleship.positioning;

public class TorpedoBoat extends Ship{

	public TorpedoBoat() {
		super(DefaultDimensions.TORPEDO_BOAT_LENGTH.getValue());
	}
	
	@Override
	public void setShipAmount() {
		if(super.getShipAmount() < DefaultDimensions.TORPEDO_BOAT_MAXNUM.getValue());
		super.setShipAmount();
	}
	@Override
	public int getMaxAmount(){
		return DefaultDimensions.TORPEDO_BOAT_MAXNUM.getValue();
	}
}
