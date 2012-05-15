package tests.positioning;

public class Submarine extends Ship{

	public Submarine() {
		super(DefaultDimensions.SUBMARINE_LENGTH.getValue());
	}
	
	@Override
	public void setShipAmount() {
		if(super.getShipAmount() < DefaultDimensions.SUBMARINE_MAXNUM.getValue());
			super.setShipAmount();
	}
	
	@Override
	public int getMaxAmount(){
		return DefaultDimensions.SUBMARINE_MAXNUM.getValue();
	}

}
