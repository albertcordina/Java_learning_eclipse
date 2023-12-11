package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;
/*
 *  The Stream API can be used with various data sources, including collections, arrays, 
 *  I/O channels, generators, and more. It's a powerful and flexible tool for processing 
 *    data in a functional programming style.
 */
public class Stream_Allothers_likeReadingFiles {

	public static void main(String[] args) {

// Collections: You can create a stream from various collection types like lists, sets, and maps.
				
		List <String> list = Arrays.asList("apple", "banana", "cherry");
		Stream <String> streamFromList = list.stream();
		streamFromList.filter(a -> a.length() > 5).map(String::toUpperCase).forEach(System.out::println);
			
		
// Arrays: You can create a stream from an array.
				
		String[] array = {"apple", "banana", "cherry"};
		Stream<String> streamFromArray = Arrays.stream(array);
		streamFromArray.filter(a -> a.length() > 5).map(String::toUpperCase).forEach(System.out::println);

		
		
// I/O Channels: You can create a stream from I/O channels, such as reading lines from a file. 
		
		try (Stream<String> lines = Files.lines(Paths.get("text.txt"))) { // Process lines from the file
			lines.forEach(System.out :: println);                        // printing it out
		} catch (IOException e) { e.printStackTrace();}
  /*
   *  reading the file (example: a file of the same project)	
	Files.lines(Paths.get("text.txt")).forEach(System.out :: println);
   * 		
   */

		
// Generators: You can create a stream using the Stream.generate method.
		
		// Generate an infinite stream of number '42'		
		Stream <Integer> infiniteStream = Stream.generate(() -> 42).limit(5);
		infiniteStream.forEach(System.out::println);
		
		// Generate an infinite stream of random numbers between 0 and 9
        Stream.generate(() -> (int) (Math.random() * 10))
              .limit(5)  // Limit the stream to 5 elements for demonstration
              .forEach(System.out::println);
		
		
// Range of values: You can create a stream of values within a specified range.
/*
 * An equivalent sequence of increasing values using a for loop as follows:
     for (int i = startInclusive; i < endExclusive ; i++) { ... }
 */
		IntStream range = IntStream.range(1, 5);   // only to the '4'
		range.forEach(System.out::println);
		
		IntStream ordered = IntStream.rangeClosed(1, 5); // including the last '5'
		ordered.forEach(System.out :: println);
		
		
// Regular Expressions: You can create a stream from a regular expression pattern.
				
		Pattern pattern = Pattern.compile(",");
		Stream<String> streamFromPattern = pattern.splitAsStream("apple,banana,cherry");

		

	}
}
