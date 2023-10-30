package exceptions;

import java.util.Scanner;

public class Exception_Array_LibraryCatalog {
	private String[] bookTitles;

	public Exception_Array_LibraryCatalog() {
		// Initialize the bookTitles array with sample book titles.
		bookTitles = new String[] { "Book 1", "Book 2", "Book 3" };
	}

	public String searchBook(int index) {
//-------------------------  Exception ---------------------------------------------		
		// Check if the index is within the valid range of bookTitles:
		try {
			if (index >= 0 && index < bookTitles.length) {
				return bookTitles[index];
			}

			// only throwing 'Axception';
			else {
				throw new ArrayIndexOutOfBoundsException(
						"Invalid index. Please enter a valid index (0-" + (bookTitles.length - 1) + ").");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return "Error: " + e.getMessage();
		} // then, catching 'Axception';
	}

//----------------------------------------------------------------------------------
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Exception_Array_LibraryCatalog catalog = new Exception_Array_LibraryCatalog(); // 'new' operator is for creating
																						// object;

		System.out.println("Library Catalog System\n");

		System.out.println("Available Books:"); // Display available books;
		for (int i = 0; i < catalog.bookTitles.length; i++) {
			System.out.println((i + 1) + ". " + catalog.bookTitles[i]);
		}

		while (true) {
			System.out.print("\nEnter the index to search for a book (0-" + (catalog.bookTitles.length - 1) + "): ");
			int index = scanner.nextInt();

			String result = catalog.searchBook(index);
			System.out.println("\n" + (result.startsWith("Error") ? result : "Book at index " + index + ": " + result));

			// Check if the user wants to continue searching;
			System.out.print("Do you want to search for another book? (yes/no): ");
			String continueSearch = scanner.next();
			if (!continueSearch.equalsIgnoreCase("yes")) {
				System.out.println("Exiting the program.");
				break;
			}
		}
		scanner.close();
	}
}
