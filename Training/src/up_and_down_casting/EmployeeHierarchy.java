package up_and_down_casting;

abstract class Employee {
	
    String name;
    int employeeId;
    double salary;

    public Employee(String name, int employeeId, double salary) {
        this.name = name;
        this.employeeId = employeeId;
        this.salary = salary; }

    public abstract double calculateBonus();
}
//------------------------------------------------
class Manager extends Employee {
	
    int teamSize;

    public Manager(String name, int employeeId, double salary, int teamSize) {
        super(name, employeeId, salary);
        this.teamSize = teamSize;  }

    @Override
    public double calculateBonus() { return salary * 0.2;} // 20% of salary as bonus for managers
}
//---------------------------------------------------------------------------------------
class Engineer extends Employee {
	
    String programmingLanguage;

    public Engineer(String name, int employeeId, double salary, String programmingLanguage) {
        super(name, employeeId, salary);
        this.programmingLanguage = programmingLanguage;}

    @Override
    public double calculateBonus() { return salary * 0.1;} // 10% of salary as bonus for engineers
}
//---------------------------------------------------------------------------------------
class Intern extends Employee {
	
    int durationInWeeks;

    public Intern(String name, int employeeId, double salary, int durationInWeeks) {
        super(name, employeeId, salary);
        this.durationInWeeks = durationInWeeks;}

    @Override
    public double calculateBonus() { return 0.0;} // No bonus for interns
}
//---------------------------------------------------------------------------------
public class EmployeeHierarchy {
	
    public static void main(String[] args) {
    	
        // Create Manager, Engineer, and Intern objects
        Manager manager = new Manager("John Doe", 101, 80000.0, 5);
        Engineer engineer = new Engineer("Alice Smith", 102, 60000.0, "Java");
        Intern intern = new Intern("Bob Johnson", 103, 30000.0, 12);

        // Upcasting to Employee references
        Employee employee1 = manager;
        Employee employee2 = engineer;
        Employee employee3 = intern;

        // Calculate and display bonuses using upcasted references
        System.out.println("Bonus for " + employee1.name + ": $" + employee1.calculateBonus());
        System.out.println("Bonus for " + employee2.name + ": $" + employee2.calculateBonus());
        System.out.println("Bonus for " + employee3.name + ": $" + employee3.calculateBonus());

        // Downcasting to access specific attributes
        if (employee1 instanceof Manager) {
            Manager downcastedManager = (Manager) employee1;
            System.out.println("Manager's Team Size: " + downcastedManager.teamSize);}

        if (employee2 instanceof Engineer) {
            Engineer downcastedEngineer = (Engineer) employee2;
            System.out.println("Engineer's Programming Language: " + downcastedEngineer.programmingLanguage);}

        if (employee3 instanceof Intern) {
            Intern downcastedIntern = (Intern) employee3;
            System.out.println("Intern's Duration in Weeks: " + downcastedIntern.durationInWeeks);}
    }
}
