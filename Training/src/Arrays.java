import java.util.*;
public class Arrays {
	
	public static int maximum (int [] numbers) { 
		int maxSoFar = numbers [0];	
		for (int num : numbers) { if (num > maxSoFar) {	maxSoFar = num;}}
		return (maxSoFar);}
	

	public static void main(String[] args) {
		
		int [] cars = {5, 16, 7};
		
		System.out.println (maximum(cars));

		
		List <Cat> cats = new ArrayList <> (); // ArrayList with customer objects
		
		cats.add(new Cat ("Love", "cheshire", 4, 25));
		cats.add(new Cat ("Baby", "siam", 2, 28));
		cats.add(new Cat ("Girl", "stray", 1, 23));
		cats.add(new Cat ("Boy", "bold", 3, 20));

		cats.forEach(System.out::println);
		
		List <String> dogs = new ArrayList <> (); // ArrayList String
		
		dogs.add("Love");
		dogs.add("Baby");
		dogs.add("Girl");
		dogs.add("Boy");
		
		dogs.forEach(System.out::println);
		
		List <Integer> days = new ArrayList <> ();  // ArrayList Integer
		
		days.add(1);
		days.add(2);
		days.add(3);
		
		days.forEach(System.out::println);
		
	}
}

class Cat {
	
	int age;
	int length;
	String name;
	String type;
	
	public Cat (String name, String type, int age, int length) {
		
		this.name = name;
		this.type = type;
		this.age = age;
		this.length = length;
	}
	public String toString () {
		return "\nThe name: " + name + "\nThe type: " + type + "\nThe age: " + age + "\nThe length: " + length;
	}
}
