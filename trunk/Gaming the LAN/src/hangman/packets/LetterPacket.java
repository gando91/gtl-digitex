package hangman.packets;

import java.util.List;

import gamingthelan.netutils.IPacket;

public class LetterPacket implements IPacket {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4816683701217849086L;
	private String sender;
	private char letter;

	public LetterPacket(String sender, char letter){
		this.sender = sender;
		this.letter = letter;
	}
	@Override
	public List<String> getReceiver() {
		return null;
	}

	@Override
	public String getSender() {
		return sender;
	}
	public char getLetter(){
		return this.letter;
	}

}
