package lambda_expressions;

import java.util.List;
import java.util.ArrayList;

public class LambdaExercise2 {
	public static class Employee {
		
		private String name;
		private String position;
		private double salary;

		public Employee(String name, String position, double salary) {
			this.name = name;
			this.position = position;
			this.salary = salary;
		}

		public String getName() {
			return name;
		}

		public String getPosition() {
			return position;
		}

		public double getSalary() {
			return salary;
		}

		@Override
		public String toString() {
			return "Employee{" + "name='" + name + '\'' + ", position='" + position + '\'' + ", salary=" + salary + '}';
		}
	}

	public static List<String> calculateAnnualBonuses(List<Employee> inputList) {

		List<String> result = new ArrayList<>();

		inputList.forEach(employee -> {
			double bonus = 0.0;
			if ("Manager".equals(employee.getPosition())) {
				bonus = employee.getSalary() * 0.15;
			} else if ("Developer".equals(employee.getPosition())) {
				bonus = employee.getSalary() * 0.10;
			} else if ("Intern".equals(employee.getPosition())) {
				bonus = employee.getSalary() * 0.05;
			}
			result.add("Employee: " + employee.getName() + ", Annual Bonus: " + bonus);
		});
		return result;
	}

	public static void main(String[] args) {
		
		// Create a list of Employee objects
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("Alice", "Manager", 60000.0));
		employees.add(new Employee("Bob", "Developer", 50000.0));
		employees.add(new Employee("Charlie", "Intern", 30000.0));
		employees.add(new Employee("David", "Designer", 45000.0));
		
		// Call the calculateAnnualBonuses method
		List<String> annualBonuses = calculateAnnualBonuses(employees);
		
		// Print the original list of employees
		System.out.println("Original List of Employees:");
		employees.forEach(System.out::println);
		
		// Print the calculated annual bonuses
		System.out.println("Calculated Annual Bonuses:");
		annualBonuses.forEach(System.out::println);
	}
}
