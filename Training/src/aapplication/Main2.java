package aapplication;
/*
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApplicationSystem appSystem = new ApplicationSystem();

        while (true) {
            System.out.println("Main Menu:");
            System.out.println("1. Start the application");
            System.out.println("2. Visit your personal profile");
            System.out.println("3. Exit the program");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    appSystem.startApplication(scanner);
                    break;
                case 2:
                    appSystem.visitProfile(scanner);
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}

class ApplicationSystem {
    private Map<String, ApplicantProfile> profiles = new HashMap<>();

    public void startApplication(Scanner scanner) {
        // Implementation for starting the application
        // Collect applicant's information, determine their status, create profile, etc.
    }

    public void visitProfile(Scanner scanner) {
        // Implementation for visiting the applicant's profile
        // Prompt for phone number and password, authenticate, and provide profile options
    }
}

class Application2 {
    protected String name;
    protected String surname;
    protected int age;
    protected String phoneNumber;
    protected String password;
    protected String status;

    // Constructors, getters, and setters for the above attributes

    public void amendProfile(Scanner scanner) {
        // Implementation for amending the applicant's profile
    }

    public void deleteProfile() {
        // Implementation for deleting the applicant's profile
    }

    // Other methods as needed
}

class Student extends Application2 {
    // Implementation for handling student-specific logic
}

class Employed extends Application2 {
    // Implementation for handling employed-specific logic
}

class Unemployed extends Application2 {
    // Implementation for handling unemployed-specific logic
}

class Retired extends Application2 {
    // Implementation for handling retired-specific logic
}

class Registered extends Application2 {
    // Implementation for handling registered applicant-specific logic
} */
