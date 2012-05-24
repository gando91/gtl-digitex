package battleship.client;

import java.util.LinkedList;
import java.util.List;

import gamingthelan.netutils.IPacket;

public class ResponsePacket implements IPacket{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2128588280116302424L;
	private String sender;
	private List<String> receiver = new LinkedList<String>();
	private int response;
	
	public ResponsePacket(String sender, String receiver, int response){
		this.sender = sender;
		this.receiver.add(receiver);
		this.response = response;
	}
	
	@Override
	public List<String> getReceiver() {
		
		return receiver;
	}

	@Override
	public String getSender() {
		
		return sender;
	}
	
	public int getResponse(){
		return response;
	}
	
	public void setResponse(int response){
		this.response = response;
	}
	

}
