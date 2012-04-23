package tests.game;

import javax.swing.JFrame;

public class AppGame extends JFrame{

	private static final int DEFAULT_SIZE = 780;
	private static final long serialVersionUID = 1L;
	
	public AppGame(MainPanel main){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setSize(DEFAULT_SIZE, DEFAULT_SIZE);
		setTitle("Battleship!");
		
		add(main);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		MatrixModel opponentModel=new MatrixModel();
		MatrixModel myModel=new MatrixModel();
		
		OpponentView view=new OpponentView(opponentModel);
		MyView myview =new MyView(myModel);
		
		TimerModel timermodel=new TimerModel();
		TimerPanel timerpanel=new TimerPanel(timermodel);
		timermodel.addObserver(timerpanel);
		
		MatrixController controller=new MatrixController(opponentModel);
		view.addMouseListener(controller);
		MainPanel main=new MainPanel(view,myview,timerpanel);
		
		
		/* fino a che non ci serve l'oggetto, basta invocare new
		AppGame frame = new AppGame(main);
		*/
		
		new AppGame(main);
	}
	
}
