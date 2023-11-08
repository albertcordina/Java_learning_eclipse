
package array;
public class Array_findMaximum {

	public static void main(String[] args) {
		
		String[] animals = { "cat", "dog", "elephant", "sloth" };
		
		for (String animal: animals) {   // assignment all elements to a string;
			System.out.println(animal);
		}
		
		//         Example of how to calculate the Arrays:
		
		int [] score = {125, 132, 95, 116, 154, 5};
		
		int highestScore = maximum(score); // NOTE: always save the calculation of the current result in a variable
		                                  //       
		System.out.println (highestScore);
		
		System.out.println(minimum(score)); 

		
	}
	
//---The universal method of finding the maximum and minimum number in the Array ---	
	
	public static int maximum (int [] numbers) { 
		int maxSoFar = numbers [0];	
		for (int num : numbers) { if (num > maxSoFar) {	maxSoFar = num;}}
		return (maxSoFar);}
	
	public static int minimum (int [] numbers) { 
		int minSoFar = numbers [0];	
		for (int num : numbers) { if (num < minSoFar) {	minSoFar = num;}}
		return (minSoFar);}
	
}
