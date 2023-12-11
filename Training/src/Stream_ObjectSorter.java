
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream_ObjectSorter {

    // Generic method to sort objects based on a specific attribute
    public static <T> List<T> sortByAttribute(List<T> objects, Comparator<? super T> comparator) {
        return objects.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        // Example with a list of Person objects
        List<Person> people = List.of(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35));

        // Sort people by age and save in the new List:
        List<Person> sortedPeopleByAge = sortByAttribute(people, Comparator.comparingInt(Person::getAge));
        // Sort people by name and save in the new List:
        List<Person> sortedPeopleByName = sortByAttribute(people, Comparator.comparing(Person::getName));

        // Print the sorted lists:
        System.out.println("Sorted People by Age:");
        sortedPeopleByAge.forEach(person -> System.out.println(person.getName() + ": " + person.getAge()));
        System.out.println("\nSorted People by Name: ");
        sortedPeopleByName.forEach(person -> System.out.println(person.getName() + ": " + person.getAge()));

    }
}

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
}
