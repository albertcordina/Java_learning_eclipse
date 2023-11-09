package predicate;

//Java program to illustrate Simple Predicate 
/*
 * https://www.geeksforgeeks.org/java-8-predicate-with-examples/
 */

import java.util.function.Predicate;

public class PredicateInterface {

	public static void main(String[] args) {

		// Creating predicate
		Predicate<Integer> lesserthan = i -> (i < 18);

		// Calling Predicate method
		System.out.println(lesserthan.test(19));

		// Java program to illustrate Predicate Chaining

		Predicate<Integer> greaterThanTen = (i) -> i > 10;

		// Creating predicate
		Predicate<Integer> lowerThanTwenty = (i) -> i < 20;
		boolean result = greaterThanTen.and(lowerThanTwenty).test(15);
		System.out.println(result);

		// Calling Predicate method
		boolean result2 = greaterThanTen.and(lowerThanTwenty).negate().test(15);
		System.out.println(result2);

		// Calling the method below
		pred (10, (i) -> i > 7);

	}

	// Java program to illustrate passing Predicate into function

	static void pred(int number, Predicate<Integer> predicate) {
		if (predicate.test(number)) {
			System.out.println("Number " + number);
		}
	}
}