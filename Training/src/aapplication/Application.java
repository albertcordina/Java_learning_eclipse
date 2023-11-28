package aapplication;

import java.util.Scanner;

public class Application {
	static String name;
	static byte age;
	static byte lengthOfNotSupported;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("\nDear applicant, we are happy to help you with your application!"
				+ "\nFor a further review, we need some information from you."
				+ "\nIt won't take a long time.\n\nPlease, enter your name: ");
		name = getName(scanner);
		System.out.println("Thank you, " + name);

		System.out.print("\nWhat is your age?: ");
		age = getByteInput(scanner);

		System.out.print("Thank you.\n\nPlease, let us know how long (in years) you haven't been "
				+ "getting additional support from the government. If you are currently getting support, enter '0': ");
		lengthOfNotSupported = getByteInput(scanner);

		String status = getStatus(scanner);

		Student inStud = new Student();
		Worker inWork = new Worker();
		Unemployed inUnemployed = new Unemployed();

		if (status.equals("student")) {
			inStud.eligibility();
		} else if (status.equals("worker")) {
			inWork.eligibility();
		} else if (status.equals("unemployed")) {
			inUnemployed.eligibility();
		} else {
			System.out.println("Invalid status entered. Exiting program.");
		}

		scanner.close();
	}

	private static String getName(Scanner scanner) {
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

	protected static byte getByteInput(Scanner scanner) {
		try {
			while (!scanner.hasNextByte()) {
				System.out.print("Invalid input. Please enter your age: ");
				scanner.next(); // Consume the invalid input
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scanner.nextByte();
	}

	private static String getStatus(Scanner scanner) {
		String status;
		String[] validStatus = { "student", "worker", "unemployed" };

		do {
			System.out.print("\nPlease, enter your current status (student, worker, or unemployed): ");
			status = scanner.next().toLowerCase();
		} while (!isValidStatus(status, validStatus));

		return status;
	}

	private static boolean isValidStatus(String status, String[] validStatus) {
		for (String valid : validStatus) {
			if (valid.equals(status)) {
				return true;
			}
		}
		System.out.println("Invalid status entered. Please enter either 'student', 'worker', or 'unemployed'.");
		return false;
	}
}

class Student extends Application {
	void eligibility() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("\nPlease, enter your current grade (from '1' to '5'): ");
		byte grade = getByteInput(scanner);

		while (grade < 1 || grade > 5) {
			System.out.print("Please, enter a valid grade (1 to 5): ");
			grade = getByteInput(scanner);
		}

		System.out.print("Are you having an extra income besides the scholarship? (yes/not): ");
		String incomeStudent = scanner.next().toLowerCase();

		while (!incomeStudent.equals("yes") && !incomeStudent.equals("not")) {
			System.out.print("Please, enter 'yes' or 'not': ");
			incomeStudent = scanner.next().toLowerCase();
		}

		String outcome = (age > 65)
				? ", your age is over 65 years. Please apply to the '...' department for further support."
				: (lengthOfNotSupported < 2)
						? ", you have been supported during the last two years. Contact the '...' department for further support."
						: (grade > 3) ? ", your grade is higher than 3rd grade. Contact the following department."
								: (incomeStudent.equals("yes"))
										? ", you are having an additional income besides the scholarship. Contact the following department."
										: ", your application will be reviewed.";

		System.out.println("\nDear, " + name + outcome);
	}
}

class Worker extends Application {
	void eligibility() {
		Scanner scanner = new Scanner(System.in);

		System.out.print(
				"Thank you.\n\nPlease, enter your whole monthly income (including any income besides your salary): ");
		int income = getByteInput(scanner);

		String outcome = (age > 65)
				? ", your age is over 65 years. Please apply to the '...' department for further support."
				: (lengthOfNotSupported < 2)
						? ", you have been supported during the last two years. Contact the '...' department for further support."
						: (income > 2000)
								? ", your monthly income is over than 2000 Euros. Contact the following department ... "
								: ", your application will be reviewed.";

		System.out.println("\nDear, " + name + outcome);
	}
}

class Unemployed extends Application {
	void eligibility() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Thank you.\n\nPlease, if you have an additional monthly income "
				+ "(e.g., from your spouse, children allowance, etc.)\n\t\t\tEnter here: ");
		int income = getByteInput(scanner);

		String outcome = (age > 65)
				? ", your age is over 65 years. Please apply to the '...' department for further support."
				: (lengthOfNotSupported < 2)
						? ", you have been supported during the last two years. Contact the '...' department for further support."
						: (income > 2000)
								? ", your monthly income is over than 2000 Euros. Contact the following department ... "
								: ", your application will be reviewed.";

		System.out.println("\nDear, " + name + outcome);
	}
}
