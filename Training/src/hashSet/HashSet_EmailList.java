package hashSet;

import java.util.*;

public class HashSet_EmailList {

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		HashSet<String> emailList = new HashSet<>();
		int input;
		
		System.out.println("THE EMAIL LIST:");
		do { System.out.print("\n\nPress '1' if you want to enter your email address\nPress '2' to review the list of your email address(s)\n"
				+ "Press '3' to Exit.\n\nPlease, enter your option: ");
		
		         input = scanner.nextInt();   
		 
		     if (input == 1) {
			    System.out.print("Please, enter your email address: ");
			    String inputEmail = scanner.nextLine();
			    inputEmail = scanner.nextLine();
			    emailList.add(inputEmail);
			    }
		     
		     if (input == 2) {
		    	 System.out.println("\nThank you\nPlease, see the whole list: \n");
		    	 for (String x : emailList) {System.out.println(x);
		    	 }	    	 
		     }
		}
		while (input != 3);
		System.out.println("Thank you for your visit!");
		scanner.close();
	}
}