package array;
import java.util.*;
public class Arrays_operations_calculations {
	
	public static void main(String[] args) {

int [] arr = {3,2,1,4,5,6};
for (int x : arr) {System.out.println(x);} // the number of the elements in the Array (no need a method);

Arrays.sort(arr);                          // the method 'sort()' for printing out
for (int x : arr) {System.out.println(x);} // all of the elements in their uprising values (import java.util.*; is needed);

Integer [] array = {3,2,1,4,5,6};               // the method 'sort(... , Collections.reverseOrder()) is for
Arrays.sort(array, Collections.reverseOrder()); // printing out in counting down all the values of the Array (the varible should be 'reference' type); 
for (int x : array) {System.out.println(x);}

System.out.println(sum(arr));
System.out.println(average(arr));
double ave = average(arr);
System.out.println(max(arr));
System.out.println(aboveAverage(arr,ave));


int [] [] arr2 = {{1,2,3},{1,2,3}};
printOut(arr2);                          // the number of the elements in the 2D Array (needs a method, see below);

System.out.println(sum2d(arr2));
System.out.println(max2d(arr2));
System.out.println(average2d(arr2));
System.out.println(even(arr2));



	}
	public static int sum (int [] arr) {  // -> the method for calculating the sum of the Array;
		int x = 0;
		for (int y : arr) {
			x += y;
		}
		return x;
	}
	public static int max (int [] arr) {  // -> the method for finding the maximum or minimum element of the Array;
		int x = arr [0];
		for (int y : arr) {
			if (y > x) {
			x = y;
		}
	  }
	return x;
	}
	public static double average (int [] arr) { // -> the method for finding the average of the Array;
		int x = 0;
		for (int y : arr) {
			x += y;
		}
		return x/arr.length;
	}	
	public static int aboveAverage (int [] arr, double ave) { // -> the method of calculating the number of elements
		int x = 0;                                            //    above the average of the Array;
		for (int y : arr) {
			if (y < ave) {
				x++;
			}
		}
		return x;
	}
	
//------------------------------------  THE 2D ARRAYS: ------------------------------------------------------------
	
	public static void printOut (int [] [] arr2) {
		
		for (int [] x : arr2) {
			for (int y : x) {
				System.out.print(y); // print out the 2D Array in one line;
			}
			//System.out.println(); // print out the 2D Array in the two lines;
		}		
	}
	public static int sum2d (int [] [] arr2) {              // -> the method of calculating the sum of the 2D Array;
	
		int x = 0;
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				x += arr2 [i] [j];
			}			
		}
		return x;
	}
	public static int max2d (int [] [] arr2) {
		int x = 0;
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				if (arr2 [i] [j] > x) {   //  (arr2d [i] [j] < x) -> for minimum of the 2D Array;
					x = arr2 [i] [j];
				}
			}
		}
		return x;
	}	
	public static int average2d (int [] [] arr2) {        // -> the method of calculating the average of the 2D Array;
		
		int x = 0;
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				x += arr2 [i] [j];
			}			
		}
		return x/ arr2.length;
	}	
	public static int even (int [] [] arr2) {            // -> the method of calculating the even numbers of the 2D Array;
		int x = 0;
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				if (arr2[i] [j] % 2 == 0) {
					x ++;
				}
			}		
		}
		return x;
	}
}
	
