import java.util.InputMismatchException;
import java.util.Scanner;

class Calculator {

	private int num1;
	private int num2;

	public Calculator(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}

	public int add() {
		return num1 + num2;
	}

	public int subtract() {
		return num1 - num2;
	}

	public int multiply() {
		return num1 * num2;
	}

	public int divide() {
		if (num2 != 0) {
			return num1 / num2;
		} else {
			System.out.println("You cannot divide by zero!");
			return 0;
		}
	}

}

class CalculatorSwitch {

	public static int switchOperation(int choice, Calculator calculator) {

		int result = 0;

		switch (choice) {

		case 1:
			result = calculator.add();
			break;

		case 2:
			result = calculator.subtract();
			break;

		case 3:
			result = calculator.multiply();
			break;

		case 4:
			result = calculator.divide();
			break;

		default:
			System.out.println("Invalid input!");
		}
		return result;
	}
}

public class Sample1 {

	public static void main(String[] args) {

		System.out.println("Welcome to the Simple Calculator!");
		Scanner scanner = new Scanner(System.in);

		int num1 = getInput(scanner, "Enter the first number: ");
		int num2 = getInput(scanner, "Enter the second number:");

		Calculator calculator = new Calculator(num1, num2);

		int choice = getOperationChoice(scanner);

		int result = CalculatorSwitch.switchOperation(choice, calculator);

		System.out.println("Result: " + result);

		scanner.close();

	}

	private static int getInput(Scanner scanner, String message) {

		int input = 0;
		boolean validInput = false;

		while (!validInput) {

			try {
				System.out.print(message);
				input = scanner.nextInt();

				validInput = true;
				scanner.nextLine();

			} catch (InputMismatchException e) {
				System.err.println("Invalid input. Please input a number.\n");
				scanner.nextLine();
			}
		}
		return input;
	}

	private static int getOperationChoice(Scanner scanner) {

		int choice = 0;
		boolean validChoice = false;

		while (!validChoice) {

			try {
				System.out.println("Select an operation:\n1. Addition\n2. Subtraction\n3. Multiplication\n4. Division");

				choice = scanner.nextInt();
				scanner.nextLine();

				if (choice >= 1 && choice <= 4) {
					validChoice = true;
				} else {
					System.out.println("Invalid choice. Please enter a number between 1-4");
				}

			} catch (InputMismatchException e) {
				System.err.println("Invalid input. Please input a number between 1-4");
				scanner.nextLine();
			}
		}

		return choice;
	}
}