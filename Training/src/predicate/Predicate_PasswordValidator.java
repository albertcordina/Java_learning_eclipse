package predicate;

import java.util.Scanner;
import java.util.function.Predicate;

public class Predicate_PasswordValidator {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a password: ");
		String password = scanner.nextLine();
		
		/*
		 * The %s is replaced with the value. The %n tells the console to print it in a new line.
		 */

		boolean result = isNotValidPassword().test(password);
		// Output: Display whether the password is not valid
		System.out.printf("Result: Password %s valid.%n", result ? "is not" : "is"); 
																						 

		scanner.close(); // Close the Scanner to avoid resource leaks
	}

	// Predicate to check if a password is not valid based on specified criteria
	private static Predicate <String> isNotValidPassword() {
		
		return Predicate.not(password -> password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*\\d.*"));
		}
	
	/*
	 * (".*[A-Z].*") - means the password must contain one uppercase letter.
	 * (".*\\d.*") - means the password must contain one digit.
	 * 
	 */

}
