package gamingthelan.netutils;

import java.io.IOException;
import java.net.Socket;

public interface IConnection {
	
	public void sendPacket(IPacket packet) throws IOException;
	public Socket getSocket();
}