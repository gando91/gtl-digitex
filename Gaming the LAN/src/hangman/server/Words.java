package hangman.server;

import java.util.List;

public class Words {

	private List<String> words;
	private int rnd_index;
	
	public Words(List<String> words){
		
		this.words = words;
	}
	
	public String getRndWord(){
		
		rnd_index = (int) Math.floor(Math.random() * words.size());
		
		return words.get(rnd_index);
	}
}
