import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

public class Filter {

	public static void main(String[] args) {
		
		List <String> list = List.of("Love", " is", " the", " best!"); // List is not ArrayList
        list.forEach(System.out :: print);

        list.stream().filter(n -> n == " the ").forEach(System.out :: println); 
        
		var lists = List.of(2, "love", 5, "people");
		lists.stream().filter(s -> s == "people").forEach(System.out :: println);
		
		List <Integer> li = new ArrayList <> ();
		li.add(5);
		li.add(8);
		li.add(15);
		li.add(2);
		
		li.stream().filter(n ->   n > 6).forEach(System.out :: println);
		
    	List<String> names = List.of("Alice", "Bob", "Charlie");
    	names.stream().filter(s ->  s == "Bob").forEach(System.out :: println);
    	
    	List <Integer> numbers = List.of(5, 8, 12, 25);
    	numbers.stream().filter(n ->   n > 10).forEach(System.out :: println);
				
		
	}
}

