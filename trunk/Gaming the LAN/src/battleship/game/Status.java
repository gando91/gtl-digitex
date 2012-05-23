package battleship.game;

public enum Status {
	
	VIRGIN (0),
	HIT(1),
	MISSED(2),
	SHIP(3);
	
	private int value;
	
	
	private Status(int value){
		
		this.value=value;
		
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	

}
