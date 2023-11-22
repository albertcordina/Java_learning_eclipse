import java.util.Scanner;

public class StringReversalApp {

    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();

        // Call the reverseString method to reverse the input string
        String reversedString = reverseString(userInput);

        // Display the reversed string
        System.out.println("Reversed String: " + reversedString);

        // Close the Scanner to avoid resource leaks
        scanner.close();
    }

    // Method to reverse a given string
    private static String reverseString(String input) {
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

