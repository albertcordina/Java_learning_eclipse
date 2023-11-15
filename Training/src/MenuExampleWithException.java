import java.util.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuExampleWithException {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Display menu options
            System.out.println("Menu:\n1. Option 1\n2. Option 2\n3. Option 3\n0. Exit");

            try {
                // Prompt user for choice
                System.out.print("Enter your choice: ");
                
                // Read user input
                choice = scanner.nextInt();

                // Process user choice
                switch (choice) {
                    case 1:
                        System.out.println("option1");
                        // Add code for Option 1
                        break;
                    case 2:
                        System.out.println("option2");
                        // Add code for Option 2
                        break;
                    case 3:
                        System.out.println("option3");
                        // Add code for Option 3
                        break;
                    case 0:
                        System.out.println("Exiting the menu. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            } catch (InputMismatchException e) {
                // Handle the exception when the user enters a non-integer value
                System.out.println("Invalid input. Please enter a valid integer.");
                // Clear the scanner buffer
                scanner.next();
                // Set choice to a value that will loop again
                choice = -1;
            }

        } while (choice != 0);

        // Close the scanner
        scanner.close();
    }
}
