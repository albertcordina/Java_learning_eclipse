package lambda_expressions;
import java.util.*;

import java.util.function.Consumer;

public class LambdaExpressions_rules {
/*
 * Lambda functions are efficient whenever you want to create a function that will only contain simple expressions – 
 * that is, expressions that are usually a single line of a statement.
 * 
 * A lambda expression is a short block of code which takes in parameters and returns a value. 
 * Lambda expressions are similar to methods, but they do not need a name and they can be implemented right in the body of a method.
 * 
 * Lambda expressions can be stored in variables if the variable's type is an interface which has only one method. 
 *  The lambda expression should have the same number of parameters and the same return type as that method.
 *  Java has many of these kinds of interfaces built in, such as the Consumer interface (found in the java.util package) used by lists.
 */
	public static void main(String[] args) {

	    ArrayList<Integer> numbers1 = new ArrayList<Integer>();
	    numbers1.add(5);
	    numbers1.add(9);
	    numbers1.add(8);
	    numbers1.add(1);
	    numbers1.forEach( (n1) -> { System.out.println(n1); } ); // https://www.baeldung.com/foreach-java
	    numbers1.forEach((n) -> {System.out.println(n);} );
	    
	    // Use Java's Consumer interface to store a lambda expression in a variable,i.e. (java.util.function.Consumer;) :
	    ArrayList <Integer> numbers2 = new ArrayList <Integer>();
	    numbers2.add(5);
	    numbers2.add(9);
	    numbers2.add(8);
	    numbers2.add(1);
	    Consumer <Integer> method = (n2) -> { System.out.println(n2); };
	    numbers2.forEach( method ); // 'forEach' method performs the given action for each element of the Iterable 
	                               //     until all elements have been processed or the action throws an exception. 
	    // To use a lambda expression in a method - 
	   //  the method should have a parameter with a single-method interface as its type (see below). 
	  //   Calling the interface's method will run the lambda expression.
	 //    Create a method which takes a lambda expression as a parameter:
	        
	    Entering exclaim = (a) -> a + "!";
	    Entering ask = (a) -> a + "?";
	    printFormatted("Hello", exclaim); // calling the method 'printFormatted' with the assigned values: 'Hello' and 'exclaim'
	    printFormatted("Hello", ask);
	  }
	  public static void printFormatted (String str, Entering temp) { // 'format' is access to the 'Entering' interface 
	    String result = temp.run(str); // putting into one String the  'StringFunction' interface
	    System.out.println(result);
	    
	  }
	}
interface Entering { String run(String str);}





