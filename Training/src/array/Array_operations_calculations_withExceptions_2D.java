package array;

import java.util.ArrayList;
import java.util.List;

public class Array_operations_calculations_withExceptions_2D {

	public static void main(String[] args) {

		int[][] numbers = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		int sum = calculateSum(numbers);
		System.out.println("Sum of 2D Array: " + sum);

		int minNumber = findMinNumber(numbers);
		System.out.println("Minimum Number in 2D Array: " + minNumber);
		
        int maxNumber = findMaxNumber(numbers);
        System.out.println("Maximum Number in 2D Array: " + maxNumber);
        
        double average = calculateAverage(numbers);
        System.out.println("Average of 2D Array: " + average);
        List<Integer> aboveAverageNumbers = findAboveAverageNumbers(numbers);
        System.out.println("Numbers Above Average in 2D Array: " + aboveAverageNumbers);
          
        List<Integer> evenNumbers = findEvenNumbers(numbers);
        System.out.println("Even Numbers in 2D Array: " + evenNumbers);
        
        int sumOfEvenNumbers = calculateSumOfEvenNumbers(numbers);
        System.out.println("Sum of Even Numbers in 2D Array: " + sumOfEvenNumbers);
        
        List<Integer> oddNumbers = findOddNumbers(numbers);
        System.out.println("Odd Numbers in 2D Array: " + oddNumbers);
        
        int sumOfOddNumbers = calculateSumOfOddNumbers(numbers);
        System.out.println("Sum of Odd Numbers in 2D Array: " + sumOfOddNumbers);

	}
//---------------------------- Sum of 2DArray -------------------------------------	
/*
 * The calculateSum method takes a 2D array of integers as a parameter.
It checks if the array is null or empty and throws an IllegalArgumentException if so.
It iterates through each row of the array and then through each element in the row, 
adding each element to the sum.
 * 
 */
	private static int calculateSum(int[][] numbers) {		
		if (numbers == null || numbers.length == 0 || numbers[0].length == 0) {
			throw new IllegalArgumentException("2D array is empty or null");
		}
		int sum = 0;
		for (int[] row : numbers) {
			for (int number : row) {
				sum += number;
			}
		}
		return sum;
	}
//---------------------------- Minimum 2DNumber -------------------------------------	
/*
 * The findMinNumber method takes a 2D array of integers as a parameter.
It checks if the array is null or empty and throws an IllegalArgumentException if so.
It initializes minNumber with the first element of the array.
It then iterates through the entire 2D array, updating minNumber if a smaller element is found.
 * 
 */
	private static int findMinNumber(int[][] numbers) {
		if (numbers == null || numbers.length == 0 || numbers[0].length == 0) {
			throw new IllegalArgumentException("2D array is empty or null");
		}
		int minNumber = numbers[0][0];
		for (int[] row : numbers) {
			for (int number : row) {
				if (number < minNumber) {
					minNumber = number;
				}
			}
		}
		return minNumber;
	}
//---------------------------- Maximum 2DNumber -------------------------------------	
/*
 * The findMaxNumber method takes a 2D array of integers as a parameter.
It checks if the array is null or empty and throws an IllegalArgumentException if so.
It initializes maxNumber with the first element of the array.
It then iterates through the entire 2D array, updating maxNumber if a larger element is found.
 * 
 */
	private static int findMaxNumber(int[][] numbers) {
		if (numbers == null || numbers.length == 0 || numbers[0].length == 0) {
			throw new IllegalArgumentException("2D array is empty or null");
		}
		int maxNumber = numbers[0][0];
		for (int[] row : numbers) {
			for (int number : row) {
				if (number > maxNumber) {
					maxNumber = number;
				}
			}
		}
		return maxNumber;
	}
//---------------------------- Average 2DNumber -------------------------------------	
/*
 * The calculateAverage method takes a 2D array of integers as a parameter.
It checks if the array is null or empty and throws an IllegalArgumentException if so.
It iterates through the entire 2D array, adding each element to the sum and counting the total number of elements.
The average is calculated by dividing the sum by the count and returned as a double.
 * 
 */
    private static double calculateAverage(int[][] numbers) {
        if (numbers == null || numbers.length == 0 || numbers[0].length == 0) {
            throw new IllegalArgumentException("2D array is empty or null");
        }
        int sum = 0;
        int count = 0;

        for (int[] row : numbers) {
            for (int number : row) {
                sum += number;
                count++;
            }
        }
        return (double) sum / count;
    }
/*
 * The findAboveAverageNumbers method takes a 2D array of integers as a parameter.
It checks if the array is null or empty and throws an IllegalArgumentException if so.
It calculates the average of the 2D array using the calculateAverage method.
It then iterates through the entire 2D array, adding each number above the average to the list.
 *     
 */
    
    private static List<Integer> findAboveAverageNumbers(int[][] numbers) {
        if (numbers == null || numbers.length == 0 || numbers[0].length == 0) {
            throw new IllegalArgumentException("2D array is empty or null");
        }

        double average = calculateAverage(numbers);
        List<Integer> aboveAverageNumbers = new ArrayList<>();

        for (int[] row : numbers) {
            for (int number : row) {
                if (number > average) {  // for find Under Avarage is: number < avarage
                    aboveAverageNumbers.add(number);
                }
            }
        }
        return aboveAverageNumbers;
    }  
 //------------------------------ Even 2DNumbers -------------------------------------	
    /*
     * The findEvenNumbers method takes a 2D array of integers as a parameter.
It checks if the array is null or empty and throws an IllegalArgumentException if so.
It iterates through the entire 2D array, adding each even number to the list.
     */
    private static List<Integer> findEvenNumbers(int[][] numbers) {
    	
        if (numbers == null || numbers.length == 0 || numbers[0].length == 0) {
            throw new IllegalArgumentException("2D array is empty or null");
        }

        List<Integer> evenNumbers = new ArrayList<>();

        for (int[] row : numbers) {
            for (int number : row) {
                if (number % 2 == 0) {
                    evenNumbers.add(number);
                }
            }
        }
        return evenNumbers;
    }
 //------------------------------ Sum of Even 2DNumbers -------------------------------------	
/*
 * The calculateSumOfEvenNumbers method takes a 2D array of integers as a parameter.
It checks if the array is null or empty and throws an IllegalArgumentException if so.
It iterates through the entire 2D array, adding each even number to the sum.
 * 
 */
    private static int calculateSumOfEvenNumbers(int[][] numbers) {
    	
        if (numbers == null || numbers.length == 0 || numbers[0].length == 0) {
            throw new IllegalArgumentException("2D array is empty or null");
        }
        
        int sum = 0;

        for (int[] row : numbers) {
            for (int number : row) {
                if (number % 2 == 0) {
                    sum += number;
                }
            }
        }
        return sum;
    }
//-------------------------------- Odd 2DNumbers -------------------------------------	
   /*
    * The findOddNumbers method takes a 2D array of integers as a parameter.
It checks if the array is null or empty and throws an IllegalArgumentException if so.
It iterates through the entire 2D array, adding each odd number to the list.
    */
    private static List <Integer> findOddNumbers (int[][] numbers) {
    	
        if (numbers == null || numbers.length == 0 || numbers[0].length == 0) {
            throw new IllegalArgumentException("2D array is empty or null");
        }
        List <Integer> oddNumbers = new ArrayList<>();

        for (int[] row : numbers) {
            for (int number : row) {
                if (number % 2 != 0) {
                    oddNumbers.add(number);
                }
            }
        }
        return oddNumbers;
    }
//------------------------------ Sum of Odd 2DNumbers -------------------------------------	
/*
 * The calculateSumOfOddNumbers method takes a 2D array of integers as a parameter.
It checks if the array is null or empty and throws an IllegalArgumentException if so.
It iterates through the entire 2D array, adding each odd number to the sum.
 */
    private static int calculateSumOfOddNumbers(int[][] numbers) {
        if (numbers == null || numbers.length == 0 || numbers[0].length == 0) {
            throw new IllegalArgumentException("2D array is empty or null");
        }
        int sum = 0;

        for (int[] row : numbers) {
            for (int number : row) {
                if (number % 2 != 0) {
                    sum += number;
                }
            }
        }
        return sum;
    }
}
