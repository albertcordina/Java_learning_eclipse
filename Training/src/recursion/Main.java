package recursion;

public class Main {

	public static void main(String[] args) {

		// 4! = 4 * 3 * 2 * 1 (factorial 4); stack memory (for objects) is faster than hip memory; 
		// for math or statistics operations;
		System.out.println(factorial(8));
	}
	
	public static int factorial (int value) {
		System.out.println(value);
		
		if (value == 1) {
			return 1;
		}
		return factorial (value-1) * value;
	}
}
