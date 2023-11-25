package thread_miscellaneous;

public class BankAccountExercise {

	public static void main(String[] args) {
		
		BankAccount bankAccount = new BankAccount();
		
		Depositor depositor = new Depositor(bankAccount);
		Withdrawal withdrawal = new Withdrawal(bankAccount);
		
		depositor.start();
		withdrawal.start();

		try {
			depositor.join();
			withdrawal.join();
		    }
		catch (InterruptedException e) {System.err.println("Main thread interrupted.");}
		
		System.out.println("Final balance in the bank account: " + bankAccount.getBalance());
		}
	}
//---------------------------------------------------------------------------------------------------------
class BankAccount {

	private int balance = 0; // to store the account balance;

	public synchronized void deposit(int amount) { balance += amount;} // updates the balance after deposit;

	public synchronized void withdraw(int amount) { balance -= amount;} // update the balance after withdraw;
	
	public int getBalance () { return balance;}
}
//-----------------------------------------------------------------------------
class Depositor extends Thread { // making a multible deposits;
	private BankAccount bankAccount;
	
	public Depositor (BankAccount bankAccount) {this.bankAccount = bankAccount;}
	public void run () {
		for (int i = 0; i < 5; i++) { bankAccount.deposit(100);} // 5 operations of depositing;
	}
}
//------------------------------------------------------------------------------
class Withdrawal extends Thread { // making a multiple withdrawals;

	private BankAccount bankAccount;
	
	public Withdrawal (BankAccount bankAccount) {this.bankAccount = bankAccount;}
	
	public void run () {
		for (int i = 0; i < 5; i++) { bankAccount.withdraw (50);} // 5 operations of withdrawing;
	}
}