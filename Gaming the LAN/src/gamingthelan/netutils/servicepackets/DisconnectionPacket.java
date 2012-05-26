package gamingthelan.netutils.servicepackets;

import java.util.List;

import gamingthelan.netutils.IPacket;

/**
 * 
 * @author Digitex Group
 *
 */


public class DisconnectionPacket implements IPacket {
	
	private static final long serialVersionUID = 7946883340254632631L;
	private String sender;
	
	public DisconnectionPacket(String sender){
		this.sender = sender;
	}

	@Override
	public List<String> getReceiver() {
		//Everybody who is connected
		//FIXME by Gando : questo fa schifo, e credo che infranga il principio di sostituzione di liskov.
		return null;
	}

	@Override
	public String getSender() {
		return sender;
	}

}
