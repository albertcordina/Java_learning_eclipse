package streams_miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class Stream_parallel_FilteringChallenge {

	private static List <Integer> sequentialFilterExample (List <Integer> numbers) {
		return numbers.stream().filter(n -> n % 2 != 0).toList();
	}

	private static List <Integer> parallelFilterExample (List <Integer> numbers) {
		return numbers.parallelStream().filter(n -> n % 2 != 0).toList();	}

	public static void main(String[] args) {
		// Create a list of integers (e.g., 1, 2, 3, 4, 5, ...)
		List <Integer> numbers = new ArrayList<>();
		for (int i = 1; i <= 500; i++) {
			numbers.add(i);
		}

		// Measure and print the execution time of the sequential solution
		long startTimeSequential = System.currentTimeMillis();
		long endTimeSequential = System.currentTimeMillis();

		List<Integer> sequentialResult = sequentialFilterExample(numbers);
		System.out.println("Sequential Execution Time: " + (endTimeSequential - startTimeSequential) + "ms");

		// Measure and print the execution time of the parallel solution
		long startTimeParallel = System.currentTimeMillis();
		long endTimeParallel = System.currentTimeMillis();

		List <Integer> parallelResult = parallelFilterExample(numbers);
		System.out.println("Parallel Execution Time: " + (endTimeParallel - startTimeParallel) + "ms");

		// Print out the filtered results
		System.out.println("Sequential Result: " + sequentialResult);
		System.out.println("Parallel Result: " + parallelResult);
	}
}
