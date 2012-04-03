package gamingthelan.netutils;

import java.util.List;

public abstract class Packet implements IPacket{
	
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
