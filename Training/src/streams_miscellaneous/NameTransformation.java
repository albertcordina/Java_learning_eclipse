package streams_miscellaneous;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// converting the List of the names 'toUpperCase' sequential and parallel
public class NameTransformation { 
	
	public static void main(String[] args) {
		
		// Create a list of names
		List <String> names = Arrays.asList("Alice", "Bob", "Charlie", "David",
				"Emma", "Frank", "Grace", "Hank", "Ivy", "Jack");
		
		// 'currentTimeMillis()' returns the current time in milliseconds.
		long sequentialStartTime = System.currentTimeMillis();
		long sequentialEndTime = System.currentTimeMillis();
		
		List <String> sequentialResult = sequentialStreamExample(names);
		
		// Measure and print the execution time of the sequential solution
		System.out.println("Sequential Stream Result: " + 6);
		System.out.println("Sequential Execution Time: " + (sequentialEndTime - sequentialStartTime) + " milliseconds");
		
		
		// Measure and print the execution time of the parallel solution
		long parallelStartTime = System.currentTimeMillis();
		long parallelEndTime = System.currentTimeMillis();
		
		List<String> parallelResult = parallelStreamExample(names);
		
		System.out.println("Parallel Stream Result: " + parallelResult);
		System.out.println("Parallel Execution Time: " + (parallelEndTime - parallelStartTime) + " milliseconds");
	}

	// Sequential stream
	private static List <String> sequentialStreamExample (List<String> names) {
		// Implement a sequential stream solution to transform each name to uppercase.
		// Use the 'stream()' and 'map()' methods to transform the stream and perform the task.
		return names.stream() 
				    .map(String::toUpperCase)
				    .collect(Collectors.toList());
	}

	// Parallel stream
	private static List <String> parallelStreamExample (List <String> names) {
		// Implement a parallel stream solution to achieve the same task as in the sequential example.
		// Utilize the 'parallelStream()' method to parallelize the stream processing.
		return names.parallelStream() // Convert the list 'names' into a parallel stream
				.map(String::toUpperCase) // Apply the 'toUpperCase' method to each element of the parallel stream
				.collect(Collectors.toList()); // Collect the transformed elements into a new list
	}
}
