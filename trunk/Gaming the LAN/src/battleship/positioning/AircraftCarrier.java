package battleship.positioning;

public class AircraftCarrier extends Ship{

	public AircraftCarrier() {
		super(DefaultDimensions.AIRCRAFT_CARRIER_LENGTH.getValue());
	}
	
	@Override
	public void incrementShipAmount() {
		if(super.getShipAmount() < DefaultDimensions.AIRCRAFT_CARRIER_MAXNUM.getValue());
			super.incrementShipAmount();
	}
	@Override
	public void resetShipAmount() {
		super.resetShipAmount();
	}
	@Override
	public int getMaxAmount(){
		return DefaultDimensions.AIRCRAFT_CARRIER_MAXNUM.getValue();
	}

}
