
package array;
public class Array_for_each_loop {

	public static void main(String[] args) {
		
		String[] animals = { "cat", "dog", "elephant", "sloth" };
		
		for (String animal: animals) {   // assignment all elements to a string;
			System.out.println(animal);
		}
		
		//         Example of how to calculate the Arrays:
		
		int [] score = {125, 132, 95, 116, 154, 5};
		
		int highestScore = maximum(score); // NOTE: always save the calculation of the current result in a variable;
		
		System.out.println (highestScore);

		
	}
	
	public static int maximum (int [] numbers) { // this method can be used for this or all others affiliated classes;
		
		int maxSoFar = numbers [0];
		
		for (int num : numbers) {   // NOTE: this way is used only when we need to go through all the elements in the Array,
			if (num > maxSoFar) {
			
			   maxSoFar = num;         // we use index 'i' when we need to go through a certain numbers of elements in the Array;
			
	    	}
		}
		return (maxSoFar);
	}
}
