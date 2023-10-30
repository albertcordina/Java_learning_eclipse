package linked_list;
import java.util.*;
public class LinkedList_BankAccountBalance {

	public static void main(String[] args) {
		
		List<Double> accountBalances = new LinkedList<>();
		
		addAccount(accountBalances, 1000.0);
		addAccount(accountBalances, 1500.0);
		addAccount(accountBalances, 500.0);
		System.out.println("Account Balances: ");
		
		
		displayBalances(accountBalances);
		
	}
	public static void addAccount (List<Double> accountBalances, double balance) {
		
		accountBalances.add(balance);
		
	}
	public static void displayBalances (List<Double> accountBalances) { // the method prints out all the elements of the LinkedList; 
		
		for (int i = 0; i < accountBalances.size(); i++) {           
	    	Double s = accountBalances.get(i);
	    	System.out.println(i + ": " +s);
		}
    }
}
