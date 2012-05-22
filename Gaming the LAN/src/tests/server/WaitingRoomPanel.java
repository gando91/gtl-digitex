package tests.server;

import gamingthelan.server.Server;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;

import tests.client.StartPacket;

public class WaitingRoomPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private JButton start;

	public WaitingRoomPanel() {
		
		setLayout(new GridLayout(1,1));
		
		start = new JButton("Start");
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Server.getInstance().broadcastMessage(new StartPacket());
				} catch (IOException e1) {
					System.err.println("Errore: invio fallito!");
				}
			}
		});
		
		add(start);
	}

}
