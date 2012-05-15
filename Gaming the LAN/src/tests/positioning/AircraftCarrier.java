package tests.positioning;

public class AircraftCarrier extends Ship{

	public AircraftCarrier() {
		super(DefaultDimensions.AIRCRAFT_CARRIER_LENGTH.getValue());
	}
	
	@Override
	public void setShipAmount() {
		if(super.getShipAmount() < DefaultDimensions.AIRCRAFT_CARRIER_MAXNUM.getValue());
			super.setShipAmount();
	}
	@Override
	public int getMaxAmount(){
		return DefaultDimensions.AIRCRAFT_CARRIER_MAXNUM.getValue();
	}
}
