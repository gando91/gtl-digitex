package tests.connection;

import gamingthelan.client.Client;
import gamingthelan.client.NickPacket;
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
		
		myClient = new Client(nickname.getText(), ip_server.getText(), 8080, 200);
		
		//Creiamo l'oggetto che si occuperà di gestire i pacchetti che arrivano dal server e lo assegnamo al nostro client
		PacketHandler h = new PacketHandler();
		myClient.setHandler(h);
		
		try {
			myClient.connect();
		} catch (IOException e) {
			// TODO Auto-generated catch block			
		}		
		
		LinkedList<String> receiver = new LinkedList<String>();
		ObjectPacket packet = new ObjectPacket(nickname.getText(), receiver);	
		packet.addReceiver("Eric");
		packet.setContent(new String("CANTAMI O DIVA L'IRA DEL PORTO MORONIDE GUASCANE"));
		
		try {
			myClient.sendPacket(packet);
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
