package streams_miscellaneous;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream_parallel_FilteringForLenghtWords {
	
    public static void main(String[] args) {
    	
        // Create a list of words
        List <String> words = Arrays.asList("apple", "banana", "orange", "grapes", "kiwi","mango", "avocado", "pineapple");
        
        // Filter and collect words concurrently using parallel stream
        List <String> collectedWords = filterAndCollectConcurrently(words, 5);
        
        // Print the original list of words, the filtered words, and the new list
        System.out.println("Original List of Words: " + words);
        System.out.println("Filtered Words: " + collectedWords);
    }
    // Parallel stream processing example for concurrent data filtering and collecting
    private static List <String> filterAndCollectConcurrently (List <String> words, int lengthThreshold) {
        // Use parallel stream processing to filter and collect data concurrently
        return words.parallelStream()
                .filter(word -> word.length() > lengthThreshold)
                .collect(Collectors.toList());
    }
}
