package taking_Scanner;

import java.util.Scanner;

public class Taking_Int_CertainAmountOfDigits_phoneNumber_Scanner {

	static Scanner scanner = new Scanner(System.in);
	
    public static void main(String[] args) {
    	
        int number = getValidNumber(scanner);
        System.out.println("You entered: " + number);
        scanner.close();
    }

    public static int getValidNumber(Scanner scanner) {

		int validPhoneNumber;

		do {
			System.out.print("Enter a number with 7 to 15 digits: ");

			try {
				/*
				 * the input logic to use scanner.next() instead of scanner.nextLine(): i.e.
				 * to ensure that the newline character does not interfere with subsequent inputs.
				 */
				validPhoneNumber = Integer.parseInt(scanner.next());
				// Check if the number of digits is between 7 and 15 (inclusive)
				if (String.valueOf(validPhoneNumber).length() >= 7 && String.valueOf(validPhoneNumber).length() <= 15) {
					break; // Exit the loop if the input is valid
				} else {
					System.out.println("Number must have 7 to 15 digits. Try again.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a valid number.");
				// Clear the buffer
				scanner.nextLine();
			}
		} while (true);

		return validPhoneNumber;
	}
}
