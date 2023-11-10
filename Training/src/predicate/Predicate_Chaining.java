package predicate;

//Java program to illustrate Simple Predicate 
/*
 * https://www.geeksforgeeks.org/java-8-predicate-with-examples/
 */

import java.util.function.Predicate;

public class Predicate_Chaining {

	public static void main(String[] args) {

		// Creating predicate
		Predicate<Integer> lesserThan = i -> (i < 18);
		System.out.println(lesserThan.test(19)); // Calling Predicate method 'test', it shows 'false'

		
		//------------------- Predicate Chaining ---------------------
       // Creating predicates:
		Predicate<Integer> greaterThanTen = (i) -> i > 10;
		Predicate<Integer> lowerThanTwenty = (i) -> i < 20;
		
		// method 'and' composes an additional condition for the filter method 'test'
		boolean result1 = greaterThanTen.and(lowerThanTwenty).test(15); 
		System.out.println(result1);  //  it shows 'true'

		// method 'negate' is showing the opposite result
		boolean result2 = greaterThanTen.and(lowerThanTwenty).negate().test(15);
		System.out.println(result2); // therefore, it shows 'false'

		
		//---------------- Calling the method below -------------------
		pred (10, (i) -> i > 7); // it prints out the result if it is 'true'

	}

	// Java program to illustrate passing Predicate into function

	static void pred (int number, Predicate<Integer> predicate) {
		if (predicate.test(number)) {
			System.out.println("Number " + number);
		}
	}
}