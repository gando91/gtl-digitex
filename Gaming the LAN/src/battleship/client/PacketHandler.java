package battleship.client;

import java.io.IOException;

import javax.swing.JOptionPane;

import battleship.game.AppGame;
import battleship.game.MatrixModel;
import battleship.game.Status;
import battleship.positioning.AppPositioning;
import gamingthelan.client.ClientConnectionHandler;
import gamingthelan.client.IClient;
import gamingthelan.netutils.IPacket;
import gamingthelan.netutils.servicepackets.DisconnectionPacket;

public class PacketHandler extends ClientConnectionHandler{
	
	private int state = 0;
	private AppPositioning positioning;
	private AppGame game;
	private MatrixModel model = new MatrixModel();
	ResponsePacket p;
	
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
				positioning.getWaitingWindow().closeFrame();
				positioning.closeFrame();
				
				game = new AppGame(model, super.client);
				state = 2;
			}
			
		} else if (state == 2) {
			
			if(packet instanceof MissilePacket){
				
				
				if(model.getStatusmatrix()[((MissilePacket)packet).getRow()][((MissilePacket)packet).getCol()] == Status.SHIP){
					
					model.setstatus(((MissilePacket)packet).getRow(), ((MissilePacket)packet).getCol(), Status.HIT);
					if(model.sunkCheck()){
						System.out.println("AFFONDATA");
						p = new ResponsePacket(client.getConnection().getNickName(), null, 99);
					}
					else{
						System.out.println("COLPITA");
						p = new ResponsePacket(client.getConnection().getNickName(), null, Status.HIT.getValue());
					}
				}
				else
				{
					model.setstatus(((MissilePacket)packet).getRow(), ((MissilePacket)packet).getCol(), Status.MISSED);
					p = new ResponsePacket(client.getConnection().getNickName(), null, Status.MISSED.getValue());
				}
				game.changeTurn();
				
				try {
					
					client.sendPacket(p);
					
					if (model.isOver())
					{
						p = new ResponsePacket(client.getConnection().getNickName(), null, 2000);
						client.sendPacket(p);
						game.lost();
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(packet instanceof ResponsePacket){
				if(((ResponsePacket)packet).getResponse() == 2000){
					game.won();
				}
				if(((ResponsePacket)packet).getResponse() == 1500){
					p = new ResponsePacket(client.getConnection().getNickName(), null, 1200);
				}
				if (((ResponsePacket) packet).getResponse() == 1	){
					game.getOpponentModel().setstatus(game.getController().getNrow(),game.getController().getNcol(),Status.HIT);
					
				}
				if(((ResponsePacket) packet).getResponse() == 2	){
					game.getOpponentModel().setstatus(game.getController().getNrow(),game.getController().getNcol(),Status.MISSED);
					
				}
				if(((ResponsePacket) packet).getResponse() == 99){
					game.getOpponentModel().setstatus(game.getController().getNrow(),game.getController().getNcol(),Status.HIT);
					JOptionPane.showMessageDialog(null, "Colpito e affondato!");
				}
				game.changeTurn();
			}
		}
		
		
	}

	@Override
	public void onDisconnectedClient(DisconnectionPacket packet) {
		game.won();		
	}

	@Override
	public void onClosedConnection(String nickname) {
		// TODO Auto-generated method stub
		
	}

}
