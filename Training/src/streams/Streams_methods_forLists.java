package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Streams_methods_forLists {

	public static void main(String[] args) {
		
   //----------------------------- String ----------------------------------------
		List <String> names = Arrays.asList("Love", "Babies", "Boy", "Girl", "Trustful");
		
		
		System.out.println(findWordStartsWith (names, "B"));    // prints out 'Babies' and 'Boy'	
		System.out.println(findWordByLengthEqual (names, 4));  //  prints out 'Love' and 'Girl'	
		System.out.println(findWordByLengthFrom (names, 7));  //   prints out 'Trustful'
		System.out.println(findWordByLengthUpTo (names, 3)); //    prints out 'Boy'
	/*
	 * 	Example of additional functions which can be used also by all other methods:
	 *  1. amending the original List
	 *  2. saving the amendment to a new List
	 *  3. printing out a List
	 */
//   		
		System.out.println(convertToUpperCase (names)); // print out the converted to UpperCase version of the List
		List <String> newConvertedList = convertToUpperCase (names); // Convert to UpperCase and save it in the new List.
		newConvertedList.forEach(System.out :: println);            //  print out the new converted to UpperCase List.
		// names = convertToUpperCase (names);                     // we can also convert the original List.
		
		
	//---------------------------- Integer -----------------------------------------	
		List <Integer> numbers = Arrays.asList(2, 1, 3, 4, 8, 6, 7, 5, 9, 10);
		
		System.out.println(findEvenNumbers(numbers));  // prints out '2,4,8,6,10'
        System.out.println(findNumbersFromToIncluded (numbers, 5, 8)); // prints out '8,6,7,5'
        System.out.println(calculateSum(numbers));  // prints out '55'      
        System.out.println(sortNumericalOrder(numbers)); // prints out '1,2,3,4,5,6,7,8,9,10'
        
        
    //---------------------------- Objects ----------------------------------------    
        List <Person> person = Arrays.asList(new Person( "Karen", 50), new Person ("Anna", 65), new Person ("Bob", 40));
        
        
        // Sort people by age and save in the new List:
        List<Person> sortedPeopleByAge = sortByAttribute(person, Comparator.comparingInt(Person::getAge));
        // Sort people by name and save in the new List:
        List<Person> sortedPeopleByName = sortByAttribute(person, Comparator.comparing(Person::getName));

        // Print the sorted lists:
        System.out.println("\nSorted People by Age:");
        sortedPeopleByAge.forEach(a -> System.out.println(a.getName() + ": " + a.getAge()));
        System.out.println("\nSorted People by Name: ");
        sortedPeopleByName.forEach(a -> System.out.println(a.getName() + ": " + a.getAge()));
		
	}
	
	//------------------------------ METHODS --------------------------------------
	
//---------------------------------- String ----------------------------------------	
	
 // The method 'findWordStarsWith' filters the List for the word(s) starting with a letter.
	private static List <String> findWordStartsWith (List <String> list, String letter) {
		
		List <String> filteredList;
		filteredList = list.stream().filter(a -> a.startsWith(letter)).toList(); 	
		return filteredList;
	}
 // The method 'findWordByLength' filters the List for the word(s) of particlar length.	
	private static List <String> findWordByLengthEqual (List <String> list, int length) {
		
		List <String> filteredList;
		filteredList = list.stream().filter(a -> a.length() == length).toList();
		return filteredList;
	}
	
 // The method 'findWordByLengthFrom' filters the List for the word(s) of particlar length.	
	private static List <String> findWordByLengthFrom (List <String> list, int length) {
		
		List <String> filteredList;	
		filteredList = list.stream().filter(a -> a.length() >= length).toList();
		return filteredList;
	}
	
 // The method 'findWordByLengthFrom' filters the List for the word(s) of particlar length.	
	private static List <String> findWordByLengthUpTo (List <String> list, int length) {
		
		List <String> filteredList;		
		filteredList = list.stream().filter(a -> a.length() <= length).toList();
		return filteredList;
	}
	
      // The method 'convertToUpperCase' converts the List to UpperCase.
	private static List <String> convertToUpperCase (List <String> originalList) {
		
		List <String> convertedList;
		convertedList = originalList.stream().map(String :: toUpperCase).toList();
		return convertedList; 
	}

	
//----------------------------------- Integer -----------------------------------------
	
    // The method 'findEvenNumbers' filters the List for the even numbers.	
	private static List <Integer> findEvenNumbers (List <Integer> list) {
		
		List <Integer> listOfEvenNumbers;
		listOfEvenNumbers = list.stream().filter(a -> a % 2 == 0).toList();
		return listOfEvenNumbers;
	}
	
// The method 'findNumbersFromToIncluded' filters the List for the numbers within the two numbers.
	private static List <Integer> findNumbersFromToIncluded (List <Integer> list, int from, int to) {
		
		List <Integer> listOfFromTo;
		listOfFromTo = list.stream().filter(a -> a >= from && a <= to).toList();
		return listOfFromTo;
	}
	
  // The method 'calculateSum' calculates the sum of the Integer List.
    private static int calculateSum (List <Integer> list) {
    	
       int sum = list.stream().mapToInt(Integer::intValue).sum();
        return sum;
    }
    
    // The method 'sortNumericalOrder' sorts the List in numerical order.
    private static List <Integer> sortNumericalOrder (List <Integer> list) {
    	
    	List <Integer> orderedList;
    	orderedList = list.stream().sorted().collect(Collectors.toList());
    	return orderedList;
    }
//--------------------------------- Custom Objects -----------------------------------
    
    // Generic method to sort objects based on a specific attribute
    public static <T> List<T> sortByAttribute(List<T> objects, Comparator<? super T> comparator) {
    	
        return objects.stream().sorted(comparator).collect(Collectors.toList());        
    }
    
    public static <T> List<T> sortByString(List<T> objects, Comparator<? super T> comparator) {

	people.stream().filter(person -> person.name == "Lolo").forEach(person -> System.out.println(person.age));

    }
}

/*
 * These are just a few examples of the many methods available in the Stream
 * API. The API is quite extensive and provides a rich set of operations for
 * working with collections in a functional programming style.
 */

//------------------------------------------------------------------------------------------------

class Person {
	String name;
	int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}