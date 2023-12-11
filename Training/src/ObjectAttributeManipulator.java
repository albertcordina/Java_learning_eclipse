
import java.util.List;
import java.util.stream.Collectors;

public class ObjectAttributeManipulator {

    // Generic method to manipulate a specific attribute of objects
    public static <T> List<T> manipulateAttribute(List<T> objects, AttributeManipulator<T> manipulator) {
    	
        return objects.stream().map(manipulator::apply).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        // Example with a list of Person objects
        List<Person8> people = List.of(
                new Person8("Alice", 30),
                new Person8("Bob", 25),
                new Person8("Charlie", 35)
        );

        // Increment ages of people by 1
        List<Person8> peopleWithIncrementedAges = manipulateAttribute(people, a -> {
            a.setAge(a.getAge() + 1);
            return a;
        });

        // Print the manipulated list
        System.out.println("People with Incremented Ages:");
        peopleWithIncrementedAges.forEach(a -> System.out.println(a.getName() + ": " + a.getAge()));
    }
}

class Person8 {
    private String name;
    private int age;

    public Person8(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

// Functional interface for manipulating attributes
@FunctionalInterface
interface AttributeManipulator<T> {
    T apply(T object);
}

