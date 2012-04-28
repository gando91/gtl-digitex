package miniTestClient;

import java.awt.Dimension;

import javax.swing.JFrame;

public class TestFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public TestFrame(){
		
		this.add(new TestPanel());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Client Test");
		
		this.setMinimumSize(new Dimension(200, 100));
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new TestFrame();
	}
}
