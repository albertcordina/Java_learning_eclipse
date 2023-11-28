
import java.util.Scanner;

public class Taking_Int_CertainAmountOfDigits_phoneNumber_Scanner {

	static Scanner scanner = new Scanner(System.in);
	
    public static void main(String[] args) {
    	
        int number = getValidNumber(scanner);
        System.out.println("You entered: " + number);
        scanner.close();
    }

    public static int getValidNumber(Scanner scanner) {

        while (true) {
            System.out.print("Enter a number with 7 to 15 digits: ");
            String userInput = scanner.nextLine();

            // Check if the input is a valid integer
            if (userInput.matches("\\d+")) {
                // Check if the number of digits is between 7 and 15 (inclusive)
                if (userInput.length() >= 7 && userInput.length() <= 15) {
                    return Integer.parseInt(userInput);
                } else {
                    System.out.println("Number must have 7 to 15 digits. Try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}
