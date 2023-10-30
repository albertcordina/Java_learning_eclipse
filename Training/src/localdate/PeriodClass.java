package localdate;
import java.time.LocalDate;
import java.time.Period;
  
public class PeriodClass {
  
    // Function to calculate period between
    // start and end date
    static void calculatePeriod(LocalDate startDate,
                                LocalDate endDate)
    {
        Period period = Period.between(startDate, endDate);
        System.out.println("Period between start and end "
                           + "date is : " + period);
    }
  
    // Driver Code
    public static void main(String[] args)
    {
        // Start date
        LocalDate startDate = LocalDate.parse("2017-02-13");
  
        // End date
        LocalDate endDate = LocalDate.parse("2018-08-20");
  
        calculatePeriod(startDate, endDate);
    }
}