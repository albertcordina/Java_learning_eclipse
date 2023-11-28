package aapplication;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println("Dear applicant, tank you contacting us, we are happy to help you with your application!");
		mainMenu();
	}

	public static void mainMenu() {

		Info collectionInfo = new Info();
		Registered registered = new Registered();
		Scanner scanner = new Scanner(System.in);
		int choice;

		do {
			System.out.println(
					"\n\tMenu:\n1. Start the application;\n2. Visit your personal profile;\n0. Exit the program;");

			try {
				System.out.print("Enter your choice: ");

				choice = scanner.nextInt();

				switch (choice) {
				case 1:
					collectionInfo.collection();
					break;
				case 2:
					registered.account();
					break;
				case 0:
					System.out.println("\nThank you for visiting us!");
					break;
				default:
					System.out.println("Invalid choice. Please enter a valid option.");
				}
			} catch (InputMismatchException e) {
				// Handle the exception when the user enters a non-integer value
				System.out.println("Invalid input. Please enter a valid option.");
				// Clear the scanner buffer
				scanner.next();
				// Set choice to a value that will loop again
				choice = -1;
			}
		} while (choice != 0);
		scanner.close();
	}
}

class Methods {

	// Takes only the letters from the Applicant's input
	public static String getAllLetters(Scanner scanner) {
		System.out.print("Please, enter your name: ");
		String input = scanner.nextLine();

		while (!isAllLetters(input.trim())) {
			System.out.print("Invalid input. Please enter only letters for your name: ");
			input = scanner.nextLine();

		}
		return input.trim();
	}

	private static boolean isAllLetters(String input) {
		return !input.isEmpty() && input.chars().allMatch(Character::isLetter);
	}

	// Takes a positive number from the Applicant
	public static int getPositiveInt(Scanner scanner) {
		int userInput = 0;
		do {
			try {
				System.out.print("Please, enter a positive valid number: ");
				userInput = scanner.nextInt();

				if (userInput <= 0) {
					System.out.println("Please, enter a positive number greater than 0.");
				}
			} catch (java.util.InputMismatchException e) { // Handle non-integer input
				System.out.println("Invalid input.");
				scanner.nextLine(); // Consume the invalid input to prevent an infinite loop
				userInput = 0; // Set userInput to 0 to continue the loop
			}
		} while (userInput <= 0);
		// At this point, userInput contains a valid positive integer
		return userInput;
	}

	// Takes 'yes' or 'not' response from the applicant
	public static String yesOrNot(Scanner scanner) {

		System.out.print("Please, enter 'yes' or 'not': ");
		String input = scanner.next().toLowerCase();

		while (!input.equals("yes") && !input.equals("not")) {
			System.out.print("Please, enter 'yes' or 'not': ");
			input = scanner.next().toLowerCase();
		}
		return input;
	}

	// Takes only the existed phone numbers which contain from 7 to 15 digits (including a country code)
	public static int getValidPhoneNumber(Scanner scanner) {

		while (true) {
			System.out.print("Enter a number with 7 to 15 digits: ");
			String userInput = scanner.nextLine();

			// Check if the input is a valid integer
			if (userInput.matches("\\d+")) {
				// Check if the number of digits is between 7 and 15 (inclusive)
				if (userInput.length() >= 7 && userInput.length() <= 15) {
					return Integer.parseInt(userInput);
				} else {
					System.out.println("Number must have 7 to 15 digits. Try again.");
				}
			} else {
				System.out.println("Invalid input. Please enter a valid number.");
			}
		}
	}

	/*
	 * Takes the password from the Applicant corresponding to the requirments (i.e.
	 * at least 12 characters long and has the combination of at least one uppercase
	 * letter, lowercase letter, number, and a symbol.
	 */
	public static String getValidPassword(Scanner scanner) { // Repeatedly prompts the user until a valid password is entered.

		while (true) {
			System.out.println(
					"Create a password with at least 12 characters, including:\n- At least one uppercase letter"
							+ "\n- At least one lowercase letter\n- At least one number\n- At least one symbol");

			System.out.print("Enter your password: ");
			String userPassword = scanner.nextLine();

			if (isValidPassword(userPassword)) { // Check if the password meets the criteria
				return userPassword;
			} else {
				System.out.println("Invalid password. Please try again.");
			}
		}
	}

	public static boolean isValidPassword(String password) { // Checks the validation of the entered password

		// Check if the password is at least 12 characters long
		if (password.length() < 12) {
			return false;
		}

		// Check for at least one uppercase letter, lowercase letter, number, and symbol
		boolean hasUppercase = false;
		boolean hasLowercase = false;
		boolean hasNumber = false;
		boolean hasSymbol = false;

		for (char ch : password.toCharArray()) {
			if (Character.isUpperCase(ch)) {
				hasUppercase = true;
			} else if (Character.isLowerCase(ch)) {
				hasLowercase = true;
			} else if (Character.isDigit(ch)) {
				hasNumber = true;
			} else {
				// You can customize the symbols according to your requirements
				String symbols = "!@#$%^&*()-_+=<>?";
				if (symbols.indexOf(ch) != -1) {
					hasSymbol = true;
				}
			}
		}
		// Return true if all criteria are met
		return hasUppercase && hasLowercase && hasNumber && hasSymbol;
	}

	public void createAccount() {
		Scanner scanner = new Scanner(System.in);

		// Collect the contact phone number of the Applicant
		System.out.println("Dear " + Info.name
				+ ",\nWe are happy to inform you that your application will be reviewed by our specialized team.\n"
				+ "In order to create your personal account, we need to have your personal contact phone number.");
		Info.phoneNumber = getValidPhoneNumber(scanner);

		if (Info.list.containsKey(Info.phoneNumber)) { // If the phone number is in the list, send the Applicant to the Class Registered
			System.out.println("It looks that you are already registered.");
			Registered.account();
		}

		// Create the password
		System.out.println("Thank you!\nPlease, create your password.");
		Info.password = getValidPassword(scanner);

		Info.list.put(Info.phoneNumber, new Info(Info.name, Info.age, Info.password, Info.status)); // placing the info into the 'list'

		System.out.println(Info.name
				+ ", thank you for entering your personal details.\nYour account with us has been successfully created."
				+ "\nPlease, from time to time, check the status of your application!");
		Main.mainMenu();
	}
}

class Info extends Methods {

	static String name;
	static int age;
	static String password;
	static String status;
	static int phoneNumber;
	static int monthlySupport;
	static int monthlyPension;
	static String yesOrNot;

	static Scanner scanner = new Scanner(System.in);
	static Map<Integer, Info> list = new HashMap<>();

	public Info(String name, int age, String password, String status) { // constructor
		this.name = name;
		this.age = age;
		this.password = password;
		this.status = status;
	}

	public Info() { }

	public String toString() {
		return "\nYour name: " + name + "\nYour age: " + age + "\nThe password to your account: " + password
				+ "\nThe status of the application: " + status;
	} // toString method
	
	 public static String getName() { return name; }
	 
	 public static void setName(String name) { Info.name = name; }
	 
	 public static int getAge() { return age; }
	 
	 public static void setAge(int age) { Info.age = age; }
	  
	 public static String getPassword() { return password; }
	  
	 public static void setPassword(String password) { Info.password = password; }
	  
	 public static String getStatus() { return status; }
	  
	 public static void setStatus(String status) { Info.status = status; }
	 
	 public static int getPhoneNumber() { return phoneNumber; }
	 

	public static void collection() {

		System.out.println(
				"\nThank you!\nFor a further review, we need some information from you.\nIt won't take a long time.\n");

		// collect the basic personal information from the Applicant (i.e. name, age)
		name = getAllLetters(scanner);
		System.out.println("\nHello, " + name + "!");

		System.out.print("\nWhat is your age?\n");
		age = getPositiveInt(scanner);

		// Ask the Applicant about a current support
		System.out.print("\nAre you getting a current support from the government?");
		yesOrNot = yesOrNot(scanner);

		if (yesOrNot.equals("yes")) {
			System.out
					.print("\nThank you!\nWhat is the monthly amount you are currently getting from the government?\n");
			monthlySupport = getPositiveInt(scanner);

			if (monthlySupport >= 2000) {
				System.out.println("\n\tDear " + name + ",\nThe amount you are currently getting from "
						+ "the governmen is sufficient and isn't applicable for the application.\nThank you for visiting us!");
				System.exit(0);
			}
		}

		// Ask the Applicant who are over 67 years old about the pension
		if (age >= 67) {
			System.out.print(
					"\nAccording to your age, you are eligible for getting a pension.\nHave you applied for your pension?");
			yesOrNot = yesOrNot(scanner);
		}

		if (yesOrNot.equals("yes")) {
			System.out.print("\nThank you!\nWhat is the monthly amount of your pension?\n");
			monthlyPension = getPositiveInt(scanner);

			if (monthlyPension + monthlySupport >= 2000) { // we check the Applicant's income altogether
				System.out.println("\n\tDear " + name + ",\nThe amount of your income is considered as sufficient and "
						+ "it fully covers the amount stipulated within this support program.\nThank you for visiting us!");
				System.exit(0);
			}
		}
		if (yesOrNot.equals("not")) {
			System.out.println("\n\tDear " + name
					+ ",\nAccording to the regulation of the social service support you are "
					+ "eligible for the retirement pension. \nTherefore, we advise you fist to contact your local social servise for "
					+ "clarification of this subject and then contact us again.\nThank you for visiting us!");
			System.exit(0);
		}

		// The Occupational status of the Applicant
		Retired retired = new Retired();
		Student student = new Student();
		Employed employed = new Employed();
		Unemployed unemployed = new Unemployed();

		int option;

		do {
			System.out.println("\nPlease, enter you current occupational status:"
					+ "\n1. Student;\n2. Employed;\n3. Unemployed;\n4. Retired;\n5. Back to the main Menu;\n0. Exit the program;");

			try {
				System.out.print("Enter your choice: ");

				option = scanner.nextInt();

				switch (option) {
				case 1:
					student.eligibility();
					break;
				case 2:
					employed.eligibility();
					break;
				case 3:
					unemployed.eligibility();
					break;
				case 4:
					retired.eligiblility();
					break;
				case 5:
					Main.mainMenu();
					break;
				case 0:
					System.out.println("Thank you for visiting us!");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid choice. Please enter a valid option.");
				}
			} catch (InputMismatchException e) {
				// Handle the exception when the user enters a non-integer value
				System.out.println("Invalid input. Please enter a valid option.");
				// Clear the scanner buffer
				scanner.next();
				// Set choice to a value that will loop again
				option = -1;
			}
		} while (option != 0);
	}
}

class Student extends Info {

	static int scholarshipIncome;
	int extraIncome;

	void eligibility() {

		System.out.println("Are you getting your scholarship as a student?");
		yesOrNot = yesOrNot(scanner);

		if (yesOrNot.equals("yes")) {
			System.out.println("\nPlease, enter the amount of your scholarship.");
			scholarshipIncome = getPositiveInt(scanner);
		}

		System.out.println("Are you having an extra monthly income?");
		yesOrNot = yesOrNot(scanner);

		if (yesOrNot.equals("yes")) {
			System.out.println("\nPlease, enter the amount of your extra income.");
			extraIncome = getPositiveInt(scanner);
		}

		if (scholarshipIncome + extraIncome + monthlySupport >= 2000) { // we check the applicant's income altogether
			System.out.println("\n\tDear " + name + ",\nThe amount of your income is considered as sufficient and "
					+ "it fully covers the amount stipulated within this support program.\nThank you for visiting us!");
			System.exit(0);
		}

		createAccount(); // If the Applicant is eligible reffer to 'createAccount'
	}
}

class Employed extends Info {

	int salaryIncome;
	int extraIncome;

	void eligibility() {

		System.out.print("Please, enter your monthly salary.");
		salaryIncome = getPositiveInt(scanner);

		System.out.println("Are you having an extra monthly income (besides the salary)?");
		yesOrNot = yesOrNot(scanner);

		if (yesOrNot.equals("yes")) {
			System.out.println("\nPlease, enter the amount of your extra income.");
			extraIncome = getPositiveInt(scanner);
		}

		if (salaryIncome + extraIncome + monthlySupport >= 2000) { // we check the applicant's income altogether
			System.out.println("\n\tDear " + name + ",\nThe amount of your income is considered as sufficient and "
					+ "it fully covers the amount stipulated within this support program.\nThank you for visiting us!");
			System.exit(0);
		}
		createAccount(); // If the Applicant is eligible reffer to 'createAccount'

	}
}

class Unemployed extends Info {

	int unemployementBenefits;
	int extraIncome;

	void eligibility() {

		System.out.println("Are you getting the monthly unemployement benefits?");
		yesOrNot = yesOrNot(scanner);

		if (yesOrNot.equals("yes")) {
			System.out.println("\nPlease, enter the amount of the monthly unemployment benefits.");
			unemployementBenefits = getPositiveInt(scanner);
		}
		if (yesOrNot.equals("not")) {
			System.out.println("\n\tDear " + name
					+ ",\nAccording to the regulation of the social service support you are "
					+ "eligible for the unemployment benefits. \nTherefore, we advise you fist to contact your local unemployement"
					+ " servise for clarification of this subject and then contact us again.\nThank you for visiting us!");
			System.exit(0);
		}

		System.out.println("Are you having an extra monthly income?");
		yesOrNot = yesOrNot(scanner);

		if (yesOrNot.equals("yes")) {
			System.out.println("\nPlease, enter the amount of your extra income.");
			extraIncome = getPositiveInt(scanner);
		}

		if (unemployementBenefits + extraIncome + monthlySupport >= 2000) { // we check the applicant's income
																			// altogether
			System.out.println("\n\tDear " + name + ",\nThe amount of your income is considered as sufficient and "
					+ "it fully covers the amount stipulated within this support program.\nThank you for visiting us!");
			System.exit(0);
		}
		createAccount(); // If the Applicant is eligible reffer to 'createAccount'
	}
}

class Retired extends Info {

	int pensionIncome;
	int extraIncome;

	void eligiblility() {

		System.out.print("Please, enter the amount of your monthly pension.");
		pensionIncome = getPositiveInt(scanner);

		System.out.println("Are you having an extra monthly income (besides the pension)?");
		yesOrNot = yesOrNot(scanner);

		if (yesOrNot.equals("yes")) {
			System.out.println("\nPlease, enter the amount of your extra income.");
			extraIncome = getPositiveInt(scanner);
		}

		if (pensionIncome + extraIncome + monthlySupport >= 2000) { // we check the applicant's income altogether
			System.out.println("\n\tDear " + name + ",\nThe amount of your income is considered as sufficient and "
					+ "it fully covers the amount stipulated within this support program.\nThank you for visiting us!");
			System.exit(0);
		}

		createAccount(); // If the Applicant is eligible reffer to 'createAccount'
	}
}

class Registered extends Info {
	
	static void account() {

		int attempts = 3;
		
		System.out.println("In order to enter to your personal account we need your personal/ registered contact phone number.");
		phoneNumber = getValidPhoneNumber(scanner);
				
		if (!list.containsKey(phoneNumber)) {
			System.out.println("It looks like you are not registered yet. You are back to the main Menu.");
			Main.mainMenu();
		}
		
		if (list.containsKey(phoneNumber)) {
			
			System.out.println("\nThank you.\nPlease, enter the password. You have the 3 attempts.");
			
			while (attempts > 0) {
				System.out.print("Enter your password: ");

	            // Check if the input is a valid password
	            if (scanner.hasNextLine()) {
	                String userGuess = scanner.nextLine();

	                // Check if the input is correct
	                if (userGuess == list.get(phoneNumber).getPassword())  {
	                    System.out.println("Thank you for the successful input!");
	                    return;
	                } else {
	                    System.out.println("Incorrect input. Try again.");
	                    attempts--;
	                    System.out.println("Attempts left: " + attempts);
	                }
	            } else {
	                System.out.println("Invalid input.");
	                scanner.next(); // Consume the invalid input to avoid an infinite loop
	            }
	        }

	        System.out.println("Sorry, you've run out of attempts.");
	    }
	}
}
