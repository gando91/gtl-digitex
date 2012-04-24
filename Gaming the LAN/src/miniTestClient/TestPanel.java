package miniTestClient;

import gamingthelan.netutils.Connection;
import gamingthelan.netutils.IConnection;
import gamingthelan.netutils.Packet;
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
				try {
					
					Socket s = new Socket();
					
					//Il socket va collegato però, altrimenti come si fa a mandare il pacchetto ?
					SocketAddress sockaddr = new InetSocketAddress(ipServer.getText(),8080);
					s.connect(sockaddr, 2000);
					
					System.out.println("Connesso");
					
					TestHandler h = new TestHandler();
					Connection c = (Connection) ConnectionCreator.getInstance().createConnection(s, h);
					System.out.println("Connessione creata");
					
					Packet packet = new Packet(c, new LinkedList<String>());
					packet.setContent("Testo del pacchetto"); 
					
					System.out.println("Pacchetto creato");
					
					c.sendPacket(packet);
					System.out.println("Pacchetto spedito");
					
					
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		
		this.setLayout(new GridLayout(2,1));
		this.add(ipServer);
		this.add(connect);	
	}
	
}
