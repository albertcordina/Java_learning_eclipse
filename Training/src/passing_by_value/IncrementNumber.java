package passing_by_value;
import java.util.Scanner;
public class IncrementNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter a number: ");
		int number = scanner.nextInt();
	
		System.out.println("The original value is: " + number);
		
		InNumber(number); // the imported method 'InNumber' with the incremented 'int number' below;
		
		System.out.println("The original value is: " + number); // the 'int' number of the 'main' method;
		
	}
	
	static void InNumber (int number) {
		number++;                                                    // incrementation of the value of the 'int number';
		System.out.println("The incremented value is: " + number);   // the print out of the incremented 'int number';
		
	}

}
