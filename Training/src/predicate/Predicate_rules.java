package predicate;

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
		System.out.println(p2.test("pear")); // print out 'true'
	}
}
