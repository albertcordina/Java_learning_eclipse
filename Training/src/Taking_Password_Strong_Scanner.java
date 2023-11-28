
import java.util.Scanner;

public class Taking_Password_Strong_Scanner {

    public static void main(String[] args) {
    	
        String password = getValidPassword();
        System.out.println("You created a strong password: " + password);
        
    }

    
    public static String getValidPassword() { // Repeatedly prompts the user until a valid password is entered.
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Create a strong password with at least 18 characters, including:");
            System.out.println("- At least 5 uppercase letters");
            System.out.println("- At least 4 lowercase letters");
            System.out.println("- At least 3 numbers");
            System.out.println("- At least 2 symbols");

            System.out.print("Enter your password: ");
            String userPassword = scanner.nextLine();

            // Check if the password meets the criteria
            if (isValidPassword(userPassword)) {
                return userPassword;
            } else {
                System.out.println("Invalid password. Please try again.");
            }
        }
    }

    public static boolean isValidPassword(String password) { // Checks the validation of the entered password
    	
        // Check if the password is at least 18 characters long
        if (password.length() < 18) {
            return false;
        }

        // Check for the specified combination of uppercase letters, lowercase letters, numbers, and symbols
        int uppercaseCount = 0;
        int lowercaseCount = 0;
        int numberCount = 0;
        int symbolCount = 0;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                uppercaseCount++;
            } else if (Character.isLowerCase(ch)) {
                lowercaseCount++;
            } else if (Character.isDigit(ch)) {
                numberCount++;
            } else {
                // You can customize the symbols according to your requirements
                String symbols = "!@#$%^&*()-_+=<>?";
                if (symbols.indexOf(ch) != -1) {
                    symbolCount++;
                }
            }
        }

        // Return true if the specified combination is met
        return uppercaseCount >= 5 && lowercaseCount >= 4 && numberCount >= 3 && symbolCount >= 2;
    }
}
