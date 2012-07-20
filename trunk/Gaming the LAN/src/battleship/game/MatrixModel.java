package battleship.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

import battleship.positioning.IShip;


public class MatrixModel extends Observable{
	
	private static final int ROWS=11;
	private static final int COLS=11;
	
	
	private Status statusmatrix[][];
	private ArrayList<IShip> list;
	
	public MatrixModel(){
		
		statusmatrix= new Status[ROWS][COLS];
		
		//inizializzo matrice
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				statusmatrix[i][j]=Status.VIRGIN;				
			}			
		}
	
	}
	
	public void addShip(IShip ship){
		list.add(ship);
	}
	
	public void rmShip(IShip ship){
		list.remove(ship);
	}
	
	public boolean sunkCheck(){
		boolean alive;
		
		for (Iterator<IShip> iterator = list.iterator(); iterator.hasNext();) {
			IShip ship = (IShip) iterator.next();
			
			alive = false;
			if(ship.isRotated()){
				
				for (int i = 0; i < ship.getShipLength(); i++) {
					
					if(statusmatrix[ship.getXPosition()+i][ship.getYPosition()] != Status.HIT){
						alive = true;
					}
					
				}
				
				if (!alive) {
					list.remove(ship);
					return true;
				}
			}
			else{

				for (int i = 0; i < ship.getShipLength(); i++) {
					
					if(statusmatrix[ship.getXPosition()][ship.getYPosition()+i] != Status.HIT){
						alive = true;
					}
					
				}
				
				if (!alive) {
					list.remove(ship);
					return true;
				}
			}
			
		}
		
		return false;
	}
	
	public void setstatus(int row, int col, Status status){		
		statusmatrix[row][col]=status;
		setChanged();
		notifyObservers();
	}
	
	public boolean isOver()
	{
		
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				if (statusmatrix[i][j]==Status.SHIP)
					return false;
			}			
		}
		
		return true;
		
	}

	public Status getCellStatus(int row, int col) {
		if (col <= COLS && row <= ROWS)
			return statusmatrix[row][col];
		return Status.VIRGIN;
	}
	
	public Status[][] getStatusmatrix() {
		return statusmatrix;
	}
	
	public int getRows() {
		return ROWS;
	}

	public int getCols() {
		return COLS;
	}

	public Memento generateMemento() {
		return new Memento(statusmatrix, list);
	}
	
	public class Memento
	{
		private Status[][] matrix = new Status[11][11];
		private ArrayList<IShip> list;
		
		private Memento(Status matrix[][], ArrayList<IShip> list){
			
			for (int x = 0; x < 11; x++) {
				for (int y = 0; y < 11; y++) {
					this.matrix[x][y] = matrix[x][y]; 
				}
			}
			this.list = new ArrayList<IShip>();
			this.list.addAll(list);
		}
		
		public void restore() {
			MatrixModel.this.statusmatrix = matrix;
			MatrixModel.this.list = list;
			MatrixModel.this.setChanged();
			MatrixModel.this.notifyObservers();
			
		}
	}
	
}
