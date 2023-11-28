import java.util.Scanner;

public class Taking_LettersOnly_Scanner {
	
private static Scanner scanner = new Scanner (System.in);

	public static void main(String[] args) {

		String name = getAllLetters(scanner);
		System.out.println("Your word is: " + name);
	
		scanner.close();
	}
	/*
	 *  getLetter method to validate the input, i.e. to ensure that only letters are entered
	 */
    private static String getAllLetters(Scanner scanner) {
        System.out.print("Please, enter ...: ");
        String input = scanner.nextLine();

        while (!isAllLetters(input.trim())) {
            System.out.print("Invalid input. Please enter only letters for ...: ");
            input = scanner.nextLine();
        }
        // trim method is used to remove leading and trailing whitespace from the input.
        return input.trim();
    }
    // the isAllLetters method checks whether the input consists only of letters.
    private static boolean isAllLetters(String input) {
        return !input.isEmpty() && input.chars().allMatch(Character::isLetter);
    }
}
