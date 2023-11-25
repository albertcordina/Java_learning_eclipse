package thread_miscellaneous;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
public class ExecutorService_factorialCalculation {
	/*
	 * 
The Java ExecutorService is the interface which allows us to execute tasks on threads asynchronously. 
The Java ExecutorService interface is present in the java. util. concurrent package. 
The ExecutorService helps in maintaining a pool of threads and assigns them tasks.
	 */
	
	public static void main(String[] args) {
	
		int numberOfThreads = 3;
				
		ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads); // Creates an 'ExecutorService' with a fixed thread pool; 
		
		TaskProcessor [] tasks = {new TaskProcessor (5), new TaskProcessor (8), new TaskProcessor (3)}; // Array of tasks with the entered numbers via constructor;
		
		for (TaskProcessor task : tasks) {executorService.execute(task);} // Submit each TaskProcessor to the 'ExecutorService' for execution;
		
		
		executorService.shutdown(); // The 'ExecutorService' has to be shuted down after the execution of the program above
		try { executorService.awaitTermination(5, TimeUnit.SECONDS); } // after the set time within the Exception.
		catch (InterruptedException e) {e.printStackTrace();}         // if the operation has not been done, Error; 
		
	}
}
//-------------------------------------------------------------------------------------------------------------------------
class TaskProcessor implements Runnable { // represents a task that calculates and prints the factorial of a given number.
	
	private int n;                               // the int for a number to calculate the factorial;
	public TaskProcessor (int n) {this.n = n;} // the constructor of passing the int to use it in the main method;
	
	public void run () { // calculates the factorial of the given number, and prints out the result.
	
		int fact = 1;
		for (int i = 1; i <= n; i++) {fact = fact * i;}
        System.out.println("Factorial of " + n + " is " + fact);
	}
}




