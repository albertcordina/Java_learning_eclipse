package array;

public class Array_CountEvenNumbers {

	public static void main(String[] args) {

		int[][] arr = { { 1, 2, 3 }, { 1, 2, 3 } };

		int evenCount = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] % 2 == 0) {
					evenCount++;
				}
			}
		}
		printArray(arr);
		System.out.println("\nCount of Even Numbers: " + evenCount);
	}

	public static void printArray(int[][] arr) {
		for (int[] x : arr) {
			for (int y : x) {
				System.out.print(y);
			}
			System.out.println();
		}
	}
}
