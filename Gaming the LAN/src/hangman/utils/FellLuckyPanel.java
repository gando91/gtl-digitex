package hangman.utils;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FellLuckyPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTextField insert=new JTextField();
	private JButton button=new JButton("I'M FEEL LUCKY");
			
	
	public FellLuckyPanel() {
		
		setBackground(Color.BLUE);
		setLayout(null);
		
		insert.setSize(200, 50);
		button.setBounds(200, 0, 150, 50);
		
		button.addActionListener(this);
		
		add(insert);
		add(button);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ho premuto");
		
	}
	
	

}
