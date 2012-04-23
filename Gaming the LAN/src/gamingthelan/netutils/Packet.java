package gamingthelan.netutils;

import java.util.List;

public abstract class Packet implements IPacket{
	
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
