package exceptions;

public class Exception_custom {

	public static void main(String[] args) throws AgeLessThanZeroException {

		validateAge(-6);
		
	}
	
	private static void validateAge (int age) throws AgeLessThanZeroException {
		if (age < 0) {
			throw new AgeLessThanZeroException ("Something wrong ...");
			//throw new AgeLessThanZeroException (new RuntimeException());
		}
		
		System.out.println("Love is the best!");
	}

}

class AgeLessThanZeroException extends Exception { // we create our own Exception as a child class of 'Exception';
// class AgeLessThanZeroException extends RuntimeException { // <--- for the 'unchecked' Exceptions; then we do need
                                                            //      to put 'throws AgeLessThanZeroException' above.
	public AgeLessThanZeroException () {}
	public AgeLessThanZeroException (String message) {super(message);} 
	public AgeLessThanZeroException (Throwable cause) {super(cause);} // 'Throwable' is also discribing the 'cause' of apperience of Error;
	
}