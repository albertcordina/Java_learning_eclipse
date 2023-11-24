import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

	// 'private' is for incapsulation
	private static final String[] CHOICES = { "Rock", "Paper", "Scissors" }; // Array of the 3 choices
	private static final int ROUNDS_TO_PLAY = 3; // create the 3 rounds of play

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		int playerScore = 0;
		int computerScore = 0;

		System.out.println("Welcome to Rock, Paper, Scissors Game!");

		for (int round = 1; round <= ROUNDS_TO_PLAY; round++) {

			System.out.println("\nRound " + round + ":");
		
			String playerChoice = getPlayerChoice(scanner); // Player's choice
			
			String computerChoice = getRandomChoice(random); // Computer's choice
		
			String result = determineWinner(playerChoice, computerChoice); // Determine the winner

			// Output choices and result
			System.out.println("Player's choice: " + playerChoice + "\nComputer's choice: " + computerChoice);
			System.out.println("Result: " + result);

			// Update scores
			if (result.equals("Player wins!")) {
				playerScore++;
			} else if (result.equals("Computer wins!")) {
				computerScore++;
			}
		}

		// Display final scores
		System.out.println("\nGame Over!\nPlayer Score: " + playerScore + "\nComputer Score: " + computerScore);

		// Determine the overall winner
		if (playerScore > computerScore) {
			System.out.println("Player wins the game!");
		} else if (playerScore < computerScore) {
			System.out.println("Computer wins the game!");
		} else {
			System.out.println("It's a tie!");
		}

		scanner.close();
	}

	private static String getPlayerChoice(Scanner scanner) {
		System.out.print("Enter your choice (Rock, Paper, or Scissors): ");
		String playerChoice = scanner.nextLine().trim();

		while (!isValidChoice(playerChoice)) { // Validate the player's input
			System.out.println("Invalid choice. Please enter Rock, Paper, or Scissors.");
			System.out.print("Enter your choice: ");
			playerChoice = scanner.nextLine().trim(); // take the trimed input as a value
		}

		return playerChoice;
	}

	private static boolean isValidChoice(String choice) {
		for (String validChoice : CHOICES) {
			if (validChoice.equalsIgnoreCase(choice)) {
				return true;
			}
		}
		return false;
	}

	private static String getRandomChoice(Random random) {
		return CHOICES[random.nextInt(CHOICES.length)];
	}

	private static String determineWinner(String playerChoice, String computerChoice) {
		if (playerChoice.equalsIgnoreCase(computerChoice)) {
			return "It is a draw!";
		} else if ((playerChoice.equalsIgnoreCase("Rock") && computerChoice.equalsIgnoreCase("Scissors"))
				|| (playerChoice.equalsIgnoreCase("Scissors") && computerChoice.equalsIgnoreCase("Paper"))
				|| (playerChoice.equalsIgnoreCase("Paper") && computerChoice.equalsIgnoreCase("Rock"))) {
			return "Player wins!";
		} else {
			return "Computer wins!";
		}
	}
}