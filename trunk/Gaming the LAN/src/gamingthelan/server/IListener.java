package gamingthelan.server;

public interface IListener {
	
	/**
	 * Create a new Game
	 * @param port the port on which the server will listen
	 */
	public void newGame(int port);
	
}