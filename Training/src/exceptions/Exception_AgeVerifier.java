package exceptions;

import java.util.Scanner;
class UnderageException extends Exception {
	
    public UnderageException(String message) { // constructor to create 'UnderageException' via the super type 'Exception';
        super(message);                       // providing String message to the user (see the class below);
    }
}

public class Exception_AgeVerifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();
            if (age < 18) {
                throw new UnderageException("Access denied. "         // calling the constructor linking to the 'Exception'
       + "You must be at least 18 years old to access the website.");//  and messaging/ informing to the user;
                		
            }
            System.out.println("You are allowed to access the website.");
        } catch (UnderageException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {           //   use 'finally' to clean up the code from the set 'Exception',
            scanner.close(); //    and close the scanner; 
        }
    }
}
