package taking_Scanner;

import java.util.Scanner; // Alt + Enter;

public class Taking_yes_or_not_Scanner {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("We need a response from you. ");

		yesOrNot(scanner);
		System.out.println("Your choice: " + yesOrNot(scanner));
		scanner.close();
	}

	public static String yesOrNot(Scanner scanner) {

		System.out.print("Please, enter 'yes' or 'not': ");
		String input = scanner.next().toLowerCase();

		while (!input.equals("yes") && !input.equals("not")) {
			System.out.print("Please, enter 'yes' or 'not': ");
			input = scanner.next().toLowerCase();
		}
		return input;
	}
}