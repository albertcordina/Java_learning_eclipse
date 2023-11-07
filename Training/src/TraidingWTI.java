import java.util.*;

public class TraidingWTI {

	/*
	 * West Texas Intermediate (WTI), also known as Texas light sweet, is a type of
	 * crude oil used as a benchmark in oil pricing.
	 * 
	 * It is sourced from the United States, primarily in Texas, Louisiana, and
	 * North Dakota. https://en.wikipedia.org/wiki/West_Texas_Intermediate
	 */

	private static int course;
	private static int leverage;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

//-------------------the calculation of the cost to keep the positions -------------
		do {
			try {
				System.out.print("\nEnter the actual course,\n(i.e. the rounded price\nfor 1 Barrel in Dollars): ");
				course = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				System.out.print("Enter a positive number, not a character.");
				scan.nextLine();
			}
		} while (course <= 1);

		int costToKeepPositionsUnder = course * (course + 1) / 2;
		int differencePositionsAbove = 150 - course;
		int costToKeepPositionsAbove = differencePositionsAbove * (differencePositionsAbove + 1) / 2;

		if (course > 90) {
			System.out.println(
					"The cost of keeping the " + differencePositionsAbove + " positions = " + costToKeepPositionsAbove);
		} else {
			System.out.println("The cost of keeping the " + course + " positions = " + costToKeepPositionsUnder);
		}

//---------------------- the calculation of the cost of the positions -----------------		
		do {
			try {
				System.out.print("\nEnter the implemented leverage to the price: ");
				leverage = scan.nextInt();

			} catch (Exception e) {
				System.out.print("Enter a positive number, not a character.");
				scan.nextLine();
			}
		} while (leverage <= 1);

		int costOfPositionsUnder = costToKeepPositionsUnder / leverage;
		int costOfPositionsAbove = ((150 * (150 + 1) / 2) - costToKeepPositionsUnder) / leverage;

		int costTotalUnder = costToKeepPositionsUnder + costOfPositionsUnder;
		int costTotalAbove = costToKeepPositionsAbove + costOfPositionsAbove;
		
//------------------------------------ the final report -----------------------------------
		if (course > 90) {
			System.out.println("The cost of the " + differencePositionsAbove
					+ " positions with the implementation of the leverage = " + costOfPositionsAbove);
			System.out.println("Therefore, the total cost of the positions and to keep them is: " + costTotalAbove);
		} else {
			System.out.println("The cost of the " + course + " positions with the implementation of the leverage = "
					+ costOfPositionsUnder);
			System.out.println("Therefore, the total cost of the positions and to keep them is: " + costTotalUnder);
		}

	}

}
