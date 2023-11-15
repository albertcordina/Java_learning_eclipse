package predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Person1 {
	String name;
	int age;
	
// get method: to get the result of the parameter 'name'
	String getName() {
		return name;
	} 
// to get the result of the parameter 'age'
	int getAge() {
		return age;
	} 
	
// calling the method 'filterAdults' below and setting the filter requirements
	static public void isAdult(List<Person1> list) {
		
		List adults = filterAdults(list, (Person1 u) -> u.getAge() > 18);
		System.out.println(adults); // print out the filtered List of adults
	}

	public Person1(String name, int age) { // Constructor
		this.name = name;
		this.age = age;
	} 

	public String toString() { // to create a String
		return "\nThe adult : " + name + ", Age: " + age;
	} 

	public static List<Person1> filterAdults(List<Person1> a, Predicate<Person1> predicate) {

		List<Person1> over18 = new ArrayList<Person1>();

		for (Person1 b : a) // iterate through the list of objects 'b'
			if (predicate.test(b)) // filter the objects 'b' according to the conditions via 'predicate'
				over18.add(b); // add the filtered List of objects 'b' to the List 'over18'
		return over18; // return the over18
	}
}

public class Predicate_filterArrayList {
	
	public static void main(String[] args) {
		
		List<Person1> list = new ArrayList<Person1>(); // Objects is the name of the class

		list.add(new Person1("John", 17));
		list.add(new Person1("Peter", 20));
		list.add(new Person1("Anna", 21));
		list.add(new Person1("Victoria", 16));

		Person1.isAdult(list);
	}
}
