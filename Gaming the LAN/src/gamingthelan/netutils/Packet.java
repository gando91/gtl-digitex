package gamingthelan.netutils;

import java.util.List;

public abstract class Packet implements IPacket{
	
	// C'è da decidere come implementare mittente e destinatario del pacchetto, che tipo di attributi sono? 
	// Esiste già un oggetto che contenga tali informazioni? E se è un messaggio di broadcast?
	private IConnection sender;
	
	public abstract List<IConnection> getReceiver();
	
	public IConnection getSender() {
		return sender;
	}
	public void setSender(IConnection sender) {
		this.sender = sender;
	}
	

}
