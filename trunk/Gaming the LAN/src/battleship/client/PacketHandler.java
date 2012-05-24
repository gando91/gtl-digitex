package battleship.client;

import battleship.game.MatrixModel;
import battleship.positioning.AppPositioning;
import gamingthelan.client.ClientConnectionHandler;
import gamingthelan.client.IClient;
import gamingthelan.netutils.IPacket;
import gamingthelan.netutils.ObjectPacket;
import gamingthelan.netutils.servicepackets.DisconnectionPacket;

public class PacketHandler extends ClientConnectionHandler{
	
	private int state = 0;
	private AppPositioning positioning;
	private MatrixModel model = new MatrixModel();
	
	public PacketHandler(IClient client) {
		super(client);
		
	}

	@Override
	public void onReceivedPacket(IPacket packet) {
		
		
		if (state == 0)
		{
			if ( (Integer) ((ObjectPacket)packet).getContent() == 1 ){
				//Mi sono connesso al server ed aspetto che lui mi dia il permesso di iniziare il posizionamento delle navi
				positioning = new AppPositioning(model);
				state = 1;
			}
			
		}else if (state == 1) {
			if((String) ((ObjectPacket)packet).getContent() == "ok"){
				
			}
			
		} else if (state == 2) {
			
		}
		
		
	}

	@Override
	public void onDisconnectedClient(DisconnectionPacket packet) {
		// TODO Auto-generated method stub		
	}

}
