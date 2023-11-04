import java.util.Scanner;

class TextProcessor {
	
	private String input; 
	
	public TextProcessor(String input) {
		super();
		this.input = input; 
	}
	
	public int wordCount() {
		String[] words = input.split(" ");
		int countWords = 0;
		
		for(String word : words) {
			if(!word.isEmpty()) {
				countWords++;
			}
		}
		
		return countWords;
	}
	
	public String findLongestWord() {
		
		String[] words = input.split(" ");
		String longestWord = "";
		
		for(String word : words) {			
			if(word.length() > longestWord.length()) {
				longestWord = word;
			}
		}
		
		return longestWord;
	}
	
	public String removeVowels() {
		
		return input.replaceAll("[AEIOUaeiou]", "");
	}
}

public class Sample3 {

    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);

        System.out.println("Text Processing Program\n");
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();
        
        TextProcessor textProcessor = new TextProcessor(input);

        int wordsCounted = textProcessor.wordCount();
        System.out.println("\nWord count: " + wordsCounted);
        
        String longWord = textProcessor.findLongestWord();
        System.out.println("Longest word: " + longWord);
        
        String noVowels = textProcessor.removeVowels();
        System.out.println("Sentence without vowels: " + noVowels);

        scanner.close();
    }
}