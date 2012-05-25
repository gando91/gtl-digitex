package gamingthelan.netutils;

import java.io.Serializable;
import java.util.List;

/**
 * Library interface for a generic packet.
 * You may implement this in order to get a custom packet.
 * There are already specific packets implementation into netutils package.
 * 
 * @author Digitex Group
 */
public interface IPacket extends Serializable {
	
	
	public List<String> getReceiver();
	
	public String getSender();
	
}
