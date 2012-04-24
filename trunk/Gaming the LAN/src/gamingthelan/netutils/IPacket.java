package gamingthelan.netutils;

import java.io.Serializable;
import java.util.List;

/*
 * Interfaccia che identifica un oggetto di tipo pacchetto
 */
public interface IPacket extends Serializable {
	
	public List<IConnection> getReceiver();
	
	public IConnection getSender();
	
	public void setSender(IConnection sender);
	
}
