package predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate; // 'function' package is for the Interfaces which contain the only one method

/*
 * Predicate is a shorter way of 'if' and 'else' function
 * It has the only one method 'test' and returns a boolean
 * 
 */
public class Predicate_rules {

	public static void main(String[] args) {

		Predicate <String> p1 = new Predicate <> () { // 'p1' is the name of the instance of unknownymous class

			@Override
			public boolean test(String t) {
				return t.length() < 5; // we set the lenght of the String (as an example)
			}	
		};
		System.out.println(p1.test("apple")); // print out 'false'
		System.out.println(p1.test("pear")); // print out 'true'
		
//------------------------------------- shorter way -----------------------------------------		
		
		Predicate <String> p2 = s -> s.length() < 5; // use 'lambda expression' instead of anonymous class

		System.out.println(p2.test("apple")); // print out 'false'
		System.out.println(p2.test("pear")); //  print out 'true'
		
		
//----------------------------------- List of integers --------------------------------------
		/*
		 * In this example, we create a Predicate for even numbers (isEven) and another for 
		 * numbers greater than 5 (isGreaterThan5). We then use these predicates to filter 
		 * and print elements from a list of integers.
		 * 
		 */
		
        List <Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Example 1: Using Predicate to filter even numbers
        System.out.println("Even numbers:");
        Predicate <Integer> even = number -> number % 2 == 0;
        filterAndPrint(numbers, even); // prints out: "Even numbers: 2 4 6 8 10".

        // Example 2: Using Predicate to filter numbers greater than 5
        System.out.println("Numbers greater than 5:");
        Predicate <Integer> greaterThan5 = number -> number > 5;
        filterAndPrint(numbers, greaterThan5); // prints out: "Numbers greater than 5: 6 7 8 9 10".
        
	}
	
	/*
	 *  Helper method to filter and print elements based on a Predicate:
	 * 
	 * The 'filterAndPrint' method takes a list of integers and a Predicate, 
	 * applies the predicate to each element, and prints the elements that satisfy the predicate. 
	 * This demonstrates how you can use Predicate to encapsulate a condition
	 *  and easily apply it to different sets of data.
	 * 
	 */
    private static void filterAndPrint (List <Integer> numbers, Predicate <Integer> predicate) {
        for (Integer number : numbers) {
            if (predicate.test(number)) { System.out.print(number + " ");}
        }
        System.out.println(); // Empty line for better looking output
    }
}

