package gamingthelan.netutils;

import java.io.IOException;

public interface IConnection {
	
	public void sendPacket(IPacket packet) throws IOException;
	
}