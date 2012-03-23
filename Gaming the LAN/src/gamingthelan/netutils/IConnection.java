package gamingthelan.netutils;

public interface IConnection {
	
	public void sendPacket(IPacket packet);
	public void onReceivedPacket(IPacket packet);
	
}