package gamingthelan.netutils;

import java.util.LinkedList;
import java.util.List;

/**
 * A general purpose concrete implementation of IPacket.
 * This class will allow you to send a packet with a Java object attached to it.
 * The attached object MUST implements Serializable interface.
 * 
 * @author Alessio
 *
 */
public class ObjectPacket implements IPacket {
	
	
	/**
	 * Since we are going to send this data we need a valid serialID
	 */
	private static final long serialVersionUID = -3646976227473707241L;
	
	private String sender;
	private List<String> receiver;
	
	private Object content;
	
	
	/**
	 * Create a new object packet for multicasting purposes
	 * @param sender Who is sending this package
	 * @param receiver A list of receivers
	 */
	public ObjectPacket(String sender, List<String> receiver){
		this.sender = sender;
		this.receiver = receiver;
		
	}
	
	/**
	 * Create a new object packet with a single receiver
	 * @param sender Who is sending this packet
	 * @param receiver the receiver of this packet
	 */
	public ObjectPacket(String sender, String receiver){
		this.sender = sender;
		this.receiver = new LinkedList<String>();
		this.receiver.add(receiver);
	}
	
	public void addReceiver(String r){
		receiver.add(r);
	}

	@Override
	public List<String> getReceiver() {
		return receiver;
	}

	@Override
	public String getSender() {
		return sender;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}	
	
}
