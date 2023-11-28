

import java.util.Scanner;

public class Number_Of_Attempts_Scanner {

    public static void main(String[] args) {
        playNumberGuessingGame();
    }

    public static void playNumberGuessingGame() {
        Scanner scanner = new Scanner(System.in);

        int correctNumber = generateRandomNumber();
        int attempts = 3;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You have 3 attempts to guess the correct number.");

        while (attempts > 0) {
            System.out.print("Enter your guess: ");

            // Check if the input is a valid integer
            if (scanner.hasNextInt()) {
                int userGuess = scanner.nextInt();

                // Check if the guess is correct
                if (userGuess == correctNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    return;
                } else {
                    System.out.println("Incorrect guess. Try again.");
                    attempts--;
                    System.out.println("Attempts left: " + attempts);
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Consume the invalid input to avoid an infinite loop
            }
        }

        System.out.println("Sorry, you've run out of attempts. The correct number was: " + correctNumber);
    }

    public static int generateRandomNumber() {
        // This method generates a random number for the user to guess
        return (int) (Math.random() * 100) + 1; // Change the range as needed
    }
}
