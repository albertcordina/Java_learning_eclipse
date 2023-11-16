package array;

import java.util.ArrayList;
import java.util.List;

public class Array_operations_calculations_withExceptions {

	public static void main(String[] args) {
		
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        int sum = calculateSum(numbers);
        System.out.println("Sum: " + sum);
        
        int minNumber = findMinNumber(numbers);
        System.out.println("Minimum Number: " + minNumber);
        
        int maxNumber = findMaxNumber(numbers);
        System.out.println("Maximum Number: " + maxNumber);
        
        double average = calculateAverage(numbers);
        System.out.println("Average: " + average);
        List<Integer> aboveAverageNumbers = findAboveAverageNumbers(numbers);
        System.out.println("Numbers Above Average in Array: " + aboveAverageNumbers);
    
        
        List<Integer> evenNumbers = findEvenNumbers(numbers);
        System.out.println("Even Numbers in Array: " + evenNumbers);

        int sumOfEvenNumbers = calculateSumOfEvenNumbers(numbers);
        System.out.println("Sum of Even Numbers: " + sumOfEvenNumbers);
        
        List<Integer> oddNumbers = findOddNumbers(numbers);
        System.out.println("Odd Numbers in Array: " + oddNumbers);
        
        int sumOfOddNumbers = calculateSumOfOddNumbers(numbers);
        System.out.println("Sum of Odd Numbers in Array: " + sumOfOddNumbers);
    }
//---------------------------- Sum of Array -------------------------------------	
/*
 * The calculateSum method takes an array of integers as a parameter.
It checks if the array is null or empty and throws an IllegalArgumentException if so.
It iterates through the array and adds each element to the sum.
 * 
 */
    private static int calculateSum(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array is empty or null");
        }

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
//---------------------------- Minimum Number -------------------------------------	
/*
 * The findMinNumber method takes an array of integers as a parameter.
It checks if the array is null or empty and throws an IllegalArgumentException if so.
It initializes minNumber with the first element of the array.
It then iterates through the array, updating minNumber if a smaller element is found.
 * 
 */
    private static int findMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array is empty or null");
        }

        int minNumber = numbers[0];
        for (int number : numbers) {
            if (number < minNumber) {
                minNumber = number;
            }
        }
        return minNumber;
    }
//---------------------------- Maximum Number -------------------------------------	
/*
 * The findMaxNumber method takes an array of integers as a parameter.
It checks if the array is null or empty and throws an IllegalArgumentException if so.
It initializes maxNumber with the first element of the array.
It then iterates through the array, updating maxNumber if a larger element is found.
 * 	
 */
    private static int findMaxNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array is empty or null");
        }

        int maxNumber = numbers[0];
        for (int number : numbers) {
            if (number > maxNumber) {
                maxNumber = number;
            }
        }
        return maxNumber;
    }
//---------------------------- Average Number -------------------------------------	
/*
 * The calculateAverage method takes an array of integers as a parameter.
It checks if the array is null or empty and throws an IllegalArgumentException if so.
It then calculates the sum of all the elements in the array using a loop.
The average is calculated by dividing the sum by the number of elements in 
the array and returned as a double.
 * 	
 */
    private static double calculateAverage(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array is empty or null");
        }

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return (double) sum / numbers.length;
    }
/*
 * The findAboveAverageNumbers method takes a 1D array of integers as a parameter.
It checks if the array is null or empty and throws an IllegalArgumentException if so.
It calculates the average of the array using the calculateAverage method.
It then iterates through the entire array, adding each number above the average to the list.
 *     
 */
    
    private static List<Integer> findAboveAverageNumbers(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array is empty or null");
        }

        double average = calculateAverage(numbers);
        List<Integer> aboveAverageNumbers = new ArrayList<>();

        for (int number : numbers) {
            if (number > average) { // for find Under Avarage is: number < avarage
                aboveAverageNumbers.add(number);
            }
        }
        return aboveAverageNumbers;
    }
//------------------------------ Even Numbers -------------------------------------	
/*
 * The findEvenNumbers method takes a 1D array of integers as a parameter.
It checks if the array is null or empty and throws an IllegalArgumentException if so.
It iterates through the entire array, adding each even number to the list.
 *    
 */
    private static List<Integer> findEvenNumbers(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array is empty or null");
        }

        List<Integer> evenNumbers = new ArrayList<>();

        for (int number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            }
        }
        return evenNumbers;
    }
//------------------------------ Sum of Even Numbers -------------------------------------	
 /*
  * The calculateSumOfEvenNumbers method takes an array of integers as a parameter.
It checks if the array is null or empty and throws an IllegalArgumentException if so.
It iterates through the array and adds each even number to the sum.
  *    
  */
    private static int calculateSumOfEvenNumbers(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array is empty or null");
        }

        int sum = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                sum += number;
            }
        }
        return sum;
    }
 //-------------------------------- Odd Numbers -------------------------------------	
 /*
  * The findOddNumbers method takes a 1D array of integers as a parameter.
It checks if the array is null or empty and throws an IllegalArgumentException if so.
It iterates through the entire array, adding each odd number to the list.
  *    
  */
    private static List<Integer> findOddNumbers(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array is empty or null");
        }

        List<Integer> oddNumbers = new ArrayList<>();

        for (int number : numbers) {
            if (number % 2 != 0) {
                oddNumbers.add(number);
            }
        }
        return oddNumbers;
    }
 //------------------------------ Sum of Odd Numbers -------------------------------------	
 /*
  * The calculateSumOfOddNumbers method takes a 1D array of integers as a parameter.
It checks if the array is null or empty and throws an IllegalArgumentException if so.
It iterates through the entire array, adding each odd number to the sum.
  *    
  */
    private static int calculateSumOfOddNumbers(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array is empty or null");
        }

        int sum = 0;

        for (int number : numbers) {
            if (number % 2 != 0) {
                sum += number;
            }
        }
        return sum;
    }
}