package gamingthelan.netutils;

import java.util.List;

public class SinglePacket extends Packet{
	
	private List<IConnection> receiver;
	SinglePacket(List<IConnection> receiver){
		
		this.receiver = receiver;		
	}
	
	@Override
	public List<IConnection> getReceiver() {
		return receiver;
	}

}
