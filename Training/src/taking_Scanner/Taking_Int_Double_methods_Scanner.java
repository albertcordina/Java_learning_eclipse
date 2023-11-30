package taking_Scanner;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Taking_Int_Double_methods_Scanner {

	static Scanner scanner = new Scanner (System.in);
	
public static void main(String[] args) {
	
	System.out.print("Enter the int. ");
	int inputInt = getInt(); // 'inputInt' is the example of the name of the requested int
	System.out.println(inputInt);
	
	System.out.print("Enter the double. ");
	double inputDouble = getDouble(); // 'inputDouble' is the example of the name of the requested double
	System.out.println(inputDouble);
}
//-----------------------------------------------------------------------------------------------
	private static int getInt() {
		int userInput = 0;
		boolean validInput = false;

		do {
			try {
				System.out.print("Enter here: ");
				userInput = scanner.nextInt();
				validInput = true;
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid number.");
				scanner.nextLine(); // Consume newline
			}
		} while (!validInput);
		return userInput;
	}
//-----------------------------------------------------------------------------------------------
	private static double getDouble() {
		double userInput = 0;
		boolean validInput = false;

		do {
			try {
				System.out.print("Enter here: ");
				userInput = scanner.nextDouble();
				validInput = true;
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid number.");
				scanner.nextLine(); // Consume newline
			}
		} while (!validInput);
         scanner.close(); // Close the scanner to avoid resource leaks.NOTE: It must be only at the end of the code!
		return userInput;		
	}
}
