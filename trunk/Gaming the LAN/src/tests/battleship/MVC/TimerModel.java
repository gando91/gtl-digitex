package tests.battleship.MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.Timer;

/**
 * This class rapresent the model of a Battleship timer.
 * It can be autoupdated. If you wanna monitor this, use an observer
 * @author Alessio
 *
 */
public class TimerModel extends Observable implements ActionListener{

	//Costante limite di tempo
	private static final int timeLimit = 20;
	
	private Integer timerCount;
	private Timer myTimer;
	
	public TimerModel() {
		super();
		
		//Inizializzo il tempo del timer
		timerCount = timeLimit;
		
		myTimer = new Timer(1000, this);
		
	}
	
	public void startTimer() {
		timerCount = timeLimit;
		myTimer.start();
	}

	public void pauseTimer() {
		myTimer.stop();
	}
	
	public void resetTimer() {
		timerCount = timeLimit;
		myTimer.stop();
	}
	
	
	/**
	 * @return the timerCount
	 */
	public Integer getTimerCount() {
		return timerCount;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (timerCount > 0)
			timerCount--;
		
		if (timerCount == 0) {
			//TODO : Devo avvisare qualcuno che il timer sia arrivato a 0
		}
		
		this.setChanged();
		this.notifyObservers();
	}
	@Override
	public String toString() {
		
		if (timerCount < 10)
			return "0" + timerCount.toString();
		
		return timerCount.toString();
	}
	
}
