package MiniTestServer;

import gamingthelan.server.ServerListener;

public class TestServer {

	public static void main(String[] args) {
		ServerListener l = ServerListener.getInstance();
		l.newGame(8080, new ServerHandler());
	}
	
}
