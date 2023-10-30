package recursion;

import java.util.Scanner;

public class Counting_up_down_numbers {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
        System.out.print("Please, enter a positive number: ");
		int number = scanner.nextInt();

		if (number < 0) {
			while (number < 0) {    //  the 'while' loop requests the user to enter only a positive number;
				System.out.print("Please, enter a positive number: ");
				number = scanner.nextInt();
				if (number > 0) {
					counting(number);  // calling the method 'counting' down below;
				//	count(number);     // calling the method 'count' below;
					System.out.println("Counting is complete!");
				}
			}
		} else {
			counting(number);  // calling the block of code, i.e. the method 'counting' below;
			System.out.println("Counting is complete!");
		}
		scanner.close();
	}

	//                                    THE METHOD TO COUNT DOWN TO '1' THE NUMBERS:
	
	static void counting(int a) {  
		while (a > 0) {
			System.out.println(a);
			a--;		
		}           
	}
	
	//                                      THE METHOD TO COUNT FROM '1' UP THE NUMBERS:
	
	static void count (int x) {  // 'int x' -> represents the 'number';		
		int y = 1;            // 'int y' -> represents the start point number for the loop;		
		while (y <= x) {     // the condition of the loop;

			System.out.println(y); //   the 
			y++;                   // outcome;
		}
		
	}
}
