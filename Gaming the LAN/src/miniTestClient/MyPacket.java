package miniTestClient;

import java.util.List;

import gamingthelan.netutils.IConnection;
import gamingthelan.netutils.Packet;

public class MyPacket extends Packet{
	public MyPacket(IConnection sender, List<IConnection> receiver, String s) {
		super(sender, receiver,s);

	}

}
