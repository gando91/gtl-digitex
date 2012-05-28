package hangman.tests;

import hangman.client.MainPanel;
import hangman.connection.AppConnection;
import hangman.connection.ConnectionPanel;
import hangman.server.Words;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList();
		list.add("aiuto");
		list.add("manfredonia");
		list.add("elettronica");
		list.add("minotauro");
		list.add("spirale");
		list.add("barabba");
		
		new AppConnection(new ConnectionPanel());
	}
}
