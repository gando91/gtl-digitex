package battleship.client;

import gamingthelan.netutils.IPacket;

import java.util.LinkedList;
import java.util.List;

public class MissilePacket implements IPacket{

	private static final long serialVersionUID = -4696326431099716131L;

	private String sender;
	private List<String> receiver = new LinkedList<String>();
	private int row;
	private int col;
	
	public MissilePacket(String sender, String receiver, int row, int col){
		this.sender = sender;
		this.receiver.add(receiver);
		this.row = row;
		this.col = col;
	}
	
	@Override
	public List<String> getReceiver() {
		
		return receiver;
	}

	@Override
	public String getSender() {
		
		return sender;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
	
	
	

}
