package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Stream_Collector {
/*
 * java.util.stream.Collectors

  Implementations of Collector that implement various useful reduction operations, such as accumulating
   elements into collections, summarizing elements according to various criteria, etc.

  The following are examples of using the predefined collectors to perform common mutable reduction tasks:
 */
	public static void main(String[] args) {

		 List <String> people = Arrays.asList("Anna", "Maria", "Bob");
		 List <Persons> person = Arrays.asList(new Persons ("Ron", 25), new Persons ("Lolo", 40));
		
		// Accumulate names into a List
		 //List <String> list = people.stream().map(Persons::getName).collect(Collectors.toList());

		 // Accumulate names into a TreeSet
		 //List <String> set = people.stream().map(Persons::getName).collect(Collectors.toCollection(TreeSet::new));

	/*	 // Convert elements to strings and concatenate them, separated by commas
		 String joined = things.stream().map(Object::toString).collect(Collectors.joining(", "));

		 // Compute sum of salaries of employee
		 int total = employees.stream().collect(Collectors.summingInt(Employee::getSalary));

		 // Group employees by department
		 Map <Department, List<Employee>> byDept = employees.stream()
				 .collect(Collectors.groupingBy(Employee::getDepartment));

		 // Compute sum of salaries by department
		 Map <Department, Integer> totalByDept = employees.stream()
		   .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.summingInt(Employee::getSalary)));

		 // Partition students into passing and failing
		 Map <Boolean, List <Student>> passingFailing = students.stream()
		   .collect(Collectors.partitioningBy(s -> s.getGrade() >= PASS_THRESHOLD)); */
		
	}
}
class Persons {
	
	String name;
	int age;
	
	public Persons (String name, int age) {
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