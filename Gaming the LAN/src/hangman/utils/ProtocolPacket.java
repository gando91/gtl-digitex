package hangman.utils;

import java.util.LinkedList;
import java.util.List;

import gamingthelan.netutils.IPacket;

public class ProtocolPacket implements IPacket{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3245437407470279626L;
	private String sender;
	private List<String> receiver = new LinkedList<String>();
	private int code;
	
	public ProtocolPacket(String sender, String receiver, int code){
		this.sender = sender;
		this.receiver.add(receiver);
		this.code = code;
	}
	@Override
	public List<String> getReceiver() {
		
		return receiver;
	}

	@Override
	public String getSender() {
		
		return sender;
	}
	
	public int getCode(){
		return this.code;
	}

}
