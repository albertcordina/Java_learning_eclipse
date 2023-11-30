package taking_Scanner;

import java.util.Scanner;

public class Taking_Password_Access_Attempts_Scanner {

	static Scanner scanner = new Scanner(System.in);
	static String password = "love";

	public static void main(String[] args) {
		enterPassword(scanner);
		scanner.close();
	}

	public static void enterPassword(Scanner scanner) {
		int maxAttempts = 3; // the set 3 attempts

		System.out.println("You have 3 attempts:");

		for (int attempt = 1; attempt <= maxAttempts; attempt++) {
			System.out.print("Attempt " + attempt + ": Enter your password: ");

			try {
				// the input logic to use scanner.next() instead of scanner.nextLine(): i.e.
				// to ensure that the newline character does not interfere with subsequent
				// inputs.
				String userGuess = scanner.next();
				if (userGuess.equals(password)) {
					System.out.println("Thank you!");
					return;
				} else {
					System.out.println("Incorrect input. Try again.");
				}
			} catch (Exception e) {
				System.out.println("An error occurred. Please try again.");
			} finally {
				scanner.nextLine(); // Clear the buffer
			}
		}

		System.out.println("Sorry, you've run out of attempts.");
	}
}
