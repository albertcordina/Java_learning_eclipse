
	import java.util.Scanner;

	public class Taking_Password_Access_Attempts_Scanner {
		
        static Scanner scanner = new Scanner(System.in);
	    static String password = "love";

	    public static void main(String[] args) {
	    	enterPassword(scanner);
	    	scanner.close();
	    }

	    public static void enterPassword(Scanner scanner) {
	        int maxAttempts = 3; // the set 3 attempts 
	      //  System.out.println("You have 3 attempts:");

	        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
	            System.out.print("Attempt " + attempt + ": Enter your password: ");
	            String userGuess = scanner.nextLine();

	            if (userGuess.equals(password)) {
	                System.out.println("Congratulations!");
	                return; // Exit the program if the guess is correct
	            } else {
	                System.out.println("Incorrect guess. Try again.");
	            }
	        }

	        System.out.println("Sorry, you've run out of attempts.");
	    }
	}


