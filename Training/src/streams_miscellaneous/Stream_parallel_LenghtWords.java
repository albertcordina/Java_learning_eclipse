package streams_miscellaneous;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream_parallel_LenghtWords {
	
    public static void main(String[] args) {
    	
        // Create a list of words
        List <String> words = Arrays.asList("Java", "Stream", "Challenge", "Parallel", "Processing");
        
        // Parallel stream to calculate the lengths of strings
        List<Integer> lengths = parallelStringLengths(words);
        
        // Print the original list of words and their lengths
        System.out.println("Original List: " + words);
        System.out.println("Lengths: " + lengths);
    }
    // Parallel string lengths 
    private static List <Integer> parallelStringLengths (List <String> words) {
        // Use parallel stream to calculate the lengths of strings
        return words.parallelStream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
