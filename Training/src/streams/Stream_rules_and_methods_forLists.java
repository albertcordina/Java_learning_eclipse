package streams;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Stream_rules_and_methods_forLists {
	/*
	 * the Stream API provides a powerful and expressive way to process data. 
	 * Here are simple examples of some common methods of the Stream API:
	 */
	public static void main(String[] args) {

		List<Person5> people = Arrays.asList(new Person5("Lolo", 20), new Person5("Leo", 30)); // List of objects
		List<String> names = Arrays.asList("Johnny", "Jane", "Doe", "Alice", "Bob");          //  List of Strings
		List<Integer> numbers = Arrays.asList(5, 10, 2, 8, 1, 9, 6, 3, 7, 4);                //   List of Integer

/*
 * 1. The 'filter' method: Used to -FILTER- elements based on a given condition:
 */
		names.stream().filter(name -> name.startsWith("J")).forEach(System.out::println);
		names.stream().filter(name -> name.length() > 5).forEach(System.out::println); // printing out 'Johnny'

		numbers.stream().filter(n -> n % 2 == 0).forEach(System.out::println); // Filtering even numbers
		numbers.stream().filter(n -> n > 5 && n < 9).forEach(System.out::println); // Filtering numbers

		// Sorting objects based on a specific attribute:
		people.stream().filter(person -> person.age > 25).forEach(person -> System.out.println(person.name));
		people.stream().filter(person -> person.name == "Lolo").forEach(person -> System.out.println(person.age));
		

/*
 * 2. The 'map' method: Used to -TRANSFORM- each element of the stream using a given function:
 *        map method can be used to transform elements in a stream based on a specified function.
 *        You can customize the mapping function to suit your specific transformation requirements.
 */
		List<String> namesUpperCase = names.stream().map(String::toUpperCase).toList(); // Converting strings to uppercase and 'toList' places it to a new List
		namesUpperCase.forEach(System.out::println);                                   // print out the new List
		//names.stream().map(String::toUpperCase); // we can also simply convert the orginal List
		
		List<String> numbersString = numbers.stream().map(Object :: toString).toList(); // Converting Int to strings and placing it to a new List
		numbersString.forEach(System.out::println);                                    // print out the new converted List
		//numbers.stream().map(Object :: toString); // we can also simply convert the orginal List
		
		numbers.stream().map(n -> n * 2).forEach(System.out::println);  // Doubling each number in a list (example)
		
		// Extracting a specific attribute from objects and save it in the List.
        List <String> namesFromObject = people.stream().map(a -> a.name).toList();
        System.out.println(namesFromObject); // prints out 'Lolo, Leo'
        

/*
 * 3. The 'sorted' method: Used to -SORT- the elements of the stream in alphabetical or numerical/ natural order:
 */
		names.stream().sorted().forEach(System.out::println);   // prints out the 'names' in alphabetical order 
		numbers.stream().sorted().forEach(System.out::println);//  prints out the 'numbers' in numerical order

		// Sorting objects based on a specific attribute:
		people.stream().sorted((p1, p2) -> p1.name.compareTo(p2.name)).forEach(person -> System.out.println(person.name));

		
/*
 * 4. The 'collect' method: Used to -ACCUMULATE- elements of the stream into a collection. i.e. another List:
 */	
		List<String> filteredNamesList1 = names.stream().filter(name -> name.length() > 3).collect(Collectors.toList());
		System.out.println(filteredNamesList1); // here we filter the List for the lenght of the names and save into List1
		
		List<String> filteredNamesList2 = filteredNamesList1.stream().map(String::toUpperCase).collect(Collectors.toList());	
		System.out.println(filteredNamesList2); // here we transform the List1 to the UpperCase and save it into List2
		System.out.println(filteredNamesList1); // the List1 has not been updated

	}
}
/*
 * These are just a few examples of the many methods available in the Stream
 * API. The API is quite extensive and provides a rich set of operations for
 * working with collections in a functional programming style.
 */
class Person5 {
	String name;
	int age;

	Person5(String name, int age) {
		this.name = name;
		this.age = age;
	}
}