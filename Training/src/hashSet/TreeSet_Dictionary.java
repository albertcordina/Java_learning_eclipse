package hashSet; 
import java.util.*;
public class TreeSet_Dictionary {

	    public static void main(String[] args) {
	        Set<String> dictionary = new TreeSet<>();
	        Scanner scanner = new Scanner(System.in);
	        int choice;
	        do {
	            System.out.print("Dictionary Menu:\n\n1. Add a word\n2. Search for a word\n3. Display dictionary\n4. Exit\n\nEnter your choce: ");
	            choice = scanner.nextInt();
	            scanner.nextLine(); // Consume the newline
	            switch (choice) {
	                case 1:
	                    System.out.print("Enter a word: ");
	                    String word = scanner.nextLine();
	                    dictionary.add(word);
	                    System.out.println("Word added to the dictionary.");
	                    break;
	                case 2:
	                    System.out.print("Enter the word to search for: ");
	                    String searchWord = scanner.nextLine();
	                    if (dictionary.contains(searchWord)) {
	                        System.out.println(searchWord + " is in the dictionary.");
	                    } else {
	                        System.out.println(searchWord + " is not in the dictionary.");
	                    }
	                    break;
	                case 3:
	                    if (!dictionary.isEmpty()) {
	                        System.out.println("Dictionary (in alphabetical order):");
	                        for (String dictWord : dictionary) {
	                            System.out.println(dictWord);
	                        }
	                    } else {
	                        System.out.println("The dictionary is empty.");
	                    }
	                    break;
	                case 4:
	                    System.out.println("Exiting the program.");
	                    break;
	                default:
	                    System.out.println("Invalid choice.");
	            }
	        } while (choice != 4);
	        scanner.close();
	    }
	}
