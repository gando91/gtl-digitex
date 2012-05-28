package hangman.client;

import hangman.connection.AppConnection;
import hangman.connection.ConnectionPanel;
import hangman.server.Words;

import java.util.ArrayList;
import java.util.List;

public class TestClient {

	public static void main(String[] args) {
		
		new AppConnection(new ConnectionPanel());
	}
}
