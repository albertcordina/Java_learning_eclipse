package lambda_expressions;

import java.util.ArrayList;
import java.util.List;

public class LambdaExercise {
	
	public static class Person {
		
		private String name;
		private int age;
		private String city;

		public Person(String name, int age, String city) { // the constructor to create the objects to be used by the 'inputList' below
			this.name = name;
			this.age = age;
			this.city = city;
		}

		public String getName() {
			return name;
		}

		public int getAge() {
			return age;
		}

		public String getCity() {
			return city;
		}

		@Override
		public String toString() { // 'toString' is to summarise the parameters into one String
			return "Person{" + "name='" + name + '\'' + ", age=" + age + ", city='" + city + '\'' + '}';
		}
	}

	public static List<String> filterAndTransform(List<Person> inputList) {
		
		List<String> result = new ArrayList<>();
			
		inputList.forEach(person -> {     // lambda expressions to filter/Iterate the whole 'inputlist'
			if (person.getAge() <= 30) { //  according to the condition, i.e the age <= 30
				result.add(person.getName() + " from " + person.getCity()); 
			}   
		});
		return result;
	}

	public static void main(String[] args) {
		// Create a list of Person objects
		List<Person> people = new ArrayList<>();
		
		people.add(new Person("Maya", 25, "New York"));
		people.add(new Person("Travis", 32, "Los Angeles"));
		people.add(new Person("Steffen", 28, "Chicago"));
		people.add(new Person("Cassie", 40, "San Francisco"));
		
		// Call the 'filterAndTransform' method
		List<String> filteredAndTransformed = filterAndTransform(people);
		
		System.out.println("Original List of People:"); // prints out the original list of Person objects
		people.forEach(System.out::println);           //  'forEach' method Iterates the whole list 
		
		System.out.println("Filtered and Transformed List:"); // print out the filtered and transformed list of Strings
		filteredAndTransformed.forEach(System.out::println);
	}
}
