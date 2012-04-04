package tests.battleship.MVC;

import javax.swing.JFrame;

public class Frame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public Frame(MainPanel main){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setSize(780, 780);
		setTitle("Battleship!");
		setVisible(true);
		
		add(main);
	}
	
	public static void main(String[] args) {
		
		MatrixModel model=new MatrixModel();
		MatrixView view=new MatrixView(model);
		MatrixController controller=new MatrixController(model);
		view.addMouseListener(controller);
		MainPanel main=new MainPanel(view);
		
		Frame frame = new Frame(main);
	}
	
}
