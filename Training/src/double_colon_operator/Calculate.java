package double_colon_operator;

@FunctionalInterface
interface MathOperation {
	int operate(int num1, int num2);
}

public class Calculate {

	// Task 2: Implement three static methods
	static int addNumbers (int num1, int num2) {
		return num1 + num2;
	}

	static int subtractNumbers (int num1, int num2) {
		return num1 - num2;
	}

	static int multiplyNumbers (int num1, int num2) {
		return num1 * num2;
	}

	// Task 3: Create a method to perform the operation
	static int performOperation (int num1, int num2, MathOperation operation) {
		return operation.operate(num1, num2);
	}

	public static void main(String[] args) {

		// Task 4: Use lambda expressions and method references
		// Lambda expression for addNumbers
		int sum = performOperation (5, 3, (a, b) -> addNumbers (a, b));
		System.out.println("Sum: " + sum);

		// Method reference for subtractNumbers
		int subtraction = performOperation (8, 4, Calculate::subtractNumbers);
		System.out.println("Subraction: " + subtraction);

		// Method reference for multiplyNumbers
		int multiplication = performOperation (6, 7, Calculate::multiplyNumbers);
		System.out.println("Multiplication: " + multiplication);
	}
}
