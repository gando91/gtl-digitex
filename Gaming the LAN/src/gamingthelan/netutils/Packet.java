package gamingthelan.netutils;

import java.util.List;

public abstract class Packet implements IPacket {
	
	
	/**
	 * Since we are going to send this data we need a valid serialID
	 */
	private static final long serialVersionUID = -3646976227473707241L;
	
	private IConnection sender;
	private List<IConnection> receiver;
	
	public Packet(IConnection sender, List<IConnection> receiver){
		this.sender = sender;
		this.receiver = receiver;
		
	}
	
	public List<IConnection> getReceiver(){
		return receiver;
	}
	
	public IConnection getSender() {
		return sender;
	}
	
	public void setSender(IConnection sender) {
		this.sender = sender;
	}
	

}
