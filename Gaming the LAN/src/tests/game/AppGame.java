package tests.game;

import javax.swing.JFrame;

public class AppGame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public AppGame(MainPanel main){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setSize(780, 780);
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
		
		
		
		AppGame frame = new AppGame(main);
	}
	
}
