package variables_typeCasting_auto_and_unboxing;
public class IntegerOperations {

	public static void main(String[] args) {

		int a1 = 8;
		int b1 = 4;
		
		int addResult = a1 + b1;
		System.out.println("The addition of " + a1 + " and " + b1 + " = " + addResult);
		
		Integer a2 = a1; // -> Autoboxing;
		Integer b2 = b1;
		int subResult = a2 - b2;  
		System.out.println("The subtraction of " + a1 + " and " + b1 + " = " + subResult);
		
		int multResult = a1 * b1;
		System.out.println("The multiplication of " + a1 + " and " + b1 + " = " + multResult);
		
		
		int a3 = a2; // -> Unboxing;
		int b3 = b2;
		int divResult = a3 / b3;
		System.out.println("The division of " + a1 + " and " + b1 + " = " + divResult);
		
	}
}
