package thread_miscellaneous;

public class ParallelTaskExercise {

	public static void main(String[] args) {

		ParallelTask task1 = new ParallelTask (4);
		ParallelTask task2 = new ParallelTask (8);
		ParallelTask task3 = new ParallelTask (10);
		
		Thread thread1 = new Thread (task1);
		Thread thread2 = new Thread (task2);
		Thread thread3 = new Thread (task3);

		thread1.start();
		thread2.start();
		thread3.start();
		
		try {
			thread1.join();
			thread2.join();
			thread3.join();
		} catch (InterruptedException e) {System.out.println("Main thread is interrupted.");}

		System.out.println("Main thread is done.");
	}
}

class ParallelTask implements Runnable {
	
	private int number;
	
	public ParallelTask (int number) {this.number = number;} 
	
	public void run () { 
		long result = calculateFactorial(number);
		System.out.println("Factorial of " + number + " is " + result);}
	
	private long calculateFactorial (int n) {
		
		if (n <= 1) {return 1;}
		return n * calculateFactorial (n - 1);
	}	
}


