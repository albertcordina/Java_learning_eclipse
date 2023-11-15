package double_colon_operator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/*
 * The double colon (::) operator is a special lambda expression.
 * This operator is also known as method reference operator.
 * 
 * Where can we use the double colon operator?
 * - Static method
 * - Instance method
 * - Constructor

 */

class Test {
	String print(String p) {
		return ("Item: " + p + "\n");
	}
}

public class DoubleColon_operator extends Test {

	@Override
	String print(String p) {
		Function<String, String> a = super::print; // 'Function' is Interface has only one method: 'apply'
		String newValue = a.apply(p);
		newValue += "Good: " + p + "\n";
		System.out.println(newValue);
		return newValue;
	}

	static void items(String s) { // - Static method
		System.out.println(s);
	}

	void goods(String b) { // - Instance method
		System.out.println(b);
	}

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("Apples");
		list.add("Milk");
		list.add("Rie");

		// - Static method: Syntax: ClassName :: methodName
		list.forEach(DoubleColon_operator::items);

		// - Instance method: Syntax: objectOfClass :: methodName
		list.forEach((new DoubleColon_operator())::goods);
		// - Instance of method of Parent/Super class (the same Syntax)
		list.forEach((new DoubleColon_operator())::print);

        ArrayList<Person> personList = new ArrayList<>();
        personList.add(new Person("Charlie"));
        personList.add(new Person("Mary"));
        personList.add(new Person("Loo"));
        
        // Using forEach and method reference to print each person's name
        personList.forEach(Person::printName);
    }

    static class Person {
        String name;

        Person(String name) {
            this.name = name;
        }

        void someMethod() {
            System.out.println(this.name);
        }

        // Method reference to print the name of a person
        void printName() {
            System.out.println("Person: " + this.name);
        }
    }
}
