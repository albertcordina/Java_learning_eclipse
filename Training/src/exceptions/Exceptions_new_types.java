package exceptions;

class InvalidAgeException extends Exception { // creating your own 'Exception' by linking to the super type 'Exception';
	
	public InvalidAgeException (String message) { // constructor to set a String in the method 'validate' below;
		super (message);
	}
}

public class Exceptions_new_types {
	
	static void validate (int age) throws InvalidAgeException {
		
		if (age < 21) {throw new InvalidAgeException ("Age is not valid!");} // 'throw' is setting the constructor;
		else {System.out.println("Age is valid!");}
	                                                 }

	public static void main(String[] args) {
		
		try {validate (20);} catch (InvalidAgeException e) {System.out.println("The InvalidAgeException is caught!");}

		
/*		try {
			int number = 50/0;
			System.out.println(number);
			
		}catch (ArithmeticException e) {
			System.out.println(e);
		}finally {
			System.out.println("finally block is always executed.");
		}
		System.out.println("normal flow ..."); */
	}

}
