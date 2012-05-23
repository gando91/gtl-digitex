package battleship.positioning;

public class Cruiser extends Ship {

	public Cruiser() {
		super(DefaultDimensions.CRUISER_LENGTH.getValue());
	}
	@Override
	public void setShipAmount() {
		if(super.getShipAmount() < DefaultDimensions.CRUISER_MAXNUM.getValue());
			super.setShipAmount();
	}
	@Override
	public int getMaxAmount(){
		return DefaultDimensions.CRUISER_MAXNUM.getValue();
	}
}
