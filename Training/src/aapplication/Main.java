package aapplication;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// The Welcome message
		System.out.println("Dear applicant, tank you contacting us,\nwe are happy to help you with your application!");
		Menu(); // Call the method 'Menu' below
	}

	public static void Menu() { // Starts and Runs the whole project

		Info info = new Info();
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
					info.collection(); // Calls the method 'collection' in the Class 'Info'
					break;
				case 2: // For those, who are already registered
					registered.accessAccount(); // Calls the method 'accessAccount' in the Class 'Registered'
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
		System.exit(0);
	}
}

class Methods { // Contains almost all methods of the project

	// Method 'getAllLetters': Takes only the letters from the Applicant's input
	public static String getAllLetters(Scanner scanner) {

		while (true) {
			System.out.print("Please, enter your name: ");

			try {
				/*
				 * the input logic to use scanner.next() instead of scanner.nextLine(): i.e. to
				 * ensure that the newline character does not interfere with subsequent inputs.
				 */
				String input = scanner.next();
				if (isAllLetters(input.trim())) {
					// trim method is used to remove leading and trailing whitespace from the input.
					return input.trim();
				} else {
					System.out.println("Invalid input. Please enter only letters for your name.");
				}
			} catch (Exception e) {
				System.out.println("An error occurred. Please try again.");
			} finally {
				scanner.nextLine(); // Clear the buffer
			}
		}
	}

	/*
	 * the isAllLetters method checks whether the input consists only of letters
	 * (affiliated with the 'getAllLetters' above).
	 */
	private static boolean isAllLetters(String input) {
		return !input.isEmpty() && input.chars().allMatch(Character::isLetter);
	}

	// Takes a positive number from the Applicant
	public static int getPositiveInt(Scanner scanner) {

		int userInput = 0;

		do {
			try {
				System.out.print("Please, enter: ");
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
	public static String yesOrNo(Scanner scanner) {

		System.out.print("Please, enter 'yes' or 'no': ");
		String input = scanner.next().toLowerCase();

		while (!input.equals("yes") && !input.equals("no")) {
			System.out.print("Please, enter 'yes' or 'no': ");
			input = scanner.next().toLowerCase();
		}
		return input;
	}

	/*
	 * Takes only the existed phone numbers which contain from 7 to 15 digits
	 * (including a country code)
	 */
	public static int getValidPhoneNumber(Scanner scanner) {

		int validPhoneNumber;

		do {
			System.out.print("Enter a number with 7 to 15 digits: ");

			try {
				/*
				 * the input logic to use scanner.next() instead of scanner.nextLine(): i.e.
				 * to ensure that the newline character does not interfere with subsequent inputs.
				 */
				validPhoneNumber = Integer.parseInt(scanner.next());
				// Check if the number of digits is between 7 and 15 (inclusive)
				if (String.valueOf(validPhoneNumber).length() >= 7 && String.valueOf(validPhoneNumber).length() <= 15) {
					break; // Exit the loop if the input is valid
				} else {
					System.out.println("Number must have 7 to 15 digits. Try again.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a valid number.");
				// Clear the buffer
				scanner.nextLine();
			}
		} while (true);

		return validPhoneNumber;
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
			/*
			 * the password input logic to use scanner.next() instead of scanner.nextLine():
			 * i.e. to ensure that the newline character does not interfere with subsequent inputs.
			 */
			try {
				String userPassword = scanner.next();
				if (isValidPassword(userPassword)) {
					return userPassword;
				} else {
					System.out.println("Invalid password. Please try again.\n");
				}
			} catch (Exception e) {
				System.out.println("An error occurred. Please try again.");
			} finally {
				scanner.nextLine(); // Clear the buffer
			}
		}
	}

	/*
	 * Checks the validation of the entered password (affiliated with the
	 * 'getValidPassword' above)
	 */
	public static boolean isValidPassword(String password) {

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
			if (Character.isUpperCase(ch)) { // Check if the password contains an UpperCase
				hasUppercase = true;
			} else if (Character.isLowerCase(ch)) { // Check if the password contains a LowerCase
				hasLowercase = true;
			} else if (Character.isDigit(ch)) { // Check if the password contains a Digit
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

	/*
	 * The method 'createAccount': Ask the Applicant for the contact phone number
	 * and the password and create the profile
	 */
	public static void createAccount(Scanner scanner) {

		// Collect the contact phone number of the Applicant
		System.out.println("\nDear " + Info.name
				+ ",\nWe are happy to inform you that your application will be reviewed by our specialized team.\n"
				+ "In order to create your personal account, we need to have your personal contact phone number.");
		Info.phoneNumber = getValidPhoneNumber(scanner);

		// If the phone number is in the list, send the Applicant to the Class Registered
		if (Info.profiles.containsKey(Info.phoneNumber)) {
			System.out.println("It looks that you are already registered.");
			Registered.accessAccount();
		}
		// Create the password
		System.out.println("\nThank you!\nPlease, create your password.");
		Info.password = getValidPassword(scanner);

		// Place the collected info into the 'profiles'
		Info.profiles.put(Info.phoneNumber, new Info(Info.name, Info.age, Info.occupation, Info.overallIncome,
				Info.password, Info.statusOfApplication));

		System.out.println("\n\nDear " + Info.name
				+ ",\n\nThank you for entering your personal details. Your account with us has been successfully created."
				+ "\nPlease, use your phone number as the login to your personal profile. We also advise you to check the status of "
				+ "your application and add any required info\n(e.g. the results of Social Security department regarding your "
				+ "unemployment benefits/ pension, e.t.c.) in the section: 'The status of the application'.\n\nThe Team of the 'Support Program'.");
	}

	// The method 'enterPassword': Requests the password from the Applicant with the 3 attempts
	public static void enterPassword(Scanner scanner) {

		int maxAttempts = 3; // the set 3 attempts

		System.out.println("You have 3 attempts:");

		for (int attempt = 1; attempt <= maxAttempts; attempt++) {
			System.out.print("Attempt " + attempt + ": Enter your password: ");

			try {
				/*
				 * the password input logic to use scanner.next() instead of scanner.nextLine():
				 * i.e. to ensure that the newline character does not interfere with subsequent inputs.
				 */
				String userGuess = scanner.next();
				if (userGuess.equals(Info.profiles.get(Info.phoneNumber).getPassword())) {
					System.out.println("Thank you!");
					Registered.manageAccount();
					return;
				} else {
					System.out.println("Incorrect input. Try again.");
				}
			} catch (Exception e) {
				System.out.println("An error occurred. Please try again.");
			} finally {
				scanner.nextLine(); // Clear the buffer
			}
		}

		System.out.println("Sorry, you've run out of attempts.");
	}

	// The method 'checkExtraAndOverallIncome' determines if the Applicant has a sufficient income
	public static void checkExtraAndOverallIncome(Scanner scanner) {

		// Check if the Applicant is having an extra income
		System.out.println("\nAre you having an extra monthly income (besides the pension)?");
		Info.yesOrNo = yesOrNo(scanner);

		// If yes, Collect the amount of the exta monthly income
		if (Info.yesOrNo.equals("yes")) {
			System.out.println("\nPlease, enter the amount of your extra income.");
			Info.monthlyExtraIncome = getPositiveInt(scanner);
		}
		/*
		 * Check if the applicant's overall income reaches the 2000 Euros: if the amount
		 * exceeds the 2000 Euros -> Inform the Applicant about it; if the amount is
		 * below the 2000 Euros -> Call the method 'createAccount' in the superclass
		 * 'Methods'
		 */
		Info.overallIncome = Info.monthlySupport + Info.monthlyPension + Info.monthlyExtraIncome
				+ Info.monthlyScholarshipIncome + Info.monthlySalaryIncome + Info.monthlyUnemployementBenefits;
		if (Info.overallIncome >= 2000) { // we check the applicant's income altogether
			System.out.println("\n\tDear " + Info.name + ",\nThe amount of your income is considered as sufficient and "
					+ "it fully covers the amount which is stipulated within this support program.\nThank you for visiting us!");
			System.exit(0);
		}

		// Call the method 'createAccount' If the Applicant is eligible reffer to 'createAccount'
		createAccount(scanner);
	}
}

class Info extends Methods {

	// The personal information:
	protected static String name;
	protected static int age;
	protected static String password;
	protected static String statusOfApplication;
	protected static String occupation;
	protected static int phoneNumber;
    
    // The Income information:
	protected static int monthlySupport;
	protected static int monthlyPension;
	protected static int monthlyExtraIncome;
	protected static int monthlyScholarshipIncome;
	protected static int monthlySalaryIncome;
	protected static int monthlyUnemployementBenefits;

	protected static int overallIncome;
	
	// The 'yes' or 'no' option
    protected static String yesOrNo;

	

	static Scanner scanner = new Scanner(System.in);
	static Map<Integer, Info> profiles = new HashMap<>();

	// The constructor for the HashMap 'profiles'
	public Info(String name, int age, String occupation, int overallIncome, String password,
			String statusOfApplication) {
		this.name = name;
		this.age = age;
		this.occupation = occupation;
		this.overallIncome = overallIncome;
		this.password = password;
		this.statusOfApplication = statusOfApplication;
	}

	public Info() {
	} // The constructor for sharing its Info with other Classes

	public String toString() { // toString method for printing out the profile(s) of the HashMap 'profiles'
		return "\nYour name: " + name + "\nYour age: " + age + "\nYour current occupation: " + occupation
				+ "\nYour overall income: " + overallIncome + "\nThe password to your account: " + password
				+ "\nThe status of your application: " + statusOfApplication;
	}

	// Getters and Setters to operate with the values of the variables

	public String getName() {
		return name;
	}

	public void setName(String name) {
		Info.name = name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		Info.occupation = occupation;
	}

	public int getOverallIncome() {
		return overallIncome;
	}

	public void setOverallIncome(int overallIncome) {
		Info.overallIncome = overallIncome;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		Info.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		Info.password = password;
	}

	public String getStatus() {
		return statusOfApplication;
	}

	public void setStatus(String status) {
		Info.statusOfApplication = status;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	/*
	 * The method 'collection' collects the basic information from the Applicant:
	 * 
	 * 1. Name; 
	 * 2. Age; 
	 * 3. If the Applicant is getting a current support from the government; 
	 * 4. Asks about a government pention (if the Applicant is over 67 years old); 
	 * 5. Asks about the Occupational status of the Applicant (i.e.
	 *    student, employed, unemployed, retired) and calls the corresponding methods
	 *    of the corresponding Classes;
	 */
	public static void collection() {

		System.out.println("\nThank you!\nFor a further review, we need some information from you.\n");

		// collect the basic personal information from the Applicant (i.e. name, age)
		name = getAllLetters(scanner);
		System.out.println("\nHello, " + name + "!");

		System.out.print("\nWhat is your age?\n");
		age = getPositiveInt(scanner);

		// Ask the Applicant about a current support
		System.out.println("\nAre you getting any other current support from the government?");
		yesOrNo = yesOrNo(scanner);

		if (yesOrNo.equals("yes")) {
			System.out
					.println("\nThank you!\nWhat is the monthly amount you are currently getting from the government?");
			monthlySupport = getPositiveInt(scanner);

			if (monthlySupport >= 2000) {
				System.out.println("\n\tDear " + name + ",\nThe amount you are currently getting from "
						+ "the governmen is sufficient and isn't applicable for the application.\nThank you for visiting us!");
				System.exit(0);
			}
		}

		// Ask the Applicant who are over 67 years old about the pension
		Retired retired = new Retired(); // create an instance of the subclass 'Retired' also for the Menu below
		if (age >= 67) {
			System.out.println(
					"\nAccording to your age, you are eligible for getting a pension.\nHave you applied for your pension?");
			yesOrNo = yesOrNo(scanner);

			// If the Applicant is on pension, call the method 'eligibility' in the subclass
			// 'Retired'
			if (yesOrNo.equals("yes")) {
				retired.eligibility();

				/*
				 * If the Applicant has not applied for the pension,  
				 * reffer the Applicant to the appropriate Social Services.
				 */
			} else {
				System.out.println("\n\tDear " + name
						+ ",\nAccording to your age and the regulation of the social service support you are "
						+ "eligible for the retirement pension. \nTherefore, we advise you to contact your local social servise for "
						+ "clarification of this subject and then inform us about the outcome.\n");

				// Check if the Applicant is having an extra income
				System.out.println(
						"Are you having an extra monthly income (e.g. from your part or full time job, e.t.c.)?");
				yesOrNo = yesOrNo(scanner);

				// If yes, Collect the amount of the exta monthly income
				if (yesOrNo.equals("yes")) {
					System.out.println("\nPlease, enter the amount of your extra income.");
					monthlyExtraIncome = getPositiveInt(scanner);
				}

				/*
				 * Call the method 'createAccount' If the Applicant 
				 * is eligible reffer to 'createAccount'
				 */
				createAccount(scanner);
				/*
				 * Place the 'occupation' of the Applicant in the 
				 * already created profile via the 'createAccount' method
				 */
				profiles.put(phoneNumber, new Info(name, age, "Retired (needs outcome from Social Service)",
						overallIncome, password, statusOfApplication));
				Main.Menu(); // After gathering the info and creating the profile, send the Applicant to the
								// main Menu

			}
		}
		// Instances of the appropriate Classes for the Menu below
		Student student = new Student();
		Employed employed = new Employed();
		Unemployed unemployed = new Unemployed();

		// The Menu of identifying the Occupational status of the Applicant
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
					retired.eligibility();
					break;
				case 5:
					Main.Menu();
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

	// The method 'eligibility': Checks if the Applicant is eligible for the application
	void eligibility() {

		// The collection of the info
		System.out.println("\nAre you getting your scholarship as a student?");
		yesOrNo = yesOrNo(scanner);

		// Check if the Applicant is getting the scoolarship
		if (yesOrNo.equals("yes")) {
			System.out.println("\nPlease, enter the monthly amount of your scholarship.");
			monthlyScholarshipIncome = getPositiveInt(scanner);
		}

		// Check an extra income and the determine if the Applicant has a sufficient overallIncome
		checkExtraAndOverallIncome(scanner);

		// Place the 'occupation' of the Applicant in the already created profile via the 'createAccount' method
		profiles.put(phoneNumber, new Info(name, age, "Student", overallIncome, password, statusOfApplication));
		Main.Menu(); // After gathering the info and creating the profile, send the Applicant to the main Menu
	}
}

class Employed extends Info {

	// The method 'eligibility': Checks if the Applicant is eligible for the application
	void eligibility() {

		// Ask the Applicant about the monthly salary
		System.out.println("What is your monthly salary?");
		monthlySalaryIncome = getPositiveInt(scanner);

		// Check an extra income and the determine if the Applicant has a sufficient overallIncome
		checkExtraAndOverallIncome(scanner);

		// Place the 'occupation' of the Applicant in the already created profile via
		// the 'createAccount' method
		profiles.put(phoneNumber, new Info(name, age, "Employed", overallIncome, password, statusOfApplication));
		Main.Menu(); // After gathering the info and creating the profile, send the Applicant to the main Menu

	}
}

class Unemployed extends Info {

	// The method 'eligibility': Checks if the Applicant is eligible for the application
	void eligibility() {

		// Ask the Applicant about the monthly unemployment benefits
		System.out.println("\nAre you getting the monthly unemployement benefits?");
		yesOrNo = yesOrNo(scanner);

		// Collect the amount of the monthly unemployment benefits
		if (yesOrNo.equals("yes")) {
			System.out.println("\nPlease, enter the amount of the monthly unemployment benefits.");
			monthlyUnemployementBenefits = getPositiveInt(scanner);
		}

		/*
		 * If the Applicant has not applied for the unemplyment benefits yet, reffer the Applicant
		 * to the appropriate Social Services, ask about an Extra income and determine the eligibility,
		 * and place a special Note: "Unemployed (needs info from the Unemployment Service.)" 
		 * in the profile, i.e. the 'occupation'.
		 */
		if (yesOrNo.equals("no")) {
			System.out.println("\n" + name + ", according to the regulation of the social service support you are "
					+ "eligible for the unemployment benefits. \nTherefore, we advise you also to contact your local unemployement"
					+ " servise for clarification of this subject and then inform us about the outcome.");
			
			// Check if the Applicant is having an extra income
			System.out.println("\nAre you having an extra monthly income (besides the pension)?");
			Info.yesOrNo = yesOrNo(scanner);

			// If yes, Collect the amount of the exta monthly income
			if (Info.yesOrNo.equals("yes")) {
				System.out.println("\nPlease, enter the amount of your extra income.");
				Info.monthlyExtraIncome = getPositiveInt(scanner);
			}
			/*
			 * Check if the applicant's overall income reaches the 2000 Euros: if the amount
			 * exceeds the 2000 Euros -> Inform the Applicant about it; if the amount is
			 * below the 2000 Euros -> Call the method 'createAccount' in the superclass
			 * 'Methods'
			 */
			Info.overallIncome = Info.monthlySupport + Info.monthlyExtraIncome + Info.monthlyUnemployementBenefits;
			if (Info.overallIncome >= 2000) { // we check the applicant's income altogether
				System.out.println("\n\tDear " + Info.name + ",\nThe amount of your income is considered as sufficient and "
						+ "it fully covers the amount which is stipulated within this support program.\nThank you for visiting us!");
				System.exit(0);
			}

			// Call the method 'createAccount' If the Applicant is eligible reffer to 'createAccount'
			createAccount(scanner);
			// Place the 'occupation' of the Applicant with the special NOTE () in the already created profile via the 'createAccount' method
			profiles.put(phoneNumber, new Info(name, age, "Unemployed (needs info from the Unemployment Service.)", overallIncome, password, statusOfApplication));
			Main.Menu(); // After gathering the info and creating the profile, send the Applicant to the main Menu
			
		}

		/*
		 * For those who get the unempoyment benefits:
		 * Check an extra income and the determine if the Applicant has a sufficient overallIncome
		 */
		checkExtraAndOverallIncome(scanner);

		// Place the 'occupation' of the Applicant in the already created profile via the 'createAccount' method
		profiles.put(phoneNumber, new Info(name, age, "Unemployed", overallIncome, password, statusOfApplication));
		Main.Menu(); // After gathering the info and creating the profile, send the Applicant to the main Menu

	}
}

class Retired extends Info {

	// The method 'eligibility': Checks if the Applicant is eligible for the application
	void eligibility() {

		System.out.println("\nPlease, enter the amount of your monthly pension.");
		monthlyPension = getPositiveInt(scanner);

		// Check an extra income and the determine if the Applicant has a sufficient overallIncome
		checkExtraAndOverallIncome(scanner);

		// Place the 'occupation' of the Applicant in the already created profile via the 'createAccount' method
		profiles.put(phoneNumber, new Info(name, age, "Retired", overallIncome, password, statusOfApplication));
		Main.Menu(); // After gathering the info and creating the profile, send the Applicant to the main Menu

	}
}

class Registered extends Info {

	/*
	 * The method 'accessAccount': Ask for the contact phone number and the password
	 * of the already registered Applicant
	 */
	static void accessAccount() {

		System.out.println( // Ask the Applicant to enter the personal contact phone number, i.e. the 'key'
				"\nIn order to enter to your personal account we need your personal/ registered contact phone number.");
		phoneNumber = getPositiveInt(scanner);

		if (profiles.containsKey(phoneNumber)) {
			System.out.println("\nPlease, enter your password.");
			enterPassword(scanner);
		} else { // If the entered contact phone number is not in the list, send the Applicant to
					// the main Menue
			System.out.println("It looks like you are not registered yet. You are back to the main Menu.\n");
			Main.Menu();
		}
	}

	/*
	 * The method 'manageAccount': The Menu of the profile to manage it (i.e. the
	 * amendment of the personal info and check the status of the application)
	 */
	static void manageAccount() {

		System.out.println(name + ", welcome to your account!\n");
		int choice;

		do {
			System.out.println(
					"\n\tMenu:\n1. See and manage the current status of the application;\n2. Amend the name;\n3. Amend the age;"
							+ "\n4. Amend the contact phone number;\n5. Amend the password;\n6. Delete the profile;\n7. Back to the main Menu;"
							+ "\n0. Exit the program;");

			try {
				System.out.print("Enter your choice: ");

				choice = scanner.nextInt();

				switch (choice) {
				case 1:
					
					do {
						System.out.println(
								"\n\tMenu:\n1. See the current status of the application;\n2. Edit the status;"
								+ "\n3. Back to the account Menu;\n0. Exit the program;");

						try {
							System.out.print("Enter your choice: ");

							choice = scanner.nextInt();
							scanner.nextLine(); // Consume the newline character

							switch (choice) {
							case 1:
								System.out.println("The current status:\n" + profiles.get(phoneNumber).getStatus());
                                break;
							case 2:
								System.out.print("Enter your text: ");
								String newStatus = scanner.nextLine();
								profiles.get(phoneNumber).setStatus(newStatus);
								System.out.println("\nThe status has been updated successfully!");
								break;
							case 3:
								manageAccount();
								break;
							case 0:
								System.out.println("Thank you for your session!");
								System.exit(0);
								break;
							default:
								System.out.println("Invalid choice. Please enter a valid option.");
								break;
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
					
					break;
				case 2:
					System.out.println("\nEnter your new name.");
					String newName = getAllLetters(scanner);
					profiles.get(phoneNumber).setName(newName);
					System.out.println(newName + ", your profile has been successfully updated.");
					System.out.println("Your contact phone number: " + phoneNumber + "\n" + profiles.get(phoneNumber));
					break;
				case 3:
					System.out.println("\nEnter your age.");
					int newAge = getPositiveInt(scanner);
					profiles.get(phoneNumber).setAge(newAge);
					System.out.println(name + ", your profile has been successfully updated.");
					System.out.println("Your contact phone number: " + phoneNumber + "\n" + profiles.get(phoneNumber));
					break;
				case 4:
					System.out.println("\nEnter your new personal phone number.");
					int newPhoneNumber = getValidPhoneNumber(scanner);

					if (profiles.containsKey(newPhoneNumber)) {
						System.out.println("The phone number you entered is not valid for the amendment.");
						manageAccount();
					}

					profiles.put(newPhoneNumber,
							new Info(profiles.get(phoneNumber).getName(), profiles.get(phoneNumber).getAge(),
									profiles.get(phoneNumber).getOccupation(),
									profiles.get(phoneNumber).getOverallIncome(),
									profiles.get(phoneNumber).getPassword(), profiles.get(phoneNumber).getStatus()));

					profiles.remove(phoneNumber); // remove the profile with the old key, i.e., the old phone number
					System.out.println(name + ", your profile has been successfully updated.");
					System.out.println("\nYour contact phone number: " + newPhoneNumber + profiles.get(newPhoneNumber)); // print
																															// //
																															// profile
					break;
				case 5:
					System.out.println("\nEnter your new password.");
					String newPassword = getValidPassword(scanner);
					profiles.get(phoneNumber).setPassword(newPassword);
					System.out.println(name + ", your profile has been successfully updated.");
					System.out.println(profiles.get(phoneNumber));
					Main.Menu();
					break;
				case 6:
					System.out.println(name + ", your profile has been removed.");
					profiles.remove(phoneNumber);
					Main.Menu();
					break;
				case 7:
					Main.Menu();
					break;
				case 0:
					System.out.println("Thank you for your session!");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid choice. Please enter a valid option.");
					break;
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
	}
}
