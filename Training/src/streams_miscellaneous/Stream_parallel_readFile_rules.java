package streams_miscellaneous;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream_parallel_readFile_rules {
	/*
	 * Sequential stream is executed in a single thread
	 * Parallel stream is executed by different threads at the same time
	 * 
	 * Different ways to create parallel stream:
	 *  1. Using the parallel() method on a stream
	 *  2. Using the parallelStream() method on Collecion (is faster)
	 *  */

	public static void main(String[] args) throws IOException {
		
		File file = new File ("text.txt"); // creating an object of the class 'File'
		
		Stream <String> text = Files.lines (file.toPath()); // 'lines' reads the text in lines
		
	// Parallel stream is much faster than Sequential stream, however, it reads the file not line by line
	//	text.parallel().forEach(System.out :: println); 
		
		// Sequential stream reads the file line by line
		//text.sequential().forEach(System.out :: println);
		// NOTE: there can be only one of them (they cannot be executed one after another) !
//-----------------------------------------------------------------------------------------------	
		
		// 'readAllLines' is even faster, however, not line by line
		List <String> texts = Files.readAllLines(file.toPath()); 
		
	//	texts.parallelStream().forEach(System.out :: println); // it uses the 'parallelStream'
	
		text.close(); // we need to close the List at the end of the code
		
//------------------------------ INTSTREAM -------------------------------------------------
		
		// IntStream Inerface builds the two inegers and range them, i.e. from to:
		IntStream ordered = IntStream.rangeClosed(1, 10);
		ordered.forEach(System.out :: println); // ordered
		
		IntStream unOrdered = IntStream.rangeClosed(1, 10);
		unOrdered.parallel().forEach(System.out :: println);// 'parallel' is unordered
		
		
		
		IntStream stream1 = IntStream.rangeClosed(1, 10);
		
		if (stream1.isParallel()) { // checking if the stream to be unordered, i.e 'parallel'
			System.out.println("Stream below is parallel, i.e. unordered:");
		} else {
			System.out.println("Strem below is not parallel, i.e. ordered:");
		}
		stream1.forEach(System.out :: println);
		
		
		IntStream stream2 = IntStream.rangeClosed(1, 10);
		IntStream stream2Parallel = stream2.parallel();
		
		if (stream2.isParallel()) {
			System.out.println("Stream below is parallel, i.e. unordered:");
		} else {
			System.out.println("Stream below is not parallel, i.e. ordered:");
		}
		stream2.forEach(System.out :: println);
	}
}
