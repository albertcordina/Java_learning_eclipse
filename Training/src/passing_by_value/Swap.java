package passing_by_value;
import java.util.Scanner;
public class Swap {

	public static void main(String[] args) {
		Swap app = new Swap();

		Scanner scanner = new Scanner(System.in);

		System.out.print("THE SWAP OF THE TWO NUMBERS \n\nPlease, enter the first number: ");
		int number1 = scanner.nextInt();

		System.out.print("Enter the second number: ");
		int number2 = scanner.nextInt();

		System.out.println("Your numbers before the swap: " + number1 + " and " + number2);

		app.display(number1, number2); // printing out the 'display' method;

	}

	public void display(int number1, int number2) {
		int extraInt = number1; // creating an 'extraEnt' variable for moving the 'number1' and 'number2';
		number1 = number2;
		number2 = extraInt;

		System.out.println("See the swaped entered numbers: " + number1 + " and " + number2);

	}

}

