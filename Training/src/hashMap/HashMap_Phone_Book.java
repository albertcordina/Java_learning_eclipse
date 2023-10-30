package hashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMap_Phone_Book {

		public static void main(String[] args) {

			Map<String, Integer> phoneBook = new HashMap<>();
			Scanner scanner = new Scanner(System.in);
			int option;
			System.out.println("-WELCOME TO OUR PHONE BOOK!-");

			do {
				System.out.print("\n\t  -THE MENU-\n\nPress '1' to enter your name and your phone number"
						+ "\nPress '2' to look up your phone number via your name\nPress '3' to display the phone book\nPress '4' to Exit\n\n"
						+ "Please, enter your option here: ");
				option = scanner.nextInt();

				switch (option) {
				case 1:
					System.out.print("Enter your name: ");
					String name = scanner.nextLine();
					name = scanner.nextLine();
					if (phoneBook.containsKey(name)) {
						System.out.println("Your name is already in the phone book");
						break;
					}
					
					System.out.print("Enter your phone number: ");
					int phoneNumber = scanner.nextInt();

					phoneBook.put(name, phoneNumber);
					break;
				case 2:
					System.out.print("Enter your name: ");
					String enterName = scanner.nextLine();
					enterName = scanner.nextLine();

					if (phoneBook.containsKey(enterName)) {
						System.out.println("Your phone number is " + phoneBook.get(enterName)); // we get the 'value' via the 'key';
					}

					else {
						System.out.println("Sorry, but the phone book does not contain your name\n");
					}
					break;
					
				case 3:
					System.out.println("\nSee the whole list of the phone book:\n");
					for (Map.Entry<String, Integer> map : phoneBook.entrySet()) {     // TO ITERATE THE WHOLE 'HashMap';
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