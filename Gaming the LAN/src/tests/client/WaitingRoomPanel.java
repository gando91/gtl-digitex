package tests.client;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class WaitingRoomPanel extends JPanel{
	
	private JButton ready, disconnect;
	private PacketHandler handler;

	public WaitingRoomPanel(PacketHandler handler) {
		
		this.handler = handler;
		
		setLayout(new GridLayout(1,2));
		
		ready = new JButton("Pronto");
		ready.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getHandler().ready();
			}
		});
		
		disconnect = new JButton("Disconnetti");
		
		add(ready);
		add(disconnect);
	}
	
	public PacketHandler getHandler(){
		return handler;
	}

}
