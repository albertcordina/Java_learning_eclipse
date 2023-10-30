package localdate;
import java.util.*;
import java.time.*;
public class Local_Date_future_dates_calculator {

	public static void main(String[] args) {
		
		String start;
		int numberOfDays;

		Scanner scanner = new Scanner(System.in);
		System.out.print("\t\t-Future Dates Calculator-\n\nPlease, enter your starting date in the future (YYYY-MM-DD): ");
		start = scanner.nextLine();
		
		LocalDate startDate = LocalDate.parse(start); // converting from String to LocalDate;
		LocalDate currentDate = LocalDate.now(); // get the current LocalDate;		
		
		
		if (startDate.isAfter(currentDate)) {
			System.out.print("Enter the specified number of days to the starting date: ");
			numberOfDays = scanner.nextInt();
			LocalDate resultDate = startDate.plusDays(numberOfDays);
			System.out.println("The calculated future date: " + resultDate);
			
		}
		else {
			System.out.println("Error. You have entered a date in the past.");
		}
		scanner.close();
	}
}
