package fileoutputstream;
import java.io.*;
import java.io.IOException;
import java.util.*;
import java.util.ArrayList;

class Book {
    String title;
    String author;
    String ISBN;
    boolean isAvailable;

    public Book(String title, String author, String ISBN, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isAvailable = isAvailable;
    }
}

//------------------------------------------------------------------------------------------
class Library {

    ArrayList<Book> books = new ArrayList(); // ArrayList of Books;

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) { // Adds a book to the library's collection.

        books.add(book);
    }

    public void checkoutBook(Book book, LibraryMember member) { // Marks a book as checked out by a library member.

        if (book.isAvailable) {
            book.isAvailable = false;
            System.out.println(member.name + " checked out " + book.title);
        } else {
            System.out.println(book.title + " is unavailable.");
        }
    }

    public void returnBook(Book book) { // Marks a book as returned and available for checkout.

        if (!book.isAvailable) {
            book.isAvailable = true;
            System.out.println(book.title + " has been returned.");
        }
    }

    public void displayAvailableBooks() { // Displays a list of available books in the library.

        for (Book book : books) {
            if (book.isAvailable) {
                System.out.println(book.title + "/ written by the author: " + book.author);
            }
        }
    }
}

//------------------------------------------------------------------------------------------------
class Person {

    String name;
    String contactInfo;

    public Person(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }
}

class LibraryMember extends Person {

    int memberID;

    public LibraryMember(String name, String contactInfo, int memberID) {
        super(name, contactInfo);
        this.memberID = memberID;
    }
}
//------------------------------------------------------------------------------------------------------------------------------------

public class FileOutPutStream_library {
    public static void main(String[] args) {

        Library library = new Library();

        Scanner scan = new Scanner(System.in);

        String option;
        do {
            System.out.print("\n\n- the Menu -\n\nPress '1' to add a book\n" + "Press '2' to check out a book\nPress '3' to return a book\nPress '4' " +
                    "to see the list of the available books\nPress '5' to exit the program\nEnter your option: ");
            option = scan.nextLine();

            switch (option) {

                case "1":
                    System.out.print("\nEnter the title of the book: ");
                    String title = scan.nextLine();
                    title = scan.nextLine();

                    System.out.print("Enter the name of the author: ");
                    String author = scan.nextLine();

                    System.out.print("Enter the ISBN of the book: ");
                    String ISBN = scan.nextLine();

                    library.addBook(new Book(title, author, ISBN, true));
                    break;

                case "2":
                    System.out.print("Enter the title of the book to check out: ");
                    String checkoutTitle = scan.nextLine();
                    checkoutTitle = scan.nextLine();

                    for (Book book : library.getBooks()) {
                        if (book.title.equals(checkoutTitle)) {
                            library.checkoutBook(book, new LibraryMember("John", "jhon@mail.com", 12345));
                        }
                    }
                    break;
                case "3":
                    System.out.print("Enter the title of the book to return: ");
                    String returnTitle = scan.nextLine();
                    returnTitle = scan.nextLine();

                    for (Book book : library.getBooks()) {
                        if (book.title.equals(returnTitle)) {
                            library.returnBook(book);
                        }
                    }
                    break;

                case "4":
                    System.out.println("The available book(s): ");
                    library.displayAvailableBooks();
                    break;

                case "5":
                    try {
                        saveBookData(library); // call the method ;
                        System.out.println("The current list of the available books has been successfully written to the file");
                    }  // report: successful written info;
                    catch (IOException e) {
                        System.err.println("An error occurred while writing to the file: " + e.getMessage());
                    } // if not successful written info;

                    System.out.println("Thank you for your session!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (!option.equals("5"));

        scan.close();
    }

    private static void saveBookData(Library library) throws IOException {


        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream("//home//dci-student//Desktop//NIOFiles//bookCollection.txt");

            for (Book books : library.books) {                 // iterate the whole ArrayList;
              //  String theLine = String.join("the title: ", books.title, books.author, books.ISBN) + "\n";  // join the 'comma' and the next line '\n' to the new String 'theLine';
                String theLine = String.join("," +  books.title +  books.author + books.ISBN) + "\n";  // join the 'comma' and the next line '\n' to the new String 'theLine';

                byte[] lineBytes = theLine.getBytes();    // convert the whole updated text/list of the 'theLine' to bytes 'lineBytes';
                fileOutputStream.write(lineBytes);       // write the converted 'lineBytes' into the file;
            }
        } finally {
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }
}