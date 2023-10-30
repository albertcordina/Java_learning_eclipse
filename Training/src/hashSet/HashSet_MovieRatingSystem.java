package hashSet;
import java.util.*;
public class HashSet_MovieRatingSystem {
 
	public static void main(String[] args) {
        byte exit;
		Scanner scanner = new Scanner (System.in);
		HashSet<String> Titles = new HashSet<>();
		
		do {
		
		System.out.print("Enter the name of the movie: ");
		String movieTitle = scanner.nextLine();
		movieTitle = scanner.nextLine();
	    Titles.add(movieTitle);
		
		
		System.out.print("\nEnter the rating of the movie: ");
		double rating = scanner.nextDouble();
		
		System.out.println("\nThank you\nYour rating of the movie is: " + rating); 
		System.out.println("\nSee also the whole list of the names of the movies: \n");
		for (String x: Titles) {System.out.println(x);}
		
		System.out.print("\nPress '0' if you would like to end the session ");
		exit = scanner.nextByte();
		}	
		while (exit != 0);
		scanner.close();
	}
}