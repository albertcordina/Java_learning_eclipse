package while_loops;

import java.util.Scanner;

public class CheckPassword {

	public static void main(String[] args) {

		/*
		 * int count = 0; while(count < 10) { System.out.println("Count is: " + count);
		 * count++; }
		 */
		
		String userPassword = "secured";
		Scanner scanner = new Scanner(System.in);
		String password = null;
		
		do {
			System.out.print("Enter your password: ");
			password = scanner.nextLine();
		} while(!password.equals(userPassword));  // for the 'Strings' we use 'equals' not '=';
		
		scanner.close();
		System.out.println("Access granted!");
	
	}

}
