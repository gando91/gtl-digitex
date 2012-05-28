package hangman.tests;

import hangman.utils.MainPanel;
import hangman.utils.Words;

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
		
		Words words = new Words(list);			
		MainPanel i = new MainPanel("PISELLO");
	}
}
