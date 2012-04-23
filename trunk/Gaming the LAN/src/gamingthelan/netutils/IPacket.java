package gamingthelan.netutils;

import java.util.List;

/*
 * Interfaccia che identifica un oggetto di tipo pacchetto
 */
public interface IPacket {
	
	public List<IConnection> getReceiver();
	
	public IConnection getSender();
	
	public void setSender(IConnection sender);
	
	public Object getContent();
}
