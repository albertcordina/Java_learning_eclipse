package exceptions;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandlingDemo {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int[] numbers = { 10, 20, 30, 40, 50 };
		
		try {
			System.out.print("Enter an integer: ");
			int userInput = scanner.nextInt();
			// Attempt to divide by zero
			int result = 100 / userInput;
			// Attempt to access an out-of-bounds index
			
			System.out.println("Element at index " + (userInput + 1) + ": " + numbers[userInput]);
		} catch (InputMismatchException e) {
			System.out.println("InputMismatchException: Please enter a valid integer.");
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException: Cannot divide by zero.");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException: Index out of bounds.");
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		} finally {

			scanner.close();
		}
	}
}