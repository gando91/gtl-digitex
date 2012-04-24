package gamingthelan.netutils;

import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;

public interface IConnection extends Serializable{
	
	public void sendPacket(IPacket packet) throws IOException;
	public Socket getSocket();
}