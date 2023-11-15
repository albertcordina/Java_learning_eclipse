package predicate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public boolean isAdult() {
		return age >= 18;
	}

	public String getName() {
		return name;
	}
}

public class Predicate_filterArrayList_DoubleColon {

	static List<Person> filterAdults (List<Person> a, Predicate <Person> predicate) {
		return a.stream().filter(predicate).collect(Collectors.toList());
	}

	public static void main (String[] args) {
		List <Person> persons = List.of (new Person("Alice", 25), new Person("Bob", 17), 
				new Person("Charlie", 30),new Person("David", 16), new Person("Eva", 22));

		// Using lambda expression with Predicate
		List<Person> adults = filterAdults(persons, Person::isAdult);

		System.out.println("Names of Adult Persons:");
		adults.forEach(b -> System.out.println(b.getName()));
	}
}
