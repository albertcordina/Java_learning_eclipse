package while_loops;

import java.util.Scanner;

public class Loop_Do {

	public static void main(String[] args) {

		int value = 0;
		while (value < 10) {
			System.out.println("Hello! " + value);
			value = value + 1;
		}

		Scanner scanner = new Scanner(System.in);
		/*
		 * System.out.println("Please, enter a number: "); int number =
		 * scanner.nextInt();
		 * 
		 * while (number != 5) { // the system won't stop asking the user for the a
		 * number unless the user enters '5';
		 * System.out.println("Please, enter a number: "); number = scanner.nextInt(); }
		 */

		int number = 0;
		do { // 'do' loop is always executed first;
			System.out.println("Please, enter a number: ");
			number = scanner.nextInt();
		} while (number != 5);
		
		  scanner.close();
	}
}
