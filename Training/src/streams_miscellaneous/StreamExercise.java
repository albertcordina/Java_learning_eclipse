package streams_miscellaneous;

import java.util.List;
import java.util.stream.Collectors;

class Person {
	
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class StreamExercise {
	
    public static List<String> processData(List<Person> persons) {
    	
        // Filter out persons under the age of 30 and map remaining persons to their names
        return persons.stream()
                .filter(person -> person.getAge() >= 30)
                .map(Person::getName)
                .collect(Collectors.toList());
    }
    
    public static void main(String[] args) {
    	
        // Create a list of persons with various names and ages
        List<Person> persons = List.of(
                new Person("Alice", 25),
                new Person("Bob", 32),
                new Person("Charlie", 28),
                new Person("David", 40),
                new Person("Eva", 22)
        );
        
        // Call the processData method to filter and map persons
        List<String> result = processData(persons);
        
        // Print the original list of persons
        System.out.println("Original List of Persons:");
        persons.forEach(System.out::println);
        
        // Print the filtered and mapped list of names
        System.out.println("Filtered and Mapped List of Names:");
        result.forEach(System.out::println);
    }
}
