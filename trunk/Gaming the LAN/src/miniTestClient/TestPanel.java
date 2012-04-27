package miniTestClient;

import gamingthelan.client.Client;
import gamingthelan.netutils.Connection;
import gamingthelan.netutils.IConnection;
import gamingthelan.netutils.GenericObjectPacket;
import gamingthelan.server.ConnectionCreator;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
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
				Client myClient = null;
				
				TestHandler h = new TestHandler(myClient);
				myClient = new Client(ipServer.getText(), 8080, 200, h);

				
				GenericObjectPacket packet = new GenericObjectPacket(myClient.getConnection(), new LinkedList<String>());
				packet.setContent("Testo del pacchetto"); 
				
				
				myClient.sendPacket(packet);
				
				
			}
		});
		
		this.setLayout(new GridLayout(2,1));
		this.add(ipServer);
		this.add(connect);	
	}
	
}
