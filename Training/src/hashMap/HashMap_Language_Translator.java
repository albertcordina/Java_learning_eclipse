package hashMap;

import java.util.*;

public class HashMap_Language_Translator {

	public static void main(String[] args) {

		Map<String, String> theTranslator = new HashMap<>();
		Scanner scanner = new Scanner(System.in);
		int option;

		System.out.println("-WELCOME TO THE LANGUAGE TRANSLATOR!-");

		do {
			System.out.print("\n\t  -THE MENU-\n\nPress '1' to enter your word and the translation of it"
					+ "\nPress '2' to look up for the translation via your word\nPress '3' to display the translator\nPress '4' to Exit\n\n"
					+ "Please, enter your option here: ");
			option = scanner.nextInt();

			switch (option) {
			case 1:
				System.out.print("Enter your word: ");
				String word = scanner.nextLine();
				word = scanner.nextLine();
				if (theTranslator.containsKey(word)) {
					System.out.println("Your word is already in the dictionary");
					break;
				}

				System.out.print("Enter the translation of the word '" + word + "': ");
				String translation = scanner.nextLine();

				theTranslator.put(word, translation);
				break;

			case 2:
				System.out.print("Enter your word: ");
				String enterWord = scanner.nextLine();
				enterWord = scanner.nextLine();

				if (theTranslator.containsKey(enterWord)) {
					System.out.println("The translation of '" + enterWord + "' is " + theTranslator.get(enterWord));
				}

				else {
					System.out.println("Sorry, but the database does not contain your word\n");
				}
				break;
				
			case 3:
				System.out.println("\nSee the whole database:\n");
				for (Map.Entry<String, String> map : theTranslator.entrySet()) { // TO ITERATE THE WHOLE 'HashMap';
					System.out.println(map.getKey() + ", " + map.getValue());
				}
				break;
			case 4:
				System.out.println("Thank you for your session!");
				break;
			default:
				System.out.println("Invalid choice.\n");
			}
		} while (option != 4);
		scanner.close();
	}
}