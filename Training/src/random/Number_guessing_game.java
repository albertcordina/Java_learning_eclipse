package random;


import java.util.Random;
import java.util.Scanner;

public class Number_guessing_game {

	public static void main(String[] args) {
		Random random = new Random();
		
		int x = random.nextInt (101);
		System.out.println(x);

		System.out.print("Please, enter your number between '1' and '100' (included): ");
		Scanner scanner = new Scanner (System.in);
		
		int y = scanner.nextInt();
		
		if (x == y) { System.out.println("That is the number!");}
		
			if (x != y) {
				while (x != y) {
					System.out.print("Please, try again: ");
					y = scanner.nextInt();
					
					if (x == y) { System.out.println("That is the number!");
						
					}
				}
			}
			scanner.close();
		}
}

/*
 * 
 * Exercise: Number Guessing Game Objective: The objective of this exercise is
 * to create a simple number guessing game using the Random class in Java. You
 * will implement a program that generates a random number and allows the user
 * to guess it.
 * 
 * Instructions: You are required to implement a Java program that accomplishes
 * the following tasks:
 * 
 * Generate a random number between 1 and 100 (inclusive). Prompt the user to
 * guess the number. Compare the user's guess with the generated number and
 * provide feedback. Allow the user to keep guessing until they guess the
 * correct number.
 * 
 */