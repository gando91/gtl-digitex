package hangman.packets;

import java.util.List;

import gamingthelan.netutils.IPacket;

public class WrongPacket implements IPacket {
	
	private String delinquent;
	private char letter;
	private int status;
	
	public WrongPacket(String delinquent, char letter, int status){
		
		this.delinquent = delinquent;
		this.letter = letter;
		this.status = status;
	}

	@Override
	public List<String> getReceiver() {
		return null;
	}

	@Override
	public String getSender() {
		return null;
	}

	public String getDelinquent() {
		return delinquent;
	}

	public char getLetter() {
		return letter;
	}
	
	public int getStatus(){
		return status;
	}
}
