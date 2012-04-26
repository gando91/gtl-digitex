package gamingthelan.client;

import gamingthelan.netutils.IPacket;

public interface IClient {
	
	public void sendPacket(IPacket packet);
	
}
