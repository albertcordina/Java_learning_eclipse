package streams;

import java.util.List;

public class StreamFilter {

	public static void main(String[] args) {

		var list = List.of(3, 4, 6, 12, 30);
	//	List<Integer> list = List.of(3, 4, 6, 12, 30);  // <--- longer version
		 
		list
		.stream()
		.filter(n -> n % 5 == 0) // 'filter' takes the certain elements from the List without removing them 
		.forEach(System.out :: println ); // printing out the filtered elements of the List
		
		System.out.println(); // the separation between the all original and filtered elements
		list.forEach(System.out :: println); // printing out the whole original List
		
		list
		.stream()
		.filter(n -> n % 2 == 0)
		.forEach(System.out :: println ); // printing out the filtered elements of the List
		
		System.out.println(); // the separation between the all original and filtered elements
		list.forEach(System.out :: println); // printing out the whole original List
		
	}
}
