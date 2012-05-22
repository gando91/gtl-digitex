package tests.connection;

import gamingthelan.client.Client;
import gamingthelan.netutils.ObjectPacket;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import miniTestClient.TestHandler;

public class ConnectionPanel extends JPanel{


	private static final long serialVersionUID = 1L;
	private Client myClient;
	
	JTextField nickname=new JTextField();
	JTextField ip_server=new JTextField();
	JTextField port=new JTextField();
	
	public ConnectionPanel(){

		
		JButton connetti=new JButton("CONNECT");
		
		connetti.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
			}
		});
		
		JButton esci=new JButton("RESET");
		
		esci.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		
		port.setSize(10, 10);
		
		setBackground(Color.BLUE);
		setLayout(new GridLayout(4,2));
		
		setBorder(BorderFactory.createEtchedBorder());
		
		JLabel nk=new JLabel("NICKNAME");
		nk.setForeground(Color.WHITE);
		add(nk);
		add(nickname);
		
		JLabel is=new JLabel("IP SERVER");
		is.setForeground(Color.WHITE);
		add(is);
		add(ip_server);
		
		JLabel p=new JLabel("PORT");
		p.setForeground(Color.WHITE);
		add(p);
		add(port);
		
		add(connetti);
		add(esci);
		
		setVisible(true);
		
	}
	
	private void connect(){
		//Cominciamo creando un nuovo oggetto client, indicando l'ip del server, la porta di comunicazione e un tempo di timeout
		myClient = new Client(nickname.getText(), ip_server.getText(), Integer.parseInt(port.getText()), 200);
		//Creiamo l'oggetto che si occuperà di gestire i pacchetti che arrivano dal server e lo assegnamo al nostro client
		TestHandler h = new TestHandler(myClient);
		myClient.setHandler(h);
	
			
		//Utilizziamo il metodo connect della classe client per connetterci al server
		try {
			myClient.connect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null, "Connessione avvenuta con successo !", "Info", JOptionPane.INFORMATION_MESSAGE);
		
		LinkedList<String> r = new LinkedList<String>();
		ObjectPacket p = new ObjectPacket(nickname.getText(), r);
		
		p.setContent("messaggio mandato");
		
		try {
			myClient.sendPacket(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void reset(){
		nickname.setText(null);
		ip_server.setText(null);
		port.setText(null);
	}
}
