package hangman.packets;

import java.util.List;

import gamingthelan.netutils.IPacket;

public class DeadPacket implements IPacket {
	
	public static final int HANGMANDEATH = 10;	

	public static int getHangmandeath() {
		return HANGMANDEATH;
	}

	@Override
	public List<String> getReceiver() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSender() {
		// TODO Auto-generated method stub
		return null;
	}

}
