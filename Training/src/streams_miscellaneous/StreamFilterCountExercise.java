package streams_miscellaneous;

import java.util.List;
import java.util.function.Predicate;

class Book {
	
	private String title;
	private int year;

	public Book(String title, int year) {
		this.title = title;
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}

	@Override
	public String toString() {
		return "Book: " + "title='" + title + '\'' + ", year=" + year + '}';
	}
}

//-----------------------------------------------------
public class StreamFilterCountExercise {
	
	public static long filterAndCount(List<Book> books, Predicate<Book> filterCondition) {
		
       // Filter books based on the specified Predicate and count the number of books
		return books.stream().filter(filterCondition).count();
	}

	public static void main(String[] args) {
		
        // Create a list of books with various titles and publication years
		List<Book> books = List.of(new Book("Java Programming", 1998), new Book("Python Basics", 2005),
				new Book("Data Science Essentials", 2012), new Book("Web Development with JavaScript", 2018),
				new Book("Mystery Novel", 1995), new Book("Fantasy Adventure", 2008));
		
        // Define a Predicate to filter out books published before the year 2000
		int filterYear = 2000;
		Predicate<Book> publicationYearPredicate = book -> book.getYear() >= filterYear;
		
        // Call the filterAndCount method to filter and count books
		long countOfFilteredBooks = filterAndCount(books, publicationYearPredicate);
		
        // Print out the original list of books
		System.out.println("Original List of Books:");
		books.forEach(System.out::println);
		
        // Print out the count of books that meet the filtering condition
		System.out.println("Count of Books Published in or after year " + filterYear + ": " + countOfFilteredBooks);
	}
}
