package taking_Scanner;

import java.util.Scanner;

public class Taking_Password_Creating_Scanner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);

        String password = getValidPassword(scanner); // call the method and save the result in the String
        System.out.println("You created a valid password: " + password);
    }
    /*
     * Takes the password from the Applicant corresponding to the requirements (i.e.
     * at least 12 characters long and has the combination of at least one uppercase
     * letter, lowercase letter, number, and a symbol.
     */
    public static String getValidPassword(Scanner scanner) { // Repeatedly prompts the user until a valid password is entered.

        while (true) {
            System.out.println(
                    "Create a password with at least 12 characters, including:\n- At least one uppercase letter"
                            + "\n- At least one lowercase letter\n- At least one number\n- At least one symbol");

            System.out.print("Enter your password: ");
            // the password input logic to use scanner.next() instead of scanner.nextLine(): i.e.
            // to ensure that the newline character does not interfere with subsequent inputs.
            try {
                String userPassword = scanner.next();
                if (isValidPassword(userPassword)) {
                    return userPassword;
                } else {
                    System.out.println("Invalid password. Please try again.\n");
                }
            } catch (Exception e) {
                System.out.println("An error occurred. Please try again.");
            } finally {
                scanner.nextLine(); // Clear the buffer
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
            if (Character.isUpperCase(ch)) {          // Check if the password contains an UpperCase
                hasUppercase = true;
            } else if (Character.isLowerCase(ch)) { //   Check if the password contains a LowerCase
                hasLowercase = true;
            } else if (Character.isDigit(ch)) {   //     Check if the password contains a Digit
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
