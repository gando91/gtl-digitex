package tests.positioning;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

import tests.game.MatrixModel;
import tests.game.Status;

public class AppPositioning extends JFrame{

	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_HEIGHT = 752;
	private static final int DEFAULT_WIDTH=750;
	
	
	public static void main(String[] args) {
		
		ProxyShip ps = new ProxyShip(new AircraftCarrier());
		final MatrixModel matrixModel=new MatrixModel();
		SettingsView mp = new SettingsView(ps,matrixModel);//FIXME devo usare sempre lo stesso modello
		AppPositioning ap = new AppPositioning(mp);
		ap.addKeyListener(new ShipController(matrixModel, ps));
		
		ap.setLayout(new BorderLayout());
		
		JMenuBar bar = new JMenuBar();
		bar.add(new ShipMenu(ps));
		ap.setJMenuBar(bar);
		
		ap.add(mp);
		
		JButton ready=new JButton("READY");
		ready.addKeyListener(new ShipController(matrixModel, ps));
		ap.add(ready, BorderLayout.PAGE_END);
		JButton reset=new JButton("RESET");
		reset.addKeyListener(new ShipController(matrixModel, ps));
		ap.add(reset, BorderLayout.PAGE_START);
		
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("ho resettato la matrice");
				for (int i = 0; i < matrixModel.getRows(); i++) {
					for (int j = 0; j < matrixModel.getCols(); j++) {
						
						matrixModel.setstatus(i, j, Status.VIRGIN);
					}
				}
				

			}
		});
		
		
		ap.setVisible(true);
	}
	
	public AppPositioning(SettingsView mp){
		
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setTitle("Ship Positioning");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}
