package localdate;
import java.util.*;
import java.io.InputStream;
import java.time.*;
public class Local_Date_day_of_the_week_calculator {

	public static void main(String[] args) {
		
		String date;
 
		Scanner scanner = new Scanner (System.in);
		System.out.print("\t-Day of the Week Calculator-\n\nPlease, enter your date (YYYY-MM-DD): ");
		date = scanner.nextLine();
		
		LocalDate convertedDate = LocalDate.parse(date); // converting from String to LocalDate;		
		DayOfWeek day = convertedDate.getDayOfWeek();   //  getting Day of the Week;
		
		System.out.println("The calculated day of the week: " + day);
		
		
		scanner.close();
	}
}
