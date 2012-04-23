package miniTestClient;

import java.util.List;

import gamingthelan.netutils.IConnection;
import gamingthelan.netutils.Packet;

public class MyPacket extends Packet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5692030487608480118L;

	public MyPacket(IConnection sender, List<IConnection> receiver, String s) {
		super(sender, receiver,s);

	}

}
