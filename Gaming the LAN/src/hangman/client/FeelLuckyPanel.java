package hangman.client;

import gamingthelan.client.IClient;
import hangman.packets.WordPacket;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FeelLuckyPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private IClient client;
	
	private JTextField insert=new JTextField();
	private JButton button=new JButton("I FEEL LUCKY");
	
	private ActionListener l;
			
	public FeelLuckyPanel(IClient client) {
		
		this.client = client;
		
		setBackground(Color.BLUE);
		setLayout(null);
		
		insert.setSize(200, 50);
		button.setBounds(200, 0, 150, 50);
		
		l = new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					getClient().sendPacket(new WordPacket(getClient().getConnection().getNickName(), null, insert.getText()));
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		};
		
		//button.addActionListener(l);
		
		add(insert);
		add(button);		
	}
	
	public IClient getClient(){
		return client;
	}
	
	public void setEnabled(boolean b){
		if(b)
			button.addActionListener(l);
		else
			button.removeActionListener(l);
	}
	
}
