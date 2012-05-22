package gamingthelan.netutils.servicepackets;

import java.util.List;

import gamingthelan.netutils.IPacket;

public class DisconnectionPacket implements IPacket {
	
	private String sender;
	
	public DisconnectionPacket(String sender){
		this.sender = sender;
	}

	@Override
	public List<String> getReceiver() {
		//Everybody who is connected
		return null;
	}

	@Override
	public String getSender() {
		
		return sender;
	}

}
