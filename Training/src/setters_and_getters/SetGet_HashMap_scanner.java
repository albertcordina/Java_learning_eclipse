package setters_and_getters;
import java.util.*;

class M {

	private String name;
	private int age;

	public String getName() {
		return "Your name is " + name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return "you are " + age + " years old.";
	}

	public void setAge(int age) {
		this.age = age;
	}
}

public class SetGet_HashMap_scanner {

	public static void main(String[] args) {

		M m = new M();
		Map<String, Integer> list = new HashMap<>();
		Scanner scan = new Scanner(System.in);

		int option;
		do {

			System.out.print(
					"\nPress '1' to enter your info:\nPress '2' to retrive the whole list:\nPress '3' to Exit\n\nEnter your option: ");
			option = scan.nextInt();

			switch (option) {

			case 1:
				System.out.print("Enter your name: ");
				String name = scan.nextLine();
				name = scan.nextLine();

				System.out.print("Enter your age: ");
				int age = scan.nextInt();
				list.put(name, age);

				m.setName(name);
				m.setAge(age);
				System.out.println(m.getName() + " and " + m.getAge());
				break;
			case 2:
				for (Map.Entry<String, Integer> map : list.entrySet()) { // TO ITERATE THE WHOLE 'HashMap' (used mainly
																			// only for a review);
					System.out.println("The name: " + map.getKey() + ", and the age: " + map.getValue());
				}
				break;
			case 3:
				System.out.println("\n\nThank you for your session!");
				break;

			default:
				System.out.println("Invalid choice.");
			}
		} while (option != 3);

	}

}
