package gamingthelan.netutils;

import java.util.List;

public class Packet implements IPacket {
	
	
	/**
	 * Since we are going to send this data we need a valid serialID
	 */
	private static final long serialVersionUID = -3646976227473707241L;
	
	private String sender;
	private List<String> receiver;
	
	private Object content;
	
	public Packet(IConnection sender, List<String> receiver){
		this.sender = sender.toString();
		
		System.out.println("Costruttore Paccetto : " + sender);
		this.receiver = receiver;
		
	}

	@Override
	public List<String> getReceiver() {
		return receiver;
	}

	@Override
	public String getSender() {
		return sender;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	
	
}
