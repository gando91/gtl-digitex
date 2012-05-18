package tests.connection;

import gamingthelan.client.NickPacket;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConnectionPanel extends JPanel{


	private static final long serialVersionUID = 1L;
	
	JTextField nickname=new JTextField();
	JTextField ip_server=new JTextField();
	JTextField port=new JTextField();
	
	public ConnectionPanel(){

		
		JButton connetti=new JButton("CONNECT");
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
	
	private void reset(){
		nickname.setText(null);
		ip_server.setText(null);
		port.setText(null);
	}
}
