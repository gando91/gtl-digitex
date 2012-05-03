package gamingthelan.netutils;

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
	
	public ObjectPacket(IConnection sender, List<String> receiver){
		this.sender = sender.toString();
		this.receiver = receiver;
		
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
