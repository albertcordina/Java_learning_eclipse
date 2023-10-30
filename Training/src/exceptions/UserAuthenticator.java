package exceptions;

import java.util.Scanner;
class AuthenticationException extends Exception {
   
	public AuthenticationException(String message) {
        super(message);
    }
}

public class UserAuthenticator {
	
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            
            System.out.print("Enter password: ");
            String password = readPasswordSecurely();
            
            boolean isAuthenticated = authenticateUser(username, password);
            
            if (isAuthenticated) {
                System.out.println("Authentication successful.");
            } else {
                System.out.println("Authentication failed.");
            }
        } catch (AuthenticationException e) {
            System.out.println("AuthenticationException: " + e.getMessage());
        } finally {
            // Close authentication resources in the finally block
            closeAuthenticationResources();
        }
    }
    private static String readPasswordSecurely() {
        
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    private static boolean authenticateUser(String username, String password) throws AuthenticationException {
        // Simulated authentication logic (replace with actual authentication logic)
        if ("user123".equals(username) && "password123".equals(password)) { // The condition to access the account 
            return true;                                                   //  For simplicity, we will use plain text;
        } else {
            throw new AuthenticationException("Invalid username or password.");
        }
    }
    private static void closeAuthenticationResources() {
        // Close and clean up authentication resources:
        System.out.println("Closing authentication resources...");
    }
}
