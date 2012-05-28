package hangman.connection;

import gamingthelan.client.Client;
import hangman.client.PacketHandler;
import hangman.packets.ProtocolPacket;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConnectionPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private static final int HI = 0;
	
	private Client myClient;
	
	private JTextField nickname=new JTextField();
	private JTextField ip_server=new JTextField();
	private JTextField port=new JTextField("8080");
	
	private JButton connetti;
	
	public ConnectionPanel(){
		
		connetti=new JButton("CONNECT");
		
		JButton esci=new JButton("RESET");		
		esci.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		
		port.setSize(10, 10);
		
		setBackground(Color.BLACK);
		setLayout(null);
		
		setBorder(BorderFactory.createEtchedBorder());
		
		JLabel nk=new JLabel("NICKNAME");
		nk.setForeground(Color.WHITE);		
		nk.setBounds(10,10,100,50);
		
		nickname.setBounds(245, 25, 125, 25);
		
		JLabel is=new JLabel("IP SERVER");
		is.setForeground(Color.WHITE);
		is.setBounds(10,70,100,50);
		
		ip_server.setBounds(245, 90, 125, 25);
		
		JLabel p=new JLabel("PORT");
		p.setForeground(Color.WHITE);
		p.setBounds(10,140,100,50);
		
		port.setBounds(245, 155, 125, 25);
		
		connetti.setBounds(10, 225, 175, 35);
		
        esci.setBounds(210, 225, 175, 35);
		
		add(nk);
		add(nickname);
		add(is);
		add(ip_server);
		add(p);
		add(port);
		add(connetti);
		add(esci);
		
		setVisible(true);
		
	}
	
	public void connect(){
		
		if(nickname.getText().equals("")||ip_server.getText().equals("")||port.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Errore nell'inserimento dei parametri.", "Info", JOptionPane.INFORMATION_MESSAGE);
		}
		
		else{	
			//Cominciamo creando un nuovo oggetto client, indicando l'ip del server, la porta di comunicazione e un tempo di timeout
			myClient = new Client(nickname.getText(), ip_server.getText(), Integer.parseInt(port.getText()), 200);
			
			//Creiamo l'oggetto che si occuperà di gestire i pacchetti che arrivano dal server e lo assegnamo al nostro client
			PacketHandler h = new PacketHandler(myClient);
			myClient.setHandler(h);	
				
			//Utilizziamo il metodo connect della classe client per connetterci al server
			try {
				myClient.connect();
				JOptionPane.showMessageDialog(null, "Connessione avvenuta con successo!", "Info", JOptionPane.INFORMATION_MESSAGE);
				h.openWaitingWindow();
				
				try {
					ProtocolPacket p = new ProtocolPacket(nickname.getText(), "server", HI);
					myClient.sendPacket(p);					
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Errore: tentativo di connessione fallito.", "Info", JOptionPane.INFORMATION_MESSAGE);
			}		

		}
	}
	
	private void reset(){
		
		nickname.setText(null);
		ip_server.setText(null);
		port.setText(null);
	}
	
	public JButton getConnetti() {
		return connetti;
	}
	
	@Override
	protected void paintComponent(Graphics arg0) {		
		super.paintComponent(arg0);
	}
	
}
