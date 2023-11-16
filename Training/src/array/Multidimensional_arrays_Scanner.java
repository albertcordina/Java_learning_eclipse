package array;

import java.util.Scanner;

public class Multidimensional_arrays_Scanner {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Please, enter the number of rows: ");
		int numberOfRows = scanner.nextInt();
		
		System.out.print("Please, enter the numbers of colums: ");
		int numberOfColumns = scanner.nextInt();

		int[][] arr = new int[numberOfRows][numberOfColumns]; // we create the new empty Arrays according to the
															 // previous user's inputs;
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numberOfColumns; j++) {
				arr[i][j] = (i+2) * (j+2);
			}
		}
		for (int[] rows : arr) { for (int value : rows) { System.out.print(value + "");}
			System.out.println(); 
		}

		scanner.close();
	}
}
