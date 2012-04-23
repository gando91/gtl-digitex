package gamingthelan.netutils;

import java.io.Serializable;
import java.util.List;

public abstract class Packet implements IPacket, Serializable{
	
	
	/**
	 * Since we are going to send this data we need a valid serialID
	 */
	private static final long serialVersionUID = -3646976227473707241L;
	
	private IConnection sender;
	private List<IConnection> receiver;
	private Object content;
	
	public Packet(IConnection sender, List<IConnection> receiver, Object content){
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
		
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
	
	public Object getContent(){
		return content;
		
	}
	

}
