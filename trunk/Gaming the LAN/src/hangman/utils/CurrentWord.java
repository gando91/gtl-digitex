package hangman.utils;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class CurrentWord {

	private String word;
	private List<Boolean> visibility = new ArrayList(); // This array marks the position of the visible letters with true.
							  							// If the letter in "x" position is not visible, then it is marked with
	                          							// false.
	
	private static CurrentWord instance;
	
	private CurrentWord(){		
	}
	
	public static CurrentWord getInstance(){
		
		if(instance==null)
			instance = new CurrentWord();
			
		return instance;
	}
	
	
	public void setCurrentWord(String word){
		
		this.word = word;		
		resetVisibility();
		inizializeVisibility();	
	}
	
	private void resetVisibility(){
		
		int size = visibility.size();
		
		for (int i=0; i<size; i++){			
			visibility.remove(0);
		}		
	}
	
	private void inizializeVisibility(){
		
		// Now it generate three random indexes which represent three visible positions of the current word.		
		int i1,i2,i3;
		
		i1 = (int)Math.floor(Math.random()*word.length());
		
		do{			
			i2 = (int)Math.floor(Math.random()*word.length());
		}while(i1==i2);
		
		do{			
			i3 = (int)Math.floor(Math.random()*word.length());			
		}while(i1==i3 || i2==i3);
		
		// This for cicle marks with boolean values the List<Boolean> visibility.		
		for (int i = 0; i < word.length(); i++) {
			
			if(i==i1||i==i2||i==i3)
				visibility.add(true);
			else
				visibility.add(false);
		}
	}
	
	public void letterCheck(char letter){
		
		// If true, this variable signals that the checked letter appears in the current word.
		boolean flag = false;
		
		for (int i = 0; i < word.length(); i++) {
				
			if(word.charAt(i)==letter){
				visibility.set(i, true);
				flag = true;
			}
		}
		
		if(flag==false){
			// TODO: add element to the hangman.
			JOptionPane.showMessageDialog(null,"Wrong letter!");
		}
	}
	
	public String getVisibleString(){
		
		char[] visible_string = new char[word.length()];
		
		for (int i = 0; i < word.length(); i++) {
			
			if(visibility.get(i)==true)
				visible_string[i] = word.charAt(i);
			else
				visible_string[i] = 45;
		}
		
		return String.copyValueOf(visible_string);
	}
}
