import java.util.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu_Template {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:\n1. Option 1\n2. Option 2\n3. Option 3\n0. Exit");

            try {
                System.out.print("Enter your choice: ");
                
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("option1");
                        break;
                    case 2:
                        System.out.println("option2");
                        break;
                    case 3:
                        System.out.println("option3");
                        break;
                    case 0:
                        System.out.println("Exiting the menu. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            } catch (InputMismatchException e) {
                // Handle the exception when the user enters a non-integer value
                System.out.println("Invalid input. Please enter a valid option.");
                // Clear the scanner buffer
                scanner.next();
                // Set choice to a value that will loop again
                choice = -1;
            }
        } while (choice != 0);
        scanner.close();
    }
}
