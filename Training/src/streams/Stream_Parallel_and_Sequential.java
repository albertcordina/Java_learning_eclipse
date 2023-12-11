package streams;

import java.util.Arrays;

public class Stream_Parallel_and_Sequential {
/*
 * the parallel method is part of the Stream API and is used to convert a sequential stream into a parallel stream. 
 * Parallel streams allow for concurrent processing of elements, potentially leveraging multiple threads to speed up 
 * computations for tasks that can be performed in parallel.

      Here's a simple example to illustrate the use of the parallel method:
 */
	public static void main(String[] args) {

		// Create an array of integers
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Sequential stream processing
        System.out.println("Sequential Stream:");
        Arrays.stream(numbers).forEach(System.out::println);

        // Parallel stream processing
        System.out.println("\nParallel Stream:");
        Arrays.stream(numbers).parallel().forEach(System.out::println);
		
/*
 * In this example, we have an array of integers, and we use the Arrays.stream method to create a stream. 
 * The forEach method is used to print each element of the array. 
 * When we call the parallel method on the stream, it converts the stream into a parallel stream. 
 * This means that the elements of the stream can be processed concurrently by multiple threads. 
 * In the output, you might observe that the order of printed elements in the parallel stream 
 * is not guaranteed to be the same as the order in the array, as different threads may 
 * process different elements at the same time.

Note that not all operations benefit from parallel processing, and using parallel streams comes 
     its certain considerations, such as ensuring that the operations are thread-safe. 
     It's important to use parallel streams judiciously based on the nature of the 
     computation and the characteristics of the data being processed.		
 */		
	}
}
