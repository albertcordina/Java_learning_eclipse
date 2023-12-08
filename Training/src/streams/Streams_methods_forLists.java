package streams;

import java.util.Arrays;
import java.util.List;

public class Streams_methods_forLists {

	public static void main(String[] args) {
		
   //---------------------------- String ----------------------------------------
		List <String> names = Arrays.asList("Love", "Babies", "Boy", "Girl", "Trustful");
		
		findWordStartsWith (names, "B");    // prints out 'Babies' and 'Boy'	
		findWordByLengthEqual (names, 4);  //  prints out 'Love' and 'Girl'	
		findWordByLengthFrom (names, 7);  //   prints out 'Trustful'
		findWordByLengthUpTo (names, 3); //    prints out 'Boy'
		
		System.out.println(convertToUpperCase (names)); // print out the converted to UpperCase version of the List
		List <String> newConvertedList = convertToUpperCase (names); // Convert to UpperCase and save it in the new List.
		newConvertedList.forEach(System.out :: println);            //  print out the new converted to UpperCase List.
		// names = convertToUpperCase (names);                     // we can also convert the original List.
		
	//-------------------------- Integer -----------------------------------------	
		List <Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
        List <Integer> anotherList= findEvenNumbers (numbers);
        findNumbersFromToIncluded (numbers, 5, 8);
        int result = calculateSum(numbers);
        
    //---------------------------- Objects ----------------------------------------    
        List <Person> person = Arrays.asList(new Person( "John", 50), new Person ("Anna", 55));
        
        
		
	}
//--------------------------------- String ----------------------------------------	
	
 // The method 'findWordStarsWith' filters the List for the word(s) starting with a letter.
	private static void findWordStartsWith (List <String> list, String letter) {
		
		list.stream().filter(a -> a.startsWith(letter)).forEach(System.out :: println); 	
	}
 // The method 'findWordByLength' filters the List for the word(s) of particlar length.	
	private static void findWordByLengthEqual (List <String> list, int length) {
		
		list.stream().filter(a -> a.length() == length).forEach(System.out :: println);
	}
	
 // The method 'findWordByLengthFrom' filters the List for the word(s) of particlar length.	
	private static void findWordByLengthFrom (List <String> list, int length) {
			
		list.stream().filter(a -> a.length() >= length).forEach(System.out :: println);
	}
	
 // The method 'findWordByLengthFrom' filters the List for the word(s) of particlar length.	
	private static void findWordByLengthUpTo (List <String> list, int length) {
				
		list.stream().filter(a -> a.length() <= length).forEach(System.out :: println);
	}
	
      // The method 'convertToUpperCase' converts the List to UpperCase.
	private static List <String> convertToUpperCase (List <String> originalList) {
		List <String> convertedList;
		convertedList = originalList.stream().map(String :: toUpperCase).toList();
		return convertedList;
	}


	
//---------------------------------- Integer -----------------------------------------
	
    // The method 'findEvenNumbers' filters the List for the even numbers.	
	private static List <Integer> findEvenNumbers (List <Integer> list) {
		List <Integer> listOfEvenNumbers;
		listOfEvenNumbers = list.stream().filter(a -> a % 2 == 0).toList();
		return listOfEvenNumbers;
	}
	
// The method 'findNumbersFromToIncluded' filters the List for the numbers within the two numbers.
	private static void findNumbersFromToIncluded (List <Integer> list, int from, int to) {
		
		list.stream().filter(a -> a >= from && a <= to).forEach(System.out :: println);
	}
	
  // The method 'calculateSum' calculates the sum of the List.
    private static int calculateSum (List <Integer> list) {
       int sum = list.stream().mapToInt(Integer::intValue).sum();
        return sum;
    }
	
}

/*
 * These are just a few examples of the many methods available in the Stream
 * API. The API is quite extensive and provides a rich set of operations for
 * working with collections in a functional programming style.
 */
class Person {
	String name;
	int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
}