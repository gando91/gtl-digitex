package tests.battleship.MVC;

public enum Status {
	
	VIRGIN (0),
	HIT(1),
	MISSED(2);
	
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
