package regular_expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular_expression_rules { // Manipulation with Strings, i.e. texts
/*
 * a regular expression (regex) is a pattern describing a certain amount of text. 
 * It is a powerful tool for pattern matching and manipulation of strings. 
 * Java provides the java.util.regex package, which contains the Pattern 
 * class for working with regular expressions.
 * 
 */
	public static void main(String[] args) {

// Creating a Pattern: You typically create a Pattern object using the 		
//                    compile method in the Pattern class. For example:
		
		/*Pattern pattern = Pattern.compile("ab+c");	
		System.out.println(pattern); /*
	/*
	 * This pattern represents the regular expression "ab+c", 
	 * which matches one or more occurrences of the character
	 *  'b' following the characters 'a'.
	 */
		
        String regex = "\\b(Java)\\b"; // Define a regular expression pattern     
        Pattern pattern = Pattern.compile(regex); // Compile the regular expression into a pattern
       
        String input = "Java programming is fun with Java!"; // Create a matcher for the input string
        Matcher matcher = pattern.matcher(input);

        // Find the first occurrence of the pattern in the input
        if (matcher.find()) { System.out.println("Found match: " + matcher.group(0));} 
        else { System.out.println("No match found.");}
        
        /*
         * In this example, we define a regular expression pattern that matches the word \"Java\" 
         * as a whole word (using \\b for word boundaries). We then compile this pattern using 
         * the compile method of the Pattern class. After that, we create a Matcher object by 
         * applying the pattern to an input string. Finally, we use the find method to search 
         * for the pattern in the input string and print the result.
         * 
         */
		
        
        
// Matcher: The Matcher class is used to match a Pattern against a given input string. 
//          You obtain a Matcher object by calling the matcher method on a Pattern:
		//Matcher matcher = pattern.matcher("abbbc");
		//System.out.println(matcher);
		
// Matching: You can use the matches method to check if the entire input string matches the pattern:
			
		boolean isMatch = matcher.matches();
		
// Find: The find method is used to find the next occurrence of the pattern in the input string:
				
		while (matcher.find()) { // This example prints the start and end indices of each occurrence of the pattern.
		    System.out.println("Found match at index " + matcher.start() + " to " + matcher.end());
		}
		
// Grouping: You can use parentheses to create capturing groups and extract parts of the matched text:
				
	/*	Pattern pattern2 = Pattern.compile("(\\d+)-(\\d+)");
		Matcher matcher2 = pattern2.matcher("123-456");

		if (matcher.matches()) {
		    String group1 = matcher2.group(1);  // "123"
		    String group2 = matcher2.group(2);  // "456"
		} */
		
	}
}
