package taking_Scanner;
import java.util.Scanner;

public class Taking_SelectWord_FromList_Scanner {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String status = getStatus(scanner);
		System.out.println("Your status: " + status);
		
		scanner.close();
	}

	private static String getStatus(Scanner scanner) {
		String status;
		String[] validStatus = { "retired", "student", "employed", "unemployed" };

		do {
			System.out.print("\nPlease, enter your current status (retired, student, employed, or unemployed): ");
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
		System.out.println(
				"Invalid status entered. Please enter either 'retired', 'student', 'employed', or 'unemployed'.");
		return false;
	}
}
