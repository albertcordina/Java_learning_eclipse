package string_methods_manipulations;

public class String_methods {

	public static void main(String[] args) {

// Creating Strings:
		String str1 = "Hello";
		String str2 = new String("World");

// Concatenating Strings:
		String result = str1.concat(" ").concat(str2); // "Hello World"		
		//String result = str1 + " " + str2; // or using the + operator

// Getting Length:
		int length = result.length();

// Getting Substrings:
		String substring = result.substring(6); // " World"
		String subRange = result.substring(0, 5); // "Hello"

// Converting to Uppercase/Lowercase:		
		String upper = result.toUpperCase(); // "HELLO WORLD"
		String lower = result.toLowerCase(); // "hello world"

// Checking for Equality:
		boolean isEqual = str1.equals(str2); // false
		boolean isEqualIgnoreCase = str1.equalsIgnoreCase("hello"); // true

// Checking for Presence:
		boolean contains = result.contains("lo"); // true
		boolean startsWith = result.startsWith("Hello"); // true
		boolean endsWith = result.endsWith("ld"); // true

// Finding Index of a Character or Substring:
		int indexOfW = result.indexOf("W"); // 6
		int lastIndexOfl = result.lastIndexOf("l"); // 9

// Replacing Characters:
		String replaced = result.replace('o', 'X'); // "HellX WXrld"

// Trimming Whitespaces:
		String withSpaces = "   Trim me   ";
		String trimmed = withSpaces.trim(); // "Trim me"

// Converting to Character Array:
		char[] charArray = result.toCharArray();

// Splitting Strings:
		String sentence = "This is a sample sentence";
		String[] words = sentence.split(" "); // {"This", "is", "a", "sample", "sentence"}

/*
 * 	These are just a few examples, and the String class provides many more methods for string manipulation. 
 *    Understanding these methods can be quite useful when working with strings in Java.
 */

//------------------------ Reversing String ----------------------------------------	
		
		// Call the reverseString method to reverse the input string
        String reversedString = reverseString("love");
        System.out.println(reversedString); // prints out: 'evol'
		
	}
    
    private static String reverseString (String input) { // Method to reverse a given string
        // Convert the string to a character array
        char[] charArray = input.toCharArray();

        // Reverse the character array
        for (int i = 0, j = charArray.length - 1; i < j; i++, j--) {
            // Swap characters at positions i and j
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }

        // Convert the character array back to a string
        return new String(charArray);
    }
}
