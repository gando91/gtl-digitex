package gamingthelan.netutils;

import java.io.Serializable;
import java.util.List;

/**
 * Library interface for a generic Packet object.
 * You may implement this in order to get a custom packet.
 * Some packet implementation are implemented into netutils package.
 * 
 *
 */
public interface IPacket extends Serializable {
	
	
	public List<String> getReceiver();
	
	public String getSender();
	
}
