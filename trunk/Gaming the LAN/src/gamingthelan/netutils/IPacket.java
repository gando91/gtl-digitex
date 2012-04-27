package gamingthelan.netutils;

import java.io.Serializable;
import java.util.List;

/**
 * Library interface for a generic Packet object.
 * You may implements this in order to get a custom packet.
 * Some packet implementation are implemented into netutils package.
 * @author Alessio
 *
 */
public interface IPacket extends Serializable {
	
	public List<String> getReceiver();
	public String getSender();
	
	
}
