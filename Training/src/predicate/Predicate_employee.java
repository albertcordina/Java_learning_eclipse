package predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

class Employee {
	private String name, departament, gender;
	private double salary;

	public Employee(String name, String departament, String gender, double salary) {
		this.name = name;
		this.departament = departament;
		this.gender = gender;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public String getDepartament() {
		return departament;
	}

	public String getGender() {
		return gender;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Employee name: " + name + ", departament: " + departament + ", gender: " + gender + ", salary: " + salary;
	}
}

public class Predicate_employee {

	public static void main(String[] args) {

		List <Employee> emp = new ArrayList <>();

		emp.add(new Employee("Bob", "IT", "male", 3450.9));
		emp.add(new Employee("Sian", "Sale", "female", 2450.9));
		emp.add(new Employee("Maria", "IT", "female", 3550.9));
		emp.add(new Employee("Albert", "Manager", "male", 4450.9));
		emp.add(new Employee("Fadi", "Boss", "male", 5450.9));
		emp.add(new Employee("Kurt", "Worker", "male", 1450.9));
		emp.add(new Employee("Alex", "IT", "female", 3450.9));
		
		System.out.println("\nOriginal list of employee: ");
		emp.forEach(System.out::println);

		System.out.println("-----------------\nFiltered list of employee: ");
		Predicate <Employee> process = p -> p.getDepartament().equalsIgnoreCase("IT"); // filter the list for 'department' 'IT'

		List <Employee> filteredEmployeeList = filterEmployee(emp, process);
		filteredEmployeeList.forEach(System.out::println);

		Function <Employee, String> function = f -> (f.getGender().equalsIgnoreCase("female") ? "Ms. " + f.getName()
				: "Mr. " + f.getName());

		List <String> updatedList = transformEmployeeNames(emp, function);
		System.out.println("-----------------\nList of employees with prefixes: ");
		updatedList.forEach(System.out::println);

	}

	static List <Employee> filterEmployee (List <Employee> emp, Predicate <Employee> process) {
		List <Employee> updatedEmployee = new ArrayList<>();

		emp.forEach(e -> {
			if (process.test(e)) { updatedEmployee.add(e);}
		});
		return updatedEmployee;
	}

	static List <String> transformEmployeeNames (List <Employee> emp, Function <Employee, String> function) {
		List<String> updatedNames = new ArrayList<>();

		emp.forEach(e -> {
			updatedNames.add(function.apply(e));
		});
		return updatedNames;
	}
}
