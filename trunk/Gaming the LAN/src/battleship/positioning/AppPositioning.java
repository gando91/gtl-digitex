package battleship.positioning;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

import battleship.game.MatrixModel;
import battleship.game.Status;


public class AppPositioning extends JFrame{

	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_HEIGHT = 732;
	private static final int DEFAULT_WIDTH=750;
	
	ProxyShip ps = new ProxyShip(new AircraftCarrier());
	final ShipMenu menu = new ShipMenu(ps);
	private MatrixModel myMatrixModel;
	
	public AppPositioning(MatrixModel model){
		
		this.myMatrixModel = model;		
		
		addKeyListener(new ShipController(myMatrixModel, ps));
		
		setLayout(new BorderLayout());
		
		JMenuBar bar = new JMenuBar();
		bar.add(menu);
		setJMenuBar(bar);
		
		SettingsView mp = new SettingsView(ps,myMatrixModel);
		add(mp);
		
		JButton ready=new JButton("READY");
		ready.addKeyListener(new ShipController(myMatrixModel, ps));
		add(ready, BorderLayout.PAGE_END);
		
		ready.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//TODO
			}
		});
		
		JButton reset=new JButton("RESET");		
		reset.addKeyListener(new ShipController(myMatrixModel, ps));
		add(reset, BorderLayout.PAGE_START);
		
		reset.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.println("ho resettato la matrice");				
				reset();
			}
		});
		
		//Boiate grafiche
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setTitle("Ship Positioning");
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		
		setVisible(true);
	}
	
	
	protected void reset(){
		
		for (int a = 0; a < menu.getShips().length; a++) {
			System.out.println(menu.getShips()[a].getShipAmount());
			menu.getShips()[a].resetShipAmount();
		}
		
		for (int i = 0; i < myMatrixModel.getRows(); i++) {
			for (int j = 0; j < myMatrixModel.getCols(); j++) {				
				myMatrixModel.setstatus(i, j, Status.VIRGIN);				
			}
		}
	}
	
}
