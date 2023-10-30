package random;


import java.util.Random;
import java.util.Scanner;

public class Random_Multiplication_quiz {

	public static void main(String[] args) {
		
		Random random1 = new Random();
		int num1 = random1.nextInt(101);
		
		Random random2 = new Random();
		int num2 = random2.nextInt(101);
		
		int result = num1 * num2; 
		
		Scanner scanner = new Scanner (System.in);
		System.out.print("Welcome to our multiplication quiz!\n\nYou need to calculate the multiplication of the " + num1 + " and the " + num2 + 
				"\nPlease, enter your result here: ");
		int response = scanner.nextInt();
		
		String outcome = (response == result) ? "\nIt is correct!" : "\nIt is not correct";
		System.out.println(outcome);

		scanner.close();
		
	}

}

/*

Exercise: Multiplication Quiz
Objective:
The objective of this exercise is to create a simple multiplication quiz using basic Java concepts. 
You will implement a program that quizzes the user on multiplication questions.

Instructions:
You are required to implement a Java program that accomplishes the following tasks:

Generate two random numbers between 1 and 10 (inclusive) as operands for a multiplication question.
Ask the user to solve the multiplication question.
Compare the user's answer with the correct answer and provide feedback.

*/