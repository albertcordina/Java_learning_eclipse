package taking_Scanner;
import java.util.Scanner;

public class Taking_LettersOnly_Scanner {
	
private static Scanner scanner = new Scanner (System.in);

	public static void main(String[] args) {

		String word = getAllLetter(scanner);
		System.out.println("Your word is: " + word);
	
		scanner.close();
	}
	/*
	 *  getLetter method to validate the input, i.e. to ensure that only letters are entered
	 */
    private static String getAllLetter(Scanner scanner) {
    	
        while (true) {
            System.out.print("Please, enter your word: ");

            try {
            	/* the input logic to use scanner.next() instead of scanner.nextLine(): i.e.
            	 * to ensure that the newline character does not interfere with subsequent inputs.
            	 */
                String input = scanner.next();
                if (isAllLetters(input.trim())) {
                	// trim method is used to remove leading and trailing whitespace from the input.
                    return input.trim();
                } else {
                    System.out.println("Invalid input. Please enter only letters.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred. Please try again.");
            } finally {
                scanner.nextLine(); // Clear the buffer
            }
        }
    }
	// the isAllLetters method checks whether the input consists only of letters.
    private static boolean isAllLetters(String input) {
        return !input.isEmpty() && input.chars().allMatch(Character::isLetter);
    }
}
