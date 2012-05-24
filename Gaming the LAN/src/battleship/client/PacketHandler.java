package battleship.client;

import java.io.IOException;

import battleship.game.AppGame;
import battleship.game.MatrixModel;
import battleship.game.Status;
import battleship.positioning.AppPositioning;
import gamingthelan.client.ClientConnectionHandler;
import gamingthelan.client.IClient;
import gamingthelan.netutils.IPacket;
import gamingthelan.netutils.ObjectPacket;
import gamingthelan.netutils.servicepackets.DisconnectionPacket;

public class PacketHandler extends ClientConnectionHandler{
	
	private int state = 0;
	private AppPositioning positioning;
	private AppGame game;
	private MatrixModel model = new MatrixModel();
	
	public PacketHandler(IClient client) {
		super(client);
		
	}

	@Override
	public void onReceivedPacket(IPacket packet) {
		
		
		if (state == 0)
		{
			if ( ((ResponsePacket)packet).getResponse() == 0 ){
				//Mi sono connesso al server ed aspetto che lui mi dia il permesso di iniziare il posizionamento delle navi
				positioning = new AppPositioning(model, super.client);
				state = 1;
				
			}
			
		}else if (state == 1) {
			if(((ResponsePacket)packet).getResponse() == 1000){
				game = new AppGame(model, super.client);
				state = 2;
			}
			
		} else if (state == 2) {
			
			if(packet instanceof MissilePacket){
				ResponsePacket p;
				
				if(model.getStatusmatrix()[((MissilePacket)packet).getRow()][((MissilePacket)packet).getCol()] == Status.SHIP){
					model.setstatus(((MissilePacket)packet).getRow(), ((MissilePacket)packet).getCol(), Status.HIT);
					p = new ResponsePacket(client.getConnection().getNickName(), null, Status.HIT.getValue());
				}
				else
				{
					model.setstatus(((MissilePacket)packet).getRow(), ((MissilePacket)packet).getCol(), Status.MISSED);
					p = new ResponsePacket(client.getConnection().getNickName(), null, Status.MISSED.getValue());
				}
				try {
					client.sendPacket(p);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(packet instanceof ResponsePacket){
				if (((ResponsePacket) packet).getResponse() == 3)
					game.getOpponentModel().setstatus(game.getController().getNrow(),game.getController().getNcol(),Status.HIT);
				else
					game.getOpponentModel().setstatus(game.getController().getNrow(),game.getController().getNcol(),Status.MISSED);
			}
		}
		
		
	}

	@Override
	public void onDisconnectedClient(DisconnectionPacket packet) {
		// TODO Auto-generated method stub		
	}

}
