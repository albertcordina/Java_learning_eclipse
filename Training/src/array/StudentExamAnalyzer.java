package array;
public class StudentExamAnalyzer {

	public static double calculateAverage(int[] score) {

		double help = 0;
		for (int i : score) { help += i;}
		return help / score.length;
	}
//--------------------------------------------------------
	public static int findHighestScore(int[] score) {

		int help = score[0];
		for (int i : score) { if (i > help) { help = i;}
		}
		return help;
	}
//---------------------------------------------------------
	public static int countAboveAverage(int[] score, double average) {
		
		int help = 0;
		for (int i : score) { if (i > average) { help++;}
		}
		return help;
	}
//---------------------------------------------------------
	public static double calculatePercentage(double aboveAverage, double totalStudents) {
		return ((double) aboveAverage / totalStudents) * 100; }
//----------------------------------------------------------------------------------------
	
	public static void main(String[] args) {
		int[] score = { 2, 3, 4, 5, 6, 80, 7, 8,25 };

		double average = calculateAverage(score);
		System.out.println("The average score is: " + average);

		int highest = findHighestScore(score);
		System.out.println("The highest score is: " + highest);

		double aboveAverage = countAboveAverage(score, average);
		System.out.println("The number of students above average scores: " + aboveAverage);

		double aboveAveragePercentage = calculatePercentage(aboveAverage, score.length);
		System.out.println("Percentage of students above average: " + aboveAveragePercentage);
	}
}

/*
 * 
 * Objective: The objective of this assignment is to practice working with
 * one-dimensional arrays in Java. You will create a program that analyses
 * student exam scores, calculates basic statistics, and provides insights into
 * the data.
 * 
 * Instructions: You are given an array of student exam scores (integers) for a
 * particular subject. Your task is to implement a Java program that performs
 * the following tasks:
 * 
 * Calculate the average score of all students. Find and display the highest
 * score achieved by any student. Count and display the number of students who
 * scored above the average score. Calculate and display the percentage of
 * students who scored above the average. Guidelines: Create a Java class named
 * StudentExamAnalyzer. Inside the class, define a method calculateAverage that
 * calculates the average score of the students. Define a method
 * findHighestScore that finds and returns the highest score in the array.
 * Implement a method countAboveAverage that counts the number of students who
 * scored above the average. Create a method calculatePercentage that calculates
 * the percentage of students who scored above the average. In the main method,
 * create an array with sample student exam scores. Call the methods you've
 * implemented to calculate the required statistics and display the results.
 * 
 */
