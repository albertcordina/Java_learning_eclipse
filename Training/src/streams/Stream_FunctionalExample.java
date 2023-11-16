package streams;

import java.util.Arrays;
import java.util.List;

public class Stream_FunctionalExample {
	
    public static void main(String[] args) {
    	
        List <Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // the calculation of sum of the even numbers of the List
        int sumOfEvenNumbers = numbers.stream() // stream is used to filter even numbers from the List
                                      .filter(n -> n % 2 == 0)
                                      .mapToInt(Integer::intValue) // 'mapToInt' converts the stream of integers to an IntStream
                                      .sum(); // 'sum' calculates the sum of the even numbers

        System.out.println("Original List: " + numbers);
        System.out.println("Sum of Even Numbers: " + sumOfEvenNumbers);
        

        
        System.out.println(calculateAverage(numbers));
         
    }    
        private static double calculateAverage (List<Integer> numbers) {
            if (numbers == null || numbers.size() == 0) {
                throw new IllegalArgumentException("Array is empty or null");
            }

            int a = 0;
            for (int b : numbers) {
                a += b;
            }

            return (double) a / numbers.size();
        }

}
