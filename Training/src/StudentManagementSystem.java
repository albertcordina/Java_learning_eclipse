import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.InputMismatchException;

class CollectionInfoMenu extends StudentData {

	private int id; // the personal id is the 'key', therefore, it has the 'private' access modifier
	static int opt;
	Map<Integer, StudentData> students = new HashMap<>();
	Scanner scan = new Scanner(System.in);

//-------------------------------------------------------------------------------------------------------
	public void amendmentMenu() { // the method is amending the user's personal info (used in the method below)
                
    	do {
			System.out.print("\nEnter:\n'1' to amend your name:\n'2' to amend your age\n'3' to amend "
					+ "your address\n'4' to amend the name of the course\n'5' back to the main Menu\nEnter your valid option here: ");
     
			do { // in case of entering String instead of int
				try { opt = scan.nextInt();
				        scan.nextLine();} 
				catch (InputMismatchException e) {
					System.out.println("Enter a valid positive number, not any other character.");
					scan.nextLine();
				}
			} while (!(opt > 0 || opt < 6)); // and also restrincting to a number within the Menu

			switch (opt) {
			case 1:
				System.out.print("Please, enter your new name: ");
				name = scan.nextLine();
				//scan.nextLine();
				students.put(id, new StudentData(name, age, contactAddress, nameOfTheCourse));
				System.out.println("Your name has been successfully amended.");
				break;
			case 2:				
					try {  // in case of entering String instead of int
						System.out.print("Enter your actual age: ");
						age = scan.nextInt();
						students.put(id, new StudentData(name, age, contactAddress, nameOfTheCourse));
						System.out.println("Your age has been successfully amended.");
					} 
					catch (InputMismatchException e) {
						System.out.println("There should be a positive number, not any other character.");
						scan.nextLine();}			
				break;
			case 3:
				System.out.print("Enter your new contact address: ");
				contactAddress = scan.nextLine();
				scan.nextLine();
				students.put(id, new StudentData(name, age, contactAddress, nameOfTheCourse));
				System.out.println("Your contact address has been successfully amended.");
				break;
			case 4:
				System.out.print("Enter the name of your new course: ");
				nameOfTheCourse = scan.nextLine();
				scan.nextLine();
				students.put(id, new StudentData(name, age, contactAddress, nameOfTheCourse));
				System.out.println("The name of your course has been successfully amended.");
				break;
			case 5:
				System.out.println("You are back to the main Menu.");
				break;

			default:
				System.out.println("Invalid input. Try again.");
				break;
			}
		}	
        while (!(opt == 5));				
}
//--------------------------------------------------------------------------------------------------
	public void mainMenu() { // the method represents the main Menu and the info operation

		do {
			System.out.print("\n\t\t   The Menu:\n'1' - to create your profile (enter your personal info)"
							+ "\n'2' - to amend your personal info\n'3' - to remove your profile from the list\n'4' - to Exit\n\nEnter your valid option here: ");

			
			do { // in case of entering String instead of int
				try { opt = scan.nextInt();
				      scan.nextLine();} 
				catch (InputMismatchException e) {
					System.out.println("Enter a valid positive number, not any other character.");
					scan.nextLine();
				}
			} while (!(opt > 0 || opt < 5)); // and also restricting to a number within the Menu
			

			switch (opt) {
			case 1:
				System.out.print("\nPlease, enter your name: ");
				name = scan.nextLine();

				do { // in case of entering String instead of int
					try {
						System.out.print("Enter your age: ");
						age = scan.nextInt();
					} 
					catch (InputMismatchException e) {
						System.out.println("There should be a positive number, not any other character.");
						scan.nextLine();
					}
				} while (age <= 0); // also requesting a positive number

				System.out.print("Enter your contact address: ");
				contactAddress = scan.nextLine();
				contactAddress = scan.nextLine();

				System.out.print("Enter the name of the course: ");
				nameOfTheCourse = scan.nextLine();

				do { // in case of entering String instead of int
					try {
						System.out.print("Enter your unique id number: ");
						id = scan.nextInt();
					} 
					catch (InputMismatchException e) {
						System.out.println("There should be a positive number, not any other character.");
						scan.nextLine();
					}
				} while (id <= 0);

				while (students.containsKey(id)) {
					System.out.print("This ID is already in use. Please, try another one: ");
					id = scan.nextInt();}
				
				students.put(id, new StudentData(name, age, contactAddress, nameOfTheCourse));
				System.out.println("You have sucessfully entered your personal information!");
				break;

			case 2:
				do { // in case of entering String instead of int
					try {
						System.out.print("Enter your unique id number: ");
						id = scan.nextInt();
					} 
					catch (InputMismatchException e) {
						System.out.println("There should be a positive number, not any other character.");
						scan.nextLine();
					}
				} while (id <= 0);

				if (students.containsKey(id)) { // the display of the all current personal info of the student
					for (Map.Entry<Integer, StudentData> map : students.entrySet()) { System.out.println(map.getValue()); }
					amendmentMenu(); } //  call of the method above to amend the personal info of the student
				
				else { System.out.println("Invalid ID. You are back to the main Menu.");}
				break;

			case 3:  			
				do { // in case of entering String instead of int
					try {
						System.out.print("Enter your unique ID number to remove your profile: ");
						id = scan.nextInt();} 
					catch (InputMismatchException e) {
						System.out.println("There should be a positive number, not any other character.");
						scan.nextLine();
					}
				} while (id <= 0);

				if (students.containsKey(id)) {
					students.remove(id); //   the removal of the all personal info of the student
					System.out.println("Your profile has been successfully removed from the list.");}

				else { System.out.println("Invalid ID. You are back to the main Menu.");}
				break;

			case 4:
				System.out.println("Thank you for your session!");
				break;

			default:
				System.out.println("Invalid choice. Try again.");
			}
		} while (!(opt == 4));
		scan.close();
	 } 
  }
//--------------------------------------------------------------------------------------------
class StudentData {

    String name;
	int age;
	String contactAddress;
	String nameOfTheCourse;

	public StudentData(String name, int age, String contactAddress, String nameOfTheCourse) {

		this.name = name;
		this.age = age;
		this.contactAddress = contactAddress;
		this.nameOfTheCourse = nameOfTheCourse;
	}

	public StudentData() {
	}

	public String toString() {  // toString method for the printing out the personal info
		return "\n\nYour current personal info:\nName: " + name + "\nAge: " + age + "\nAddress: " + contactAddress
				+ "\nCourse: " + nameOfTheCourse;
	} 
}
//---------------------------------------------------------------------------------------------

public class StudentManagementSystem {

	public static void main(String[] args) {
		
		System.out.println("\t- Welcome to the Student Database -");

		CollectionInfoMenu collectionInfoMenu = new CollectionInfoMenu();
		collectionInfoMenu.mainMenu();
	}
}
