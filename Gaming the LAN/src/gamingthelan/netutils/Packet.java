package gamingthelan.netutils;

public class Packet implements IPacket{
	
	// C'è da decidere come implementare mittente e destinatario del pacchetto, che tipo di attributi sono? 
	// Esiste già un oggetto che contenga tali informazioni? E se è un messaggio di broadcast?
	private Object sender;
	private Object receiver;
	
	
	public Object getReceiver() {
		return receiver;
	}
	
	public void setReceiver(Object receiver) {
		this.receiver = receiver;
	}
	
	public Object getSender() {
		return sender;
	}
	public void setSender(Object sender) {
		this.sender = sender;
	}
	

}
