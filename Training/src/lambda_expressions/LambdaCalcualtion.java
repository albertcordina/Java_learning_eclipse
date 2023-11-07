package lambda_expressions;

@FunctionalInterface
interface Interface {
	String operation(double num1, double num2);
}

public class LambdaCalcualtion {

	public static void performOperation(Interface a) {
		System.out.println(a.operation(5.00, 3.00)); 
		}

	public static void main(String[] args) {

// creating the instances of the Interface to represent the actual parameters of the Interface above:

		Interface sum = (t, d) -> {
			String result = t + " + " + d + " = " + (t + d);
			return result; };
		System.out.println(sum.operation(5.00, 3.00));

		Interface subtraction = (t, d) -> {
			String result = t + " - " + d + " = " + (t - d);
			return result; };
		System.out.println(subtraction.operation(5.00, 3.00));

		Interface multiplication = (t, d) -> {
			String result = t + " * " + d + " = " + (t * d);
			return result; };
		System.out.println(multiplication.operation(5.00, 3.00));
		
		Interface division = (t, d) -> { 		
			if (d != 0) { String result = t + " / " + d + " = " + (t / d);
			return result; } 
			else { return "Can not be devided to '0'."; }
		};
		System.out.println(division.operation(5.00, 3.00));


		// The performance of the operations via the method 'performOperation' above
		performOperation(sum);
		performOperation(subtraction);
		performOperation(multiplication);
		performOperation(division);
	}
}
