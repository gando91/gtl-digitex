package hangman.utils;

import java.util.LinkedList;
import java.util.List;

import gamingthelan.netutils.IPacket;

public class WordPacket implements IPacket{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7445290234326443232L;

	private String sender;
	private String word;
	private List<String> receiver = new LinkedList<String>();

	public WordPacket(String sender, String receiver, String word){
		this.receiver.add(receiver);
		this.sender = sender;
		this.word = word;
	}
	@Override
	public List<String> getReceiver() {
		return null;
	}

	@Override
	public String getSender() {
		return sender;
	}
	public String getWord(){
		return this.word;
	}

}
