package battleship.game;

import gamingthelan.client.IClient;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AppGame extends JFrame{

	private static final int DEFAULT_SIZE = 782;
	private static final long serialVersionUID = 1L;
	private MatrixController controller;
	private MatrixModel opponentModel;
	private MainPanel main;
	TimerModel timermodel;
	
	public AppGame(MatrixModel myModel, IClient client){
		
		opponentModel=new MatrixModel();
		OpponentView view=new OpponentView(opponentModel);
		MyView myview =new MyView(myModel);
		
		timermodel=new TimerModel(client);
		TimerPanel timerpanel=new TimerPanel(timermodel);
		timermodel.addObserver(timerpanel);
		
		controller=new MatrixController(opponentModel, client);
		view.addMouseListener(controller);
		main=new MainPanel(view,myview,timerpanel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setSize(DEFAULT_SIZE, DEFAULT_SIZE);
		setTitle("Battleship!");
		
		add(main);
		setVisible(true);
	}
	
	public void changeTurn(){
		controller.changeTurn();
		main.turn();
		timermodel.startTimer();
	}
	
	public MatrixModel getOpponentModel(){
		return opponentModel;
	}
	
	public void won()
	{
		JOptionPane.showMessageDialog(null, "Hai vinto la partita !", "Vittoria !", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	public void lost()
	{
		JOptionPane.showMessageDialog(null, "Hai perso la partita !", "Sconfitta !", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public MatrixController getController()
	{
		return controller;
		
	}
	
//	public static void main(String[] args) {
//		
//		
//		MatrixModel myModel=new MatrixModel();
//		
//		OpponentView view=new OpponentView(opponentModel);
//		MyView myview =new MyView(myModel);
//		
//		TimerModel timermodel=new TimerModel();
//		TimerPanel timerpanel=new TimerPanel(timermodel);
//		timermodel.addObserver(timerpanel);
//		
//		MatrixController controller=new MatrixController(opponentModel);
//		view.addMouseListener(controller);
//		MainPanel main=new MainPanel(view,myview,timerpanel);
//		
//		
//		/* fino a che non ci serve l'oggetto, basta invocare new */
//		
//		
//	}
	
}
