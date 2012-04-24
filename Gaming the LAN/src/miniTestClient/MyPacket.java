package miniTestClient;

import java.util.List;

import gamingthelan.netutils.IConnection;
import gamingthelan.netutils.IPacket;
import gamingthelan.netutils.Packet;

public class MyPacket implements IPacket{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5692030487608480118L;

	private String testo;
	private Integer a;
	

	public void setTesto(String testo, Integer a)
	{
		this.testo = testo;
		this.a = a;
	}
	
	public String getContent() {
		return testo+a;
	}

	@Override
	public List<String> getReceiver() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSender() {
		// TODO Auto-generated method stub
		return null;
	}
}
