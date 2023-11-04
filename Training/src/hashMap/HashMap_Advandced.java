package hashMap;
import java.util.*;

public class HashMap_Advandced {

	private static Integer id;
	private static String name;
	private static String course;
	private static Integer grade;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Map<Integer, String> idName = new HashMap<>();
		Map<Integer, String> idCourse = new HashMap<>();
		Map<Integer, Integer> idGrade = new HashMap<>();

		System.out.print("-WELCOME TO OUR 'STUDENT GRADE TRACKER APPLICATION!'\n");

		int option;
		do {
			System.out.print("\n\t   -THE MENU-\n\nPress '1' to enter your student's information"
					+ "\nPress '2' to retrive your personal info\nPress '3' to amend your personal info\nPress '4' to Exit\n\n"
					+ "Please, enter your option here: ");
			option = scanner.nextInt();

			switch (option) {
//-------------------------------------------------------------------
			case 1:
				System.out.print("\nPlease, enter your ID: ");
				Integer id1 = scanner.nextInt();
				if (idName.containsKey(id1)) {
					System.out.println("Your ID is already in the database. Press '2' to retrive your info");
					break;
				}
				System.out.print("\nEnter your name: ");
				String name1 = scanner.nextLine();
				name1 = scanner.nextLine();
				idName.put(id1, name1);

				System.out.print("\nEnter the name of your course: ");
				String course1 = scanner.nextLine();
				idCourse.put(id1, course1);

				System.out.print("\nYour grade: ");
				Integer grade1 = scanner.nextInt();
				idGrade.put(id1, grade1);
				break;
//-----------------------------------------------------------------------				
			case 2:
				System.out.print("\nEnter your ID: ");
				int id2 = scanner.nextInt();
				if (idName.containsKey(id2)) {
					System.out.println("\n\nYour name: " + (idName.get(id2)) + "\nYour course: " + (idCourse.get(id2))
							+ "\nYour grade: " + (idGrade.get(id2)));
				}

				else {
					System.out.println("Invalid ID. Try again.");
					break;
				}
				break;
//-------------------------------------------------------------------------				
			case 3:
				System.out.print("\nEnter your ID: ");
				int id3 = scanner.nextInt();
				if (idName.containsKey(id3)) {
					System.out.print(
							"Press '1' if you would like to amend your personal name\nPress '2' to amend the name of your course"
									+ "\nPress '3' to amend the grade\n\nPlease, enter your option here: ");
					int option2 = scanner.nextInt();
					switch (option2) {
					case 1:
						System.out.print("Enter your new name here: ");
						String name2 = scanner.nextLine();
						name2 = scanner.nextLine();
						if (!idName.containsValue(name2)) {
							idName.put(id3, name2);
						} else {
							System.out.println("Sorry, you have entered your current name. Try again.");
							break;
						}
						break;
					case 2:
						System.out.print("Enter the new name of your course here: ");
						String course2 = scanner.nextLine();
						course2 = scanner.nextLine();
						if (!idCourse.containsValue(course2)) {
							idCourse.put(id3, course2);
						} else {
							System.out.println("Sorry, you have entered your current name of the course. Try again.");
							break;
						}
						break;
					case 3:
						System.out.print("Enter your new grade here: ");
						int grade2 = scanner.nextInt();
						if (!idGrade.containsValue(grade2)) {
							idGrade.put(id3, grade2);
						} else {
							System.out.println("Sorry, you have entered your current grade. Try again.");
							break;
						}

					}
				} else {
					System.out.println("Invalid ID. Try again.");
					break;
				}

				break;
//--------------------------------------------------------------------------------------				
				
			case 4:
				System.out.println("Thank you for your session!");
				break;
			default:
				System.out.println("Invalid choice.\n");
			}
		} while (option != 4);
		scanner.close();
	}
}