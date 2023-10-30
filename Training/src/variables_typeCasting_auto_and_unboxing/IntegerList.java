package variables_typeCasting_auto_and_unboxing;

import java.util.*;
public class IntegerList {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		
		int a = 10;
		int b = 5;
		
		// autoboxing:
		Integer a1 = a; // converting the value of int to Integer 
		Integer b1 = b;
		
		list.add(a1);
		list.add(b1);
		
		// unboxing;
		int a2 = a1; // converting the value of Integer to int
		int b2 = b1;
		
		list.add(a2);
		list.add(b2);
		
		int sum1 = list.get(0) + list.get(1);
		int sum2 = list.get(2) + list.get(3);
		
		System.out.println("The sum of the " + a1 + " and " + b1 + " = " + sum1); // print out the Integer variation
		System.out.println("The sum of the " + a2 + " and " + b2 + " = " + sum2); // print out the int variation, they have the same value
		
	}
}
