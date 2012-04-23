package tests.game;

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
	
	public void setstatus(int i, int j, Status status){		
		statusmatrix[i][j]=status;	
		setChanged();
		notifyObservers();
	}

	public Status[][] getStatusmatrix() {
		return statusmatrix;
	}
	
}
