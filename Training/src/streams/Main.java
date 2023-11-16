package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		
		List <String> n = new ArrayList <> ();
		
		n.add("One");
		n.add("Two");
		n.add("Three");
		n.add("Four");

		//n.stream().forEach(System.out :: println);
		//n.forEach(System.out :: println); // it can be also without 'stream'	 
		//n.parallelStream().forEach(System.out :: println); // with 'parallelStream' it is faster
		
		IntStream ordered = IntStream.rangeClosed(1, 10);
		ordered.forEach(System.out :: println);
		
		IntStream unOrdered = IntStream.rangeClosed(1, 10);
		unOrdered.parallel().forEach(System.out :: println);
	}
}
