package passing_by_value;

public class Person {
		
		String name; // 'instance variable' belongs to the class;

		public Person (String name) {  // 'constructor' gets created by: right click + source + Create constructor using Fields..;
			this.name = name;                       // 'constructor' doesn't have a returned type;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		public String toString() {
			return "Person [name = " + name + "]";
		}
		
}
