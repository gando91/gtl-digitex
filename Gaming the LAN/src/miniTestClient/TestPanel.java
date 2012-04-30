package miniTestClient;

import gamingthelan.client.Client;
import gamingthelan.netutils.ObjectPacket;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TestPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TestPanel(){
		
		final JTextField ipServer = new JTextField();
		ipServer.setText("127.0.0.1");
		JButton connect = new JButton("Connetti");

		connect.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Client myClient = new Client(ipServer.getText(), 8080, 200);
				
				TestHandler h = new TestHandler(myClient);
				myClient.setHandler(h);
				
				try {
					
					myClient.Connect();
			
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Errore di connessione \n" + e.getLocalizedMessage());
				}
				
				ObjectPacket packet = new ObjectPacket(myClient.getConnection(), new LinkedList<String>());
				packet.setContent("Testo del pacchetto"); 
				
				try {
					myClient.sendPacket(packet);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Impossibile mandare il pacchhetto \n" + e.getLocalizedMessage());
				}
				
				
			}
		});
		
		this.setLayout(new GridLayout(2,1));
		this.add(ipServer);
		this.add(connect);	
	}
	
}
