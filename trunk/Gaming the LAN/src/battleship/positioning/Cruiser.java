package battleship.positioning;

public class Cruiser extends Ship {

	public Cruiser() {
		super(DefaultDimensions.CRUISER_LENGTH.getValue());
	}
	@Override
	public void incrementShipAmount() {
		if(super.getShipAmount() < DefaultDimensions.CRUISER_MAXNUM.getValue());
			super.incrementShipAmount();
	}
	@Override
	public int getMaxAmount(){
		return DefaultDimensions.CRUISER_MAXNUM.getValue();
	}
}
