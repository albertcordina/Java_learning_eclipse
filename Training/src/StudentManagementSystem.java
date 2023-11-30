
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.InputMismatchException;

public class StudentManagementSystem {

	public static void main(String[] args) {

		System.out.println("\t- Welcome to the Student Database -");

		CollectionInfoMenu collectionInfoMenu = new CollectionInfoMenu();
		collectionInfoMenu.menu();
	}
}
//----------------------------------------------------------------------------------------------


class StudentData {

	static String name;
	static int age;
	static String contactAddress;
	static String nameOfTheCourse;

	public StudentData(String name, int age, String contactAddress, String nameOfTheCourse) {

		this.name = name;
		this.age = age;
		this.contactAddress = contactAddress;
		this.nameOfTheCourse = nameOfTheCourse;
	}

	public StudentData() {
	}

	public String toString() { // toString method for the printing out the personal info
		return "\n\nYour current personal info:\nName: " + name + "\nAge: " + age + "\nAddress: " + contactAddress
				+ "\nCourse: " + nameOfTheCourse;
	}
}
//------------------------------------------------------------------------------------------------------------------------------------------


class CollectionInfoMenu extends StudentData {

	protected static int id; // the personal id is the 'key', therefore, it has the 'private' access modifier
	static int opt;

	Map<Integer, StudentData> students = new HashMap<>();
	Scanner scan = new Scanner(System.in);

	
	public void menu() { // the head method of this class: represents the main Menu and the info operations

		System.out.println(
				"\nPress '1' for the registration and saving your personal data in a file on your PC\nIf you are already registered, enter any other number: ");
		try {
			opt = scan.nextInt();
			scan.nextLine();

			if (opt == 1) {
				registration();
			} else {
				System.out.println("\tWelcome to the main Menu!");
			}
		} catch (InputMismatchException e) {
			System.out.println("\tWelcome to the main Menu!");
		}

		
		
		do {
			System.out.print(
					"\n\t\t   The Menu:\n'1' - the amendment of your personal info -\n'2' - to remove your profile from the list\n'3' - Exit\n\nEnter your valid option here: ");

			do { // in case of entering String instead of int
				try {
					opt = scan.nextInt();
					// scan.nextLine();
				} catch (InputMismatchException e) {
					System.out.println("Enter a valid positive number, not any other character.");
					scan.nextLine();
				}
			} while (!(opt > 0 || opt < 4)); // and also restricting to a number within the Menu

			switch (opt) {

			case 1:
				do { // in case of entering String instead of int
					try {
						System.out.print("Enter your unique id number: ");
						id = scan.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("There should be a positive number, not any other character.");
						scan.nextLine();
					}
				} while (id <= 0); // also the requirment of the positive number

				if (students.containsKey(id)) { // the display of the all current personal info of the student
					for (Map.Entry<Integer, StudentData> map : students.entrySet()) {
						System.out.println(map.getValue());
					}
					amendment();
				} // call of the corresponding method to amend the personal info of the student

				else {
					System.out.println("Invalid ID. You are back to the main Menu.");
				}
				break;

			case 2:
				do { // in case of entering String instead of int
					try {
						System.out.print("Enter your unique ID number to remove your profile: ");
						id = scan.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("There should be a positive number, not any other character.");
						scan.nextLine();
					}
				} while (id <= 0); // also the requirment of the positive number

				if (students.containsKey(id)) {
					students.remove(id); // the removal of the all personal info of the student
					System.out.println("Your profile has been successfully removed from the list.");
				}

				else {
					System.out.println("Invalid ID. You are back to the main Menu.");
				}
				break;

			case 3:
				System.out.println("Thank you for your session!");
				break;

			default:
				System.out.println("Invalid choice. Try again.");
			}
		} while (!(opt == 3));
		scan.close();
	}

	
	public void registration() { // the method for the registration (used in the 'menu' method above)

		System.out.print("\nPlease, enter your name: ");
		name = scan.nextLine();

		do { // in case of entering String instead of int
			try {
				System.out.print("Enter your age: ");
				age = scan.nextInt();
			} catch (InputMismatchException e) {
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
			} catch (InputMismatchException e) {
				System.out.println("There should be a positive number, not any other character.");
				scan.nextLine();
			}
		} while (id <= 0);

		while (students.containsKey(id)) {
			System.out.print("This ID is already in use. Please, try another one: ");
			id = scan.nextInt();
		}

		students.put(id, new StudentData(name, age, contactAddress, nameOfTheCourse));
		System.out.print(
				"You have sucessfully entered your personal information!\n\nIf you would like to write your info into "
						+ "a file in your PC, press '1'. If not, press any other character: ");
		try {
			opt = scan.nextInt();
			if (opt == 1) {
				FileReaderAndWriter.textFileWriterAndReader();
			} else {
				System.out.println("You are back to the main Menu.");
			}
		} catch (InputMismatchException e) {
			System.out.println("You are back to the main Menu.");
		}
	}

	
	public void amendment() { // the method is amending the user's personal info (used in the 'menu' method above)

		do {
			System.out.print("\nEnter:\n'1' to amend your name:\n'2' to amend your age\n'3' to amend "
					+ "your address\n'4' to amend the name of the course\n'5' back to the main Menu\nEnter your valid option here: ");

			do { // in case of entering String instead of int
				try {
					opt = scan.nextInt();
					scan.nextLine();
				} catch (InputMismatchException e) {
					System.out.println("Enter a valid positive number, not any other character.");
					scan.nextLine();
				}
			} while (!(opt > 0 || opt < 6)); // and also restrincting to a number within the Menu

			switch (opt) {
			case 1:
				System.out.print("Please, enter your new name: ");
				name = scan.nextLine();

				students.put(id, new StudentData(name, age, contactAddress, nameOfTheCourse));
				System.out.println("Your name has been successfully amended.");
				break;
			case 2:
				try { // in case of entering String instead of int
					System.out.print("Enter your actual age: ");
					age = scan.nextInt();
					students.put(id, new StudentData(name, age, contactAddress, nameOfTheCourse));
					System.out.println("Your age has been successfully amended.");
				} catch (InputMismatchException e) {
					System.out.println("There should be a positive number, not any other character.");
					scan.nextLine();
				}
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
		} while (!(opt == 5));
	}

	// --- For the subclass 'FileReaderAndWriter' ---

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static String students(int id, String name, int age, String contactAddress, String nameOfTheCourse) {
		return "\n\nYour current personal info:\nID: " + id + "\nName: " + name + "\nAge: " + age + "\nAddress: "
				+ contactAddress + "\nCourse: " + nameOfTheCourse;
	}
}
//-----------------------------------------------------------------------------------------------------------------------------



class FileReaderAndWriter extends CollectionInfoMenu {

	static private String text = CollectionInfoMenu.students(id, name, age, contactAddress, nameOfTheCourse);
	static private String linkToTheFile;

//------------------------------------ WRITE INTO A FILE -----------------------------------------
	public static void writeToFile(String text, String linkToTheFile) throws IOException {

		FileOutputStream fileOutputStream = null;

		try {
			fileOutputStream = new FileOutputStream(linkToTheFile); // link the output file;

			byte[] nameBytes = (text).getBytes(); // converting the text from the String into the bytes;
			fileOutputStream.write(nameBytes); // writes the text into the file as a text;
		} finally {
			if (fileOutputStream != null) {
				fileOutputStream.close();
			} // close the method 'write';
		}
	}

//-------------------------------------- READ A FILE ---------------------------------------------
	public static void readAndDisplayFile(String linkToTheFile) throws IOException {

		FileInputStream fileInputStream = null;

		try {
			fileInputStream = new FileInputStream(linkToTheFile); // new object to link to the file;

			int currentByte;
			System.out.println("\nthe content of the file:");
			while ((currentByte = fileInputStream.read()) != -1) { // iterate and read the whole file;
				System.out.print((char) currentByte);
			}
		} finally {
			if (fileInputStream != null) {
				fileInputStream.close();
			} // close the method 'read';
		}
	}

//-------------------------------------------------------------------------------------------------------
	public static void textFileWriterAndReader() { // the head method of the class

		Scanner scan = new Scanner(System.in);
		String option;

		do {
			System.out.print("\n\nPress '1' to write your personal info to the file in your PC\n"
					+ "Press '2' to read a file from your PC\nPress '3' to the main Menu\nEnter your option: ");
			option = scan.nextLine();

			switch (option) {

			case "1":
				System.out.print("Enter the link to your file in your PC: ");
				linkToTheFile = scan.nextLine();

				try {
					writeToFile(text, linkToTheFile); // call the method above;
					System.out.println("The info has been successfully written to the file.");
				} // report a successful written info;
				catch (IOException e) {
					System.err.println("An error occurred while writing to the file: " + e.getMessage());
				} // if Error;
				break;

			case "2":
				System.out.print("Enter the link to your file: "); // Example:// //home//dci-student//Desktop//StudentsList.odt
				linkToTheFile = scan.nextLine();

				try {
					readAndDisplayFile(linkToTheFile);
				} // call the method above;
				catch (IOException e) {
					System.err.println("An error occurred while reading the file: " + e.getMessage());
				} // if Error;
				break;

			case "3":
				System.out.println("You are back to the main Menu.");
				break;

			default:
				System.out.println("Invalid choice.\n");
			}
		} while (!option.equals("3"));
	}
}