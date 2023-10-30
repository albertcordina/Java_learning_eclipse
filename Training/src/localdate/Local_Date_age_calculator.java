package localdate;
import java.util.*;
import java.time.*;

public class Local_Date_age_calculator {

	public static void main(String[] args) {

		String birthdate;
		String age;

		Scanner scanner = new Scanner(System.in);
		System.out.print("\t   - AGE CALCULATOR -\n\nPlease, enter your date of birth (YYYY-MM-DD): ");
		birthdate = scanner.nextLine();

		LocalDate birthDate = LocalDate.parse(birthdate); // converting from String to LocalDate;
		LocalDate currentDate = LocalDate.now(); // get the current LocalDate;

		Period p = Period.between(birthDate, currentDate); // calculate the period between the two Dates;
			
		String period = p.toString(); // converting the period into a String;
		
		age = period.substring(1,3); // selecting the elements representing the years in the String;

		System.out.println("You are " + age + " year(s) old."); // printing out the age in years;
		

		scanner.close();
	}
}
