package miniTestClient;

import gamingthelan.client.Client;
import gamingthelan.netutils.ObjectPacket;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

	protected Client myClient;
	protected boolean pressed=false;
	protected JButton connect = new JButton("Connect");
	
	public TestPanel(){
		
		final JTextField ipServer = new JTextField();
		ipServer.setText("127.0.0.1");

		connect.setBackground(Color.GREEN);
		JButton sendInt = new JButton("Send Int");
		JButton sendString = new JButton("Send String");
		
		
		connect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				if(pressed == false){
				
					myClient = new Client(ipServer.getText(), 8080, 200);
				
					TestHandler h = new TestHandler(myClient);
					myClient.setHandler(h);
				
					try {
					
						myClient.connect();
						JOptionPane.showMessageDialog(null, "Connessione avvenuta con successo !", "Info", JOptionPane.INFORMATION_MESSAGE);
						connect.setBackground(Color.RED);
						connect.setForeground(Color.WHITE);
						connect.setText("Disconnect");
						pressed = true;
						
			
					} catch (IOException e) {
						JOptionPane.showMessageDialog(null, "Errore di connessione \n" + e.getLocalizedMessage(),"Errore", JOptionPane.ERROR_MESSAGE);
					}
				}
				else{
					myClient.disconnect();
					JOptionPane.showMessageDialog(null, "Disconnessione avvenuta con successo !", "Info", JOptionPane.INFORMATION_MESSAGE);
					connect.setBackground(Color.GREEN);
					connect.setForeground(Color.BLACK);
					connect.setText("Connect");
				
					pressed = false;
				}
			}
		});

		sendString.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				ObjectPacket packet = new ObjectPacket(myClient.getConnection(), new LinkedList<String>());
				String testo = JOptionPane.showInputDialog("Inserisci una stringa : ", "Testo pacchetto");
				packet.setContent( testo ); 
				
				try {
					myClient.sendPacket(packet);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Impossibile mandare il pacchhetto \n" + e.getLocalizedMessage());
				}
				
			}
			
		});
		
		sendInt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				ObjectPacket packet = new ObjectPacket(myClient.getConnection(), new LinkedList<String>());
				
				Integer testo = 0;
				
				try {
					testo = Integer.parseInt(JOptionPane.showInputDialog("Inserisci un intero : ", "0"));
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Hai inserito qualcosa che non può essere rappresentato con un intero", "Number format exception", JOptionPane.WARNING_MESSAGE);
				}
				
				packet.setContent( testo ); 
				
				try {
					myClient.sendPacket(packet);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Impossibile mandare il pacchhetto \n" + e.getLocalizedMessage());
				}
			}
			
		});
		
		
		this.setLayout(new GridLayout(2,2));
		this.add(ipServer);
		this.add(connect);
		this.add(sendInt);
		this.add(sendString);
	}
	
}
