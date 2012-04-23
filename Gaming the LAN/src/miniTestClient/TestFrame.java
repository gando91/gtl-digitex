package miniTestClient;

import javax.swing.JFrame;

public class TestFrame extends JFrame{
	
	public TestFrame(){
		this.setSize(800, 800);
		this.add(new TestPanel());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		TestFrame tf = new TestFrame();
	}
}
