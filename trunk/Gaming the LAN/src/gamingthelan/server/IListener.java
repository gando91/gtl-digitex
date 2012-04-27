package gamingthelan.server;

import gamingthelan.netutils.ConnectionHandler;

/**   Generic interface of ServerListener   **/
public interface IListener {
	
	/**
	 * Create a new Game
	 * @param port the port on which the server will listen
	 */
	public void newGame(int port, ConnectionHandler handler);
	
}