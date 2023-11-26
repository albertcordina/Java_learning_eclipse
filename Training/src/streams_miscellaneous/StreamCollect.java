package streams_miscellaneous;

import java.util.List;
import java.util.stream.Collectors;

class Color2 {
	private String color;
	
	public Color2 (String color) {
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

public class StreamCollect {

	public static void main(String[] args) {

	    // 'var' is used not a long time ago and mostly used to declare a List
        var colors = List.of("Red", "Blue", "Purple", "White", "Yellow", "Green", "Black");
		
		var list = colors // we copy the 'colors' to 'list' for not to modify the 'colors'
				.stream() // we transform/prepare the elements of the List for converting
				.map(Color2 :: new) // converting all the elements to 'Color' objects
				.collect(Collectors.toList()); // converting the objects to any other collector type (back to List as an example), 
                                              // terminal operation (like 'forEach')
		
		System.out.println(colors); // print out the list of elements
		System.out.println(list);  //  print out the list of objects
		
	}
}
