import java.util.Scanner;

public class Number_Of_Attempts_Scanner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String target = "love";

        System.out.println("Please, enter the word. You have 3 attempts.");

        for (int attempt = 1; attempt <= 3; attempt++) {
            System.out.print("Enter your password: ");

            String userInput = scanner.nextLine().trim();

            if (userInput.equals(target)) {
                System.out.println("Thank you for the successful input!");
                return; // exit the method after successful input
            } else {
                System.out.println("Incorrect input. Attempts left: " + (3 - attempt));
            }
        }
        System.out.println("Sorry, you've run out of attempts.");
        scanner.close();
    }
}

