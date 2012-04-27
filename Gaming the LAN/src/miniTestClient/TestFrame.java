package miniTestClient;

import javax.swing.JFrame;

public class TestFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public TestFrame(){
		
		this.add(new TestPanel());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new TestFrame();
	}
}
