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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TestPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Per creare una connessione dobbiamo dichiarare un oggetto della classe Client che si occupa della comunicazione con il server
	protected Client myClient;
	protected boolean pressed=false;
	protected JButton connect = new JButton("Connect");
	
	public TestPanel(){
		
		final JTextField ipServer = new JTextField("127.0.0.1");
		
		final JTextField nickName = new JTextField("NickName Here");
		
		final JTextField receiver = new JTextField("Receiver Here");
		
		connect.setBackground(Color.GREEN);
		JButton sendInt = new JButton("Send Int");
		JButton sendString = new JButton("Send String");
		
		
		connect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				if(pressed == false){
					
					//Cominciamo creando un nuovo oggetto client, indicando l'ip del server, la porta di comunicazione e un tempo di timeout
					myClient = new Client(nickName.getText(), ipServer.getText(), 8080, 200);
					//Creiamo l'oggetto che si occuperà di gestire i pacchetti che arrivano dal server e lo assegnamo al nostro client
					TestHandler h = new TestHandler(myClient);
					myClient.setHandler(h);
				
					try {
						
						//Utilizziamo il metodo connect della classe client per connetterci al server
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
					
					//Qui utilizziamo il metodo disconnect della classe client per disconnetterci dal server
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
				
				//Istanziamo un oggetto della classe ObjectPacket, un tipo di pacchetto contenente un generico oggetto
				//Essendo un'applicazione di test, abbiamo scelto di mandare il pacchetto a tutti i client connessi, quindi non ci preoccupiamo del destinatario
				ObjectPacket packet = new ObjectPacket(nickName.getText(), new LinkedList<String>());
				//Come contenuto scegliamo una stringa di caratteri, che quindi assegnamo al nostro pacchetto tramite l'apposito metodo
				String testo = JOptionPane.showInputDialog("Inserisci una stringa : ", "Testo pacchetto");
				packet.setContent( testo ); 
				
				try {
					//Attraverso il metodo sendPacket, il client manda il nostro pacchetto al server
					myClient.sendPacket(packet);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Impossibile mandare il pacchhetto \n" + e.getLocalizedMessage());
				}
				
			}
			
		});
		
		sendInt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Anche qui, istanziamo un pacchetto e successivamente gli assegnamo il contenuto, questa volta un numero intero
				ObjectPacket packet = new ObjectPacket(nickName.getText(), new LinkedList<String>());
				
				packet.addReceiver(receiver.getText());
				
				Integer testo = 0;
				
				try {
					testo = Integer.parseInt(JOptionPane.showInputDialog("Inserisci un intero : ", "0"));
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Hai inserito qualcosa che non può essere rappresentato con un intero", "Number format exception", JOptionPane.WARNING_MESSAGE);
				}
				
				packet.setContent( testo ); 
				
				//Tentiamo l'invio del pacchetto, come sopra
				try {
					
					myClient.sendPacket(packet);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Impossibile mandare il pacchhetto \n" + e.getLocalizedMessage());
				}
			}
			
		});
		
		
		this.setLayout(new GridLayout(2,3));
		this.add(nickName);
		this.add(ipServer);
		this.add(connect);
		this.add(receiver);
		this.add(sendInt);
		this.add(sendString);
	}
	
}
