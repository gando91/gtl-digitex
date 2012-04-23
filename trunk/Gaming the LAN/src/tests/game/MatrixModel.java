package tests.game;

import java.util.Observable;

public class MatrixModel extends Observable{
	
	private static final int rows=11;
	private static final int cols=11;
	private Status statusmatrix[][];
	
	public MatrixModel(){
		
		statusmatrix= new Status[rows][cols];
		
		//inizializzo matrice
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
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
