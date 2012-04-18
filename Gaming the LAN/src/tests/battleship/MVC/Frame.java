package tests.battleship.MVC;

import javax.swing.JFrame;

public class Frame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public Frame(MainPanel main){
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
		
		TimerPanel timerpanel=new TimerPanel();
		
		MatrixController controller=new MatrixController(opponentModel);
		view.addMouseListener(controller);
		MainPanel main=new MainPanel(view,myview,timerpanel);
		
		
		
		Frame frame = new Frame(main);
	}
	
}
