package streams_miscellaneous;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Streams_rules {
	
	/*
	 * Streams are a continues flow of data.
	 */

	public static void main(String[] args) {

		ArrayList <Integer> numbers = new ArrayList <> (List.of(1, 2, 5, 7, 9, 10));
		
		// all the three variations are printing out the whole List of elements:
		numbers.forEach(System.out :: println);
		numbers.stream().forEach(System.out :: println); // we convert it into 'stream' to manipulate with data
		numbers.stream().forEach(n -> System.out.println(n)); // print out the List using lambda
		
		
//-------------------- Stream can take any data type (multiple elements): --------------------------
		
		Stream.of(4, 8, 9, 12, 42, 50).forEach(System.out :: println); // int
		List.of(4, 8, 9, 12, 42, 50).stream().forEach(System.out :: println); // it is the same as above but longer
		
		Stream.of("love", "girl", "boy").forEach(System.out :: println); // Strings
		Stream.of("winter", 5, 8).forEach(System.out :: println);       //  mixed (different data types)
		
		// 'limit' combines with 'generate' and represents a number of executions
		//  if no number, it goes infinitively (as a loop)
		Stream.generate(() -> "Hello").limit(5).forEach(System.out :: println); 
		Stream.generate(() -> 8).limit(3).forEach(System.out :: println);
		
		
//---------------------------------- Stream of objects: ---------------------------------------------
		
        var colors = List.of("Red", "Blue", "Purple", "White", "Yellow", "Green", "Black");

        colors.stream().map(c -> new Color(c)); // 'map' converts all the elements of the List into the objects
        colors.stream().map(Color :: new);     // a shorter way
        colors.stream().map(Color :: new).forEach(System.out :: println); // print out all the objects of the list
        
        // counting the number of elements of the List
        long totalCount = colors.stream().count(); // use 'long' not 'int'
        System.out.println("Number of the elements in the list: " + totalCount);		
	}
}

class Color {
	private String color;
	
	public Color (String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public String toString () {
		return "Color: " + color;
	}
}
