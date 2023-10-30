package project;

import java.util.Scanner;

public class Application {
	public static String name; // we store the important info taken from the applicant
	public static byte age; // for the further use/ analise by the 'children' classes;
	public static byte lengthOfNotSupported;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("\nDear applicant, we are happy to help you with your application!"
				+ "\nFor a further review we need some information from you"
				+ "\n\t\tIt won't take a long time\n\nPlease, enter your name? ");

		name = scanner.nextLine();
		System.out.println("Thank you, " + name);

		System.out.print("\nWhat is your age?: ");
		age = scanner.nextByte();

		System.out.print("Thank you\n\nPlease, let us know how long (in years) you haven't "
				+ "been \ngetting an additional support from the government.\nIf you are currently getting a support, enter '0': ");
		lengthOfNotSupported = scanner.nextByte();

		String stud = "student";
		String work = "worker";
		String unemployed = "unemployed";

		System.out.print("\nPlease, enter also your current status\n(student, worker or unemployed): ");
		String status = scanner.nextLine();
		status = scanner.nextLine();

		boolean istStudent = (status.equals(stud));
		boolean istWorker = (status.equals(work));
		boolean istUnemployed = (status.equals(unemployed));
		boolean istPerson = (istStudent || istWorker || istUnemployed);

		if (!istPerson) {
			while (!istPerson) {
				System.out.print("\nPlease, enter one of the statements\n(student, worker or unemployed): ");
				status = scanner.nextLine();

				if (status.equals(stud)) {
					break;
				}

				if (status.equals(work)) {
					break;
				}

				if (status.equals(unemployed)) {
					break;
				}
			}
		}

		Student inStud = new Student(); // we link to appropriate class to continue gathering
		Worker inWork = new Worker(); // additional information with an outcome for the applicant;
		Unemployed inUnemployed = new Unemployed();

		if (status.equals(stud)) {
			inStud.eligibility();
		}
		if (status.equals(work)) {
			inWork.eligibility();
		}
		if (status.equals(unemployed)) {
			inUnemployed.eligibility();
		}
		scanner.close();
	}
}

//---------------------------------------------------------------------------------------------------------------------
class Student extends Application {
	void eligibility() {
		Scanner scanner = new Scanner(System.in);

		// we take the condition of the grade (from '1' to '5');
		System.out.print("\nPlease, enter your current grade (from '1' to '5'): ");
		byte grade = scanner.nextByte();

		if (grade >= 1 && grade <= 5) {
			System.out.println(name + ", thank you very much.\n");
		}
		if (grade <= 1 || grade >= 5) {
			while (grade <= 1 || grade >= 5) {
				System.out.print("Please, enter a valid grade, i.e. from '1' to '5': ");
				grade = scanner.nextByte();
				if (grade >= 1 && grade <= 5) {
					System.out.println(name + ", thank you very much.\n");
				}
			}
		}
		// we take info about a possible additional income 'yes' or 'not';
		System.out.print("Are you having an extra income besides the scholarship?\n");
		String incomeStudent = scanner.nextLine();
		String yes = "yes";
		String not = "not";
		boolean istYes = (incomeStudent.equals(yes));
		boolean istNot = (incomeStudent.equals(not));
		boolean istPass = (istYes || istNot);

		if (istPass) {
			System.out.println("Thank you for your response");
		}
		if (!istPass) {
			while (!istPass) {
				System.out.print("Please, enter 'yes' or 'not': ");
				incomeStudent = scanner.nextLine();
				if (incomeStudent.equals(yes) || incomeStudent.equals(not)) {
					System.out.println("Thank you for your response");
					break;
				}
			}
		}

		String outcome = (age > 65)
				? ", your age is over 65 years, therefore, please, for a further support apply to the '...' department"
				: (lengthOfNotSupported < 2)
						? ", you have been supported during the last two years, therefore, for a further support we recommend "
								+ "you to contact the '...' department"
						: (grade > 3)
								? ", your grade is higher the 3rd grade, therefore, we recommend you to"
										+ " contact the following department"
								: (istYes)
										? ", you are having an additional income besides the scholarship, therefore, "
												+ "we recommend you to contact the following department"
										: ", your application will be reviewed.";
		System.out.println("\nDear, " + name + outcome);
		scanner.close();
	}
}

//-----------------------------------------------------------------------------------------------------------------------------------------
class Worker extends Application {
	void eligibility() {
		Scanner scanner = new Scanner(System.in);
		System.out.print(
				"Thank you\n\nPlease, enter the whole monthly income you have (including any income besides your salary): ");
		int income = scanner.nextInt();

		String outcome = (age > 65)
				? ", your age is over 65 years, therefore, please, for a further support apply to the '...' department"
				: (lengthOfNotSupported < 2)
						? ", you have been supported during the last two years, therefore, for a further support we recommend "
								+ "you to contact the '...' department"
						: (income > 2000)
								? ", your monthly income is over than 2000 Euros, therefore, we recommend "
										+ "you to contact the following department ... "
								: ", your application will be reviewed.";
		System.out.println("\nDear, " + name + outcome);
		scanner.close();
	}
}

//-----------------------------------------------------------------------------------------------------------------------------------------
class Unemployed extends Application {
	void eligibility() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Thank you\n\nPlease, if you have an additional monthly income "
				+ "(e.g. from your spouse, children allowance, e.t.c.)\n\t\t\tEnter here: ");
		int income = scanner.nextInt();

		String outcome = (age > 65)
				? ", your age is over 65 years, therefore, please, for a further support apply to the '...' department"
				: (lengthOfNotSupported < 2)
						? ", you have been supported during the last two years, therefore, for a further support we recommend "
								+ "you to contact the '...' department"
						: (income > 2000)
								? ", your monthly income is over than 2000 Euros, therefore, we recommend "
										+ "you to contact the following department ... "
								: ", your application will be reviewed.";
		System.out.println("\nDear, " + name + outcome);
		scanner.close();
	}
}