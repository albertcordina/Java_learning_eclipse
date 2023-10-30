package exceptions;
import java.util.*;
public class Exception_PasswordValidator {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Password Validator\n\nEnter a password: ");
		String password = scanner.nextLine();
		
		try {vlidatePassword(password);                     // <- called the method below;
			System.out.println("Password is valid");}
		catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage()); // <- 'getMessage' is refferring to the 'throw new Ill...' message in the method below;
		}
		
		
		
	}
	public static void vlidatePassword (String password) {  // <- the method checks if the password has less than '8' charactres; 
		if (password.length() < 8) {
			throw new IllegalArgumentException ("Password must be at least 8 characters long.");
		}
	}

}
