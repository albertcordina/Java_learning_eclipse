package hashMap;

import java.util.*;

public class HashMap_MultipleValueStorage { // The example of the 3 collected values from the user, which are all getting
                        // assigned to the 'HashMap's as the 'key' values for a better organisation of the sorage;
	static int id;
	static String name;
	static int age;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Map<Integer, String> IdToName = new HashMap<>();
		Map<String, Integer> NameToId = new HashMap<>();

		Map<Integer, Integer> IdToAge = new HashMap<>();
		Map<Integer, Integer> AgeToId = new HashMap<>();

		Map<String, Integer> NameToAge = new HashMap<>();
		Map<Integer, String> AgeToName = new HashMap<>();

		System.out.print("\nPlease, enter your Id number: ");
		id = scanner.nextInt();

		System.out.print("\nEnter your name: ");
		name = scanner.nextLine();
		name = scanner.nextLine();

		System.out.print("\nEnter your age: ");
		age = scanner.nextInt();

		IdToName.put(id, name);
		NameToId.put(name, id);

		IdToAge.put(id, age);
		AgeToId.put(age, id);

		NameToAge.put(name, age);
		AgeToName.put(age, name);

		System.out.println("\nThe KEY is 'Id':\nYour Id: " + id + "\nYour name: " + (IdToName.get(id)) + "\nYour age: " + (IdToAge.get(id)));
		System.out.println("\nThe KEY is 'name':\nYour name: " + name + "\nYour id: " + (NameToId.get(name)) + "\nYour age: " + (NameToAge.get(name)));

		//System.out.println("\nYour Id: " + id + "\nYour age: " + (IdToAge.get(id)) + "\nYour name: " + (IdToName.get(id))); // the gray ones are the second similar optional variations;
		System.out.println("\nThe KEY is 'age':\nYour age: " + age + "\nYour Id: " + (AgeToId.get(age)) + "\nYour name: " + (AgeToName.get(age)));
		
		//System.out.println("\nYour name: " + name + "\nYour age: " + (NameToAge.get(name)) + "\nYour Id: " + (NameToId.get(name)));
		//System.out.println("\nthis is your age: " + age + "\nthis is your name: " + (AgeToName.get(age)) + "\nthis is your Id: " + (AgeToId.get(age)));

		scanner.close();
	}
}