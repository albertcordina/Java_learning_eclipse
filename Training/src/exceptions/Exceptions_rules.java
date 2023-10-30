package exceptions;
public class Exceptions_rules {
	
	/*
	 * An exception is an event, which occurs during the execution of a program, that disrupts the normal flow of the program's instructions. 
	 * When an error occurs within a method, the method creates an object and hands it off to the runtime system.
	 * 
	 * Unchecked exceptions − An unchecked exception is an exception that occurs at the time of execution. 
	 * These are also called as Runtime-Exceptions. These include programming bugs, such as logic errors or improper use of an API. 
	 * Runtime exceptions are ignored at the time of compilation.
	 * 
	 * Checked exceptions − A checked exception is an exception that is checked (notified) by the compiler at compilation-time, 
	 * these are also called as Compile time-Exceptions. These exceptions cannot simply be ignored, the programmer should take care of (handle) these exceptions.
	 *  https://www.tutorialspoint.com/java/java_exceptions.htm
	 *  
	 *  The Runtime Exception is the parent class in all exceptions of the Java programming language that are expected to crash or break down the program or application when they occur. 
	 *  Unlike exceptions that are not considered as Runtime Exceptions, Runtime Exceptions are never checked.
	 */

	public static void main(String[] args) {

		// int a = 23/0;                        // <- ArithmeticExeption;
		// System.out.println(a);
		
		// String text = null;                  // <- NullPointerExeption;
		// System.out.println(text.length());
		
		// int numbers [] = new int [7];        // <- ArrayIndexOutBoundsExeption;
		// numbers [9] = 59;
		
		// String text = "Text";                // <- NumberFormatException;
		// int number = Integer.parseInt(text);
		
		try {int a = 87/0;}                                                    // 'try' is only working with 'catch';
		catch (ArithmeticException e) {System.out.println("Printed: " + e);}  // <- the line of the Exeption 'e' can also be put with a normal String;
		
		try {int b = 85/0;}
		catch (Exception e) {System.out.println("Wrong action");}           // <- with the super type 'Exception', get access to all the types;
	
	}
}
