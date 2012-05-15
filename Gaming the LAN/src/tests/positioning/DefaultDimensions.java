package tests.positioning;

public enum DefaultDimensions {

	DEFAULT_HEIGHT(752),
	DEFAULT_WIDTH(750),
	AIRCRAFT_CARRIER_LENGTH(5),
	AIRCRAFT_CARRIER_MAXNUM(1),
	CRUISER_LENGTH(4),
	CRUISER_MAXNUM(1),
	TORPEDO_BOAT_LENGTH(3),
	TORPEDO_BOAT_MAXNUM(2),
	SUBMARINE_LENGTH(2),
	SUBMARINE_MAXNUM(2);
	
	private int value;
	private DefaultDimensions(int value){
		
		this.value=value;
		
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}
