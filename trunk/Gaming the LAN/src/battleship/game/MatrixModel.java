package battleship.game;

import java.util.Observable;

public class MatrixModel extends Observable{
	
	private static final int ROWS=11;
	private static final int COLS=11;
	
	
	private Status statusmatrix[][];
	
	public MatrixModel(){
		
		statusmatrix= new Status[ROWS][COLS];
		
		//inizializzo matrice
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				statusmatrix[i][j]=Status.VIRGIN;				
			}			
		}
	
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

	
}
