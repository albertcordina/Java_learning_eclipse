package variables_typeCasting_auto_and_unboxing;
// Casting between primitive types enables you to convert the value of one type to another primitive type.
public class Variable_TypeCasting_rules {

	public static void main(String[] args) {
		
        // WIDENING (Automatic) type casting:
		int x = 7;
		long y = x;
		float z = y;
		
		System.out.println("int " + x + "\nlong " + y + "\nfloat " + z);

		
		// NERROWING (Explicit) type casting:
		double a = 5.5;
		long b = (long) a;
		int c = (int) b;
		
		System.out.println("double " + a + "\nlong " + b + "\nint " + c);
//______________________________________________________________________________________________________________________________________
		
		/* String valueOf() method:
		 * 
		 * valueOf() is a static method present in String class. 
		 * It is used to convert any data type like int, double, char, char array to its string representation by creating a new String object. 
		 * We can also use valueOf() to convert a char array to a String, or a subarray of a char array to a String.
		 */
		
		int value = 30;
		String text = String.valueOf(value);
		
		System.out.println(text + 40);
		
		boolean b1 = true;
		boolean b2 = false;
		
		String text1 = String.valueOf(b1);
		String text2 = String.valueOf(b2);
		
		System.out.println(text1 + " " + text2);
//__________________________________________________________________________________________________		

		// AUTOBOXING and UNBOXING;
		int n1 = 40;
		//Integer n2 = new Integer(n1); // -> Autoboxing or Boxing (a short way is below);
		Integer n2 = n1;
		
		Integer n3 = 6;               // Boxing (assigning a value);
		System.out.println(n2 + " " + n3);
		
		Integer n4 = 60; 
		int n5 = n4; // -> Unboxing;
		System.out.println(n5);
		
		Integer n6 = 79;
		if (n6 < 90) {
			System.out.println(n6);
		}
	}
}
