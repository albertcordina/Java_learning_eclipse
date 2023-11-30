package taking_Scanner;
import java.util.Scanner;

public class Taking_Int_Double_positive_methods_Scanner {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
	

		System.out.print("Enter the int. ");
		// 'inputInt' is the example of the name of the requested posive int
		int inputInt = getPositiveInt(scanner);
		System.out.println(inputInt);

		System.out.print("Enter the double. ");
		// 'inputDouble' is the example of the name of the requested positive double
		double inputDouble = getPositiveDouble(scanner);
		System.out.println(inputDouble);
   }
//-----------------------------------------------------------------------------------------------
	private static int getPositiveInt(Scanner scanner) {
		int userInput = 0;
		do {
			try {
				System.out.print("Enter a positive number: ");
				userInput = scanner.nextInt();

				if (userInput <= 0) {
					System.out.println("Please enter a positive number greater than 0.");
				}
			} catch (java.util.InputMismatchException e) { // Handle non-integer input
				System.out.println("Invalid input. Please enter a valid number.");
				scanner.nextLine(); // Consume the invalid input to prevent an infinite loop
				userInput = 0; // Set userInput to 0 to continue the loop
			}

		} while (userInput <= 0);
		// At this point, userInput contains a valid positive integer
		System.out.println("You entered: " + userInput);

		return userInput;
	}
//------------------------------------------------------------------------------------------------
	private static double getPositiveDouble(Scanner scanner) {

		double userInput = 0;
		do {
			try {
				System.out.print("Enter a positive number: ");
				userInput = scanner.nextDouble();

				if (userInput <= 0) {
					System.out.println("Please enter a positive number greater than 0.");
				}
			} catch (java.util.InputMismatchException e) { // Handle non-integer input
				System.out.println("Invalid input. Please enter a valid number.");
				scanner.nextLine(); // Consume the invalid input to prevent an infinite loop
				userInput = 0; // Set userInput to 0 to continue the loop
			}

		} while (userInput <= 0);
		// At this point, userInput contains a valid positive integer
		System.out.println("You entered: " + userInput);
        scanner.close(); // Close the scanner to avoid resource leaks.NOTE: It must be only at the end of the code!
		return userInput;
	}
}
