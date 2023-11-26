package streams_miscellaneous;

import java.util.List;
import java.util.stream.Collectors;

class Book2 { 
	
	private String title;
	private String author;
	private int publicationYear;

	public Book2 (String title, String author, int publicationYear) {
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	@Override
	public String toString() {
		return "Book: " + "title='" + title + '\'' + ", author='" + author + '\'' + ", publicationYear="
				+ publicationYear;
	}
}

public class StreamFilteringExercise {
	
	public static List<Book2> filterAndCollect (List<Book2> books, int minPublicationYear) {
		
       // Filter out books published before the specified year and collect the remaining books
		return books.stream().filter(book -> book.getPublicationYear() >= minPublicationYear)
				.collect(Collectors.toList());
	}

	public static void main(String[] args) {
		
        // Create a list of books with various titles, authors, and publication years
		List<Book2> books = List.of (new Book2("Java Basics", "John Doe", 2010),
				new Book2("Python Programming", "Jane Smith", 2015),
				new Book2("Data Structures in C++", "Bob Johnson", 2008),
				new Book2("Web Development", "Alice Brown", 2021),
				new Book2("Algorithms and Complexity", "Charlie Green", 2012));
		
        // Call the filterAndCollect method to filter and collect books published after 2010
		List<Book2> filteredBooks = filterAndCollect(books, 2010);
		
        // Print the original list of books
		System.out.println("Original List of Books:");
		books.forEach(System.out::println);
		
        // Print the filtered list of books published after 2010
		System.out.println("Filtered List of Books (Published after 2010):");
		filteredBooks.forEach(System.out::println);
	}
}
