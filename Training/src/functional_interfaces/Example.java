package functional_interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;


public class Example {

	public static void main(String[] args) {
		
		List <Dogs> dogs = new ArrayList<>();
		
		dogs.add(new Dogs ("Love", 3));
		dogs.add(new Dogs ("Babies", 2));
		dogs.add(new Dogs ("Boy", 4));
		
		dogs.forEach(System.out :: println);		
		dogs.stream().filter(a -> a.name == "Baby").forEach(a -> System.out.println("The age of " + a.name + " is " + a.age));

	
		List <String> names = Arrays.asList("Love", "Babies", "Boy", "Girl", "Trustful");
		
		findWordStartsWith (names, "B");    // prints out 'Babies' and 'Boy'	
		findWordByLengthEqual (names, 4);  //  prints out 'Love' and 'Girl'	
		findWordByLengthFrom (names, 7);  //   prints out 'Trustful'
		findWordByLengthUpTo (names, 3); //    prints out 'Boy'
	}
	
 // The method 'findWordStarsWith' filters the List for the word(s) starting with a letter.
	public static void findWordStartsWith (List <String> list, String letter) {
		
		list.stream().filter(a -> a.startsWith(letter)).forEach(System.out :: println); 	
	}
 // The method 'findWordByLength' filters the List for the word(s) of particlar length.	
	public static void findWordByLengthEqual (List <String> list, int length) {
		
		list.stream().filter(a -> a.length() == length).forEach(System.out :: println);
	}
	
 // The method 'findWordByLengthFrom' filters the List for the word(s) of particlar length.	
	public static void findWordByLengthFrom (List <String> list, int length) {
			
		list.stream().filter(a -> a.length() >= length).forEach(System.out :: println);
	}
	
 // The method 'findWordByLengthFrom' filters the List for the word(s) of particlar length.	
	public static void findWordByLengthUpTo (List <String> list, int length) {
				
		list.stream().filter(a -> a.length() <= length).forEach(System.out :: println);
	}	
	
	
}
 class Dogs {
	 
	 String name;
	 int age;
	 
	public Dogs (String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Dogs [name=" + name + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
 }
