package localdate;
import java.time.*;   //  we can also use the superclass 'time.*';
import java.time.format.DateTimeFormatter;

public class Local_Date_Time_rules {

	public static void main(String[] args) {
//-------------------------------------------------------------------------------------------------------------------		
//                                                             THE DATE:
		LocalDate date = LocalDate.now();             // data type as like any variable; 'now' is a static predifined method;
		LocalDate yesterday = date.minusDays(1);
		LocalDate tomorrow = date.plusDays(1);
		
		System.out.println("Today's date: " + date);
		System.out.println("Yesterday's date: " + yesterday);
		System.out.println("Tomorrow's date: " + tomorrow);
		
		LocalDate date1 = LocalDate.of(2020, 2, 24);   // setting a particular date;
		System.out.println(date1.isLeapYear());        // checking if the year is Leap; '2020' is a Leap year, therefore, it shows 'true';
		
		LocalDate date2 = LocalDate.of(2023, 9, 01);
		LocalDateTime dateTime = date2.atTime(1,43,8); // setting a prticular time to a date;
		System.out.println(dateTime);
		
		
//-------------------------------------------------------------------------------------------------------------------				
		
//             CONVERTING LocalDate to Sting:		            
		LocalDate date3 = LocalDate.now();
		String convertedToString = date3.format(DateTimeFormatter.ISO_DATE); // converting a date into a String, i.e. to fix/document it;
		System.out.println(date3);
		
//             CONVERTING String to LocalDate; 		
		String stringDate = "2020-08-02";       // NOTE: it should be only a date, i.e. not any additional info;
		LocalDate date4 = LocalDate.parse(stringDate); //  converting;
		System.out.println(date4);
		
//-------------------------------------------------------------------------------------------------------------------			
//                                                              THE TIME:	
		
		LocalTime time = LocalTime.now(); // local time;
		System.out.println(time); 
		
		LocalTime time1 = LocalTime.of(11, 45, 25); // setting a particular time;
		System.out.println(time1);
		
//                                     SUBTRACT TIME:		
		LocalTime time2 = LocalTime.of(10, 30, 20);
		System.out.println(time2);
		
		LocalTime time3 = time2.minusHours(1);
		LocalTime time4 = time3.minusMinutes(10);
		System.out.println(time4);
		
//                                        ADD TIME:	
		LocalTime time5 = LocalTime.of(11, 35, 40);
		System.out.println(time5);
		
		LocalTime time6 = time5.plusHours(5);
		LocalTime time7 = time6.plusMinutes(10);
		System.out.println(time7);
		
		
//-------------------------------------------------------------------------------------------------------------------			
//                                                              THE TIME ZONE:		
		ZoneId zone1 = ZoneId.of("Europe/Paris");
		ZoneId zone2 = ZoneId.of("America/Chicago");
		LocalTime time8 = LocalTime.now(zone2);
		System.out.println(time8);
		
		ZonedDateTime zone = ZonedDateTime.now(); // showing the local to the programist time zone;
		System.out.println(zone.getZone());
		
		
//                              Check if a date is after another date:		
		LocalDate date6 = LocalDate.parse("2023-05-23");
		LocalDate date7 = LocalDate.parse("2023-05-29");
		System.out.println(date6.isAfter(date7));
		
//-------------------------------------------------------------------------------------------------------------------					
//                                                       FORMATING THE DATE AND TIME:
		
		LocalDateTime currentDateTime = LocalDateTime.now();
		System.out.println("Before formatting: " + currentDateTime);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy , HH:mm:ss");
		String formatedDate = currentDateTime.format(formatter);
		System.out.println("After formatting: " + formatedDate);
		
	}
}
