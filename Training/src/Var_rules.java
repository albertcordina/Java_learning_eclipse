import java.util.List;

import java.io.*;

public class Var_rules {

		/*
		 * The 'var' reserved type name (not a Java keyword) was introduced in Java 10. 
		 * Type inference is used in var keyword in which it detects automatically the 
		 * datatype of a variable based on the surrounding context, and it is mostly used 
		 * to declare a certain List with no possible manipulation with it (for shorter code).
		 * 
		 * 'var' must be always initialized (even if var is an instance, i.e. within a class).
		 * 'var' cannot be used for a method parameters and return type.
		 * 'var' cannot be used with Lambda Expression.
		 */
	
	public static void main(String[] args) {
        
		var case1 = 50;     // var can hold the numbers
		var case2 = "age = "; // var can hold the text
		
		System.out.println(case2 + case1);

        var colors = List.of("Red", "Blue", "Purple", "White", "Yellow", "Green", "Black");
        //colors.add("Orange");       // it does not work like with the ArrayList
        //colors.set(2, "Color");    //  it also does not work
        System.out.println(colors); // print out all the elements of the List
        
        // var cannot be used with Lambda since they require explicit target type
      //  var obj = (a, b) -> (a + b);
		
	}
}
