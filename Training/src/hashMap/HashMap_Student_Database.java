package hashMap;

import java.util.*;

public class HashMap_Student_Database {

	public static void main(String[] args) {

		Map<String, Integer> studentDatabase = new HashMap<>();
		Scanner scanner = new Scanner(System.in);
		int option;
		System.out.println("-WELCOME TO OUR 'STUDENT DATABASE'!-");

		do {
			System.out.print("\n\t  -THE MENU-\n\nPress '1' to add your name and your student ID"
					+ "\nPress '2' to retrive your ID via your name\nPress '3' to display database\nPress '4' to Exit\n\n"
					+ "Please, enter your option here: ");
			option = scanner.nextInt();

			switch (option) {
			case 1:
				System.out.print("Enter your name: ");
				String name = scanner.nextLine();
				name = scanner.nextLine();
				if (studentDatabase.containsKey(name)) {
					System.out.println("Your name is already in the database");
					break;
				}
				
				System.out.print("Enter your ID: ");
				int ID = scanner.nextInt();

				studentDatabase.put(name, ID);
				break;
			case 2:
				System.out.print("Enter your name: ");
				String enterName = scanner.nextLine();
				enterName = scanner.nextLine();

				if (studentDatabase.containsKey(enterName)) {
					System.out.println("Your ID is " + studentDatabase.get(enterName));
				}

				else {
					System.out.println("Sorry, but the database does not contain your name\n");
				}
				break;
			case 3:
				System.out.println("\nSee the whole database:\n");
				for (Map.Entry<String, Integer> map : studentDatabase.entrySet()) { // TO ITERATE THE WHOLE 'HashMap';
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