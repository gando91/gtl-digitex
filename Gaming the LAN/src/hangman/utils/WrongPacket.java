package hangman.utils;

import java.util.List;

import gamingthelan.netutils.IPacket;

public class WrongPacket implements IPacket {
	
	private String delinquent;
	private char letter;
	
	public WrongPacket(String delinquent, char letter){
		
		this.delinquent = delinquent;
		this.letter = letter;
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

}
