package streams_miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class StreamFilter {

	public static void main(String[] args) {

		var list = List.of(3, 4, 6, 12, 30);
	//	List <Integer> list = List.of(3, 4, 6, 12, 30);  // <--- longer version
		 
		list
		.stream()
		.filter(n -> n % 5 == 0) // 'filter' takes the certain elements from the List without removing them 
		.forEach(System.out :: println ); // printing out the filtered elements of the List
		
		System.out.println(); // the separation between the all original and filtered elements
		list.forEach(System.out :: println); // printing out the whole original List
		
		
        ArrayList <String> li = new ArrayList <> (); 
		
		li.add("Love");
		li.add(" is");
		li.add(" the");
		li.add(" best!\n");
		
        li.forEach(System.out :: print);
        // filter and print out the word ' the'
        li.stream().filter(n -> n == " the").forEach(System.out :: println); 
		
	}
}
