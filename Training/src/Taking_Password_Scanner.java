
import java.util.Scanner;

public class Taking_Password_Scanner {

    public static void main(String[] args) {
    	
        String password = getValidPassword();
        System.out.println("You created a valid password: " + password);
        
        
    }

    public static String getValidPassword() { // Repeatedly prompts the user until a valid password is entered.
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Create a password with at least 12 characters, including:\n- At least one uppercase letter"
            		+ "\n- At least one lowercase letter\n- At least one number\n- At least one symbol");

            System.out.print("Enter your password: ");
            String userPassword = scanner.nextLine();
           
            if (isValidPassword(userPassword)) { // Check if the password meets the criteria
                return userPassword;
            } else {
                System.out.println("Invalid password. Please try again.");
            }
        }
    }

    public static boolean isValidPassword(String password) { // Checks the validation of the entered password
    	
        // Check if the password is at least 12 characters long
        if (password.length() < 12) {
            return false;
        }

        // Check for at least one uppercase letter, lowercase letter, number, and symbol
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasNumber = false;
        boolean hasSymbol = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowercase = true;
            } else if (Character.isDigit(ch)) {
                hasNumber = true;
            } else {
                // You can customize the symbols according to your requirements
                String symbols = "!@#$%^&*()-_+=<>?";
                if (symbols.indexOf(ch) != -1) {
                    hasSymbol = true;
                }
            }
        }
        // Return true if all criteria are met
        return hasUppercase && hasLowercase && hasNumber && hasSymbol;
    }
}
