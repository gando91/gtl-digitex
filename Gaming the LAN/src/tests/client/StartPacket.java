package tests.client;

import java.util.List;

import gamingthelan.netutils.IPacket;

public class StartPacket implements IPacket{

	@Override
	public List<String> getReceiver() {
		return null;
	}

	@Override
	public String getSender() {
		return null;
	}

}
