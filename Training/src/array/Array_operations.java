package array;

public class Array_operations {

	public static void main(String[] args) {

		int[] love = new int[2]; // the first way of creating an Array;
        love[0] = 6;
		love[1] = 10;
	
		
		System.out.println(addition(love));
		
		
		int [] life = {2,6,14,8}; // the second way of creating an Array;
		
		System.out.println(maximum(life));
		
		// created for the calculating the number of elements grater than the average of the Array;
		int [] way = {1,2,3,4,5,6,7};
		double average = 3.5;
		
		System.out.println(aboveAverage(way,average));
		
	}

	public static int addition(int[] love) { // the method calculates the 'sum'
                                             // and the 'average' of an Array;
		int x = 0;                 
		for (int y : love) {
			x += y;
		}
		return x;
	//	return x / love.length; //-> if we need an average;
	}
	

	public static int maximum(int[] life) { // the method identifies an element with the
                                            // 'minimum' or 'maximum' value within an Array;
		int x = life[0];
		for (int y : life) {
			if (y > x) {     // -> for maximum;
	//      if (y < x) {	 //-> for minimum;		
				x = y;
			}
		}
		return x;
	}
	
	public static int aboveAverage(int[] way, double average) { // the method calculates the number of elements 
		int x = 0;                                              // above or under the average of the 'sum' of the whole Array.
		for (int y : way) {                                     // NOTE: the already calculated average is needed;                                 
			if (y > average) { //-> for above;
	//      if (y < average) { //-> for under;			
				x++;
			}
		}
		return x;
		
	}

}