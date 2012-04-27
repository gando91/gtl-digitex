package gamingthelan.netutils;

import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;

public interface IConnection extends Serializable{
	
	/**
	 * Send a single packet immediately, flushing the queue of packets
	 * @param packet The packet who need to be sent
	 * @throws IOException
	 */
	public void sendPacket(IPacket packet) throws IOException;
	
	/**
	 * This method allow you to use a buffered output adding the packets to a queue. You can queue several packet and then send them all using the sendQueue method.
	 * @param packet The packet to queue
	 * @throws IOException
	 */
	public void addToPacketQueue(IPacket packet) throws IOException;
	
	/**
	 * Send a queue of packets trough the network
	 * @throws IOException
	 */
	public void sendQueue() throws IOException;
	
	public Socket getSocket();
}