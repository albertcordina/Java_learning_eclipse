package thread_miscellaneous;

class Account {
	/*
	 * wait() method is used to pause the execution of a thread until another thread signals that it can resume.
	 *
	 * notify() method wakes up only one thread waiting on the object and that thread starts execution. 
	 * So if there are multiple threads waiting for an object, this method will wake up only one of them.
	 */
	
	int amount = 20000;
	
	synchronized void withdraw (int amount) {
		
		System.out.println("Withdrawing ...");
		if (this.amount < amount) { 
			System.out.println("Insufficient funds. Please deposit...");
			
			try { wait();} // method 'wait' jumps to the next mehtod below (where the 'notify' is) and gets activated again after depositing; 
			catch (Exception e) {System.out.println(e);}
		     }
		this.amount -= amount;
		System.out.println("Withdraw completed!");
	}
	
	synchronized void deposit (int amount) {
		
		System.out.println("Depositing ...");
		this.amount += amount;
		System.out.println("Deposit completed!");
		notify();
	}
}
//--------------------------------------
public class Thread_Wait_and_Notify {

	public static void main(String[] args) {

		Account acc = new Account(); // each Thread must have its own object;
		new Thread() {
			public void run () { acc.withdraw(25000);}
		  }.start(); // start() method causes this thread to begin execution, the result is that two threads are running concurrently;
		
		new Thread() {
			public void run () { acc.deposit(6000);}
		  }.start(); // start() method causes this thread to begin execution, the result is that two threads are running concurrently;
	}
}
