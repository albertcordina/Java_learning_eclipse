package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
 * The ReentrantLock in Java is used for managing critical sections of code where multiple 
 * threads might contend for access. It provides a more flexible and powerful alternative 
 * to the traditional synchronized keyword for controlling access to shared resources. 
 * The term "reentrant" means that a thread can acquire the lock multiple times without deadlocking itself.
 * 
 * In this example:

1. SharedCounter has a ReentrantLock named lock.
2. The incrementCounter method represents a critical section where the lock is acquired before incrementing 
   the shared counter and released afterward.
3. Two threads (incrementThread1 and incrementThread2) are created to increment the counter concurrently.
4. The join method is used to wait for both threads to finish before printing the final counter value.

Using ReentrantLock in this scenario ensures that only one thread can be inside the critical 
section at a time, preventing race conditions and ensuring the integrity of the shared counter.

Here's a simple example where ReentrantLock is used to protect a counter:
 * 
 */
public class Thread_ReentrantLock_Example {
	
	private Lock lock = new ReentrantLock();

	public static void main(String[] args) {
		Thread_ReentrantLock_Example sharedCounter = new Thread_ReentrantLock_Example();
		sharedCounter.runExample();		

	}

   public void runExample() {
		// Create two threads that increment the counter concurrently
		Thread incrementThread1 = new Thread(this::incrementCounter);
		Thread incrementThread2 = new Thread(this::incrementCounter);

		incrementThread1.start();
		incrementThread2.start();

		// Wait for both threads to finish
		try {
			incrementThread1.join();
			incrementThread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void incrementCounter() {
		
		// Simulate some work inside the non-critical section of the method
	   //  The non-critical section is executed for the both Threads concurrently	
    	System.out.println("non-critical part (before the lock):");
    	for (int i = 0; i < 2; i++) {System.out.println(i);} 
  
    	
		// Acquire the lock before entering the critical section
		lock.lock();
		try {// Simulate some work inside the critical section
			//  The critical section is executed ONLY one Thread after another 
	    	System.out.println("critical part (inside the lock):");
	    	for (int i = 3; i < 5; i++) {System.out.println(i);
			}
		} finally {
			// Always release the lock in a finally block to ensure it's released even if an
			// exception occurs
			lock.unlock();
		}
				
		// Simulate some work inside the non-critical section of the method
		   //  The non-critical section is executed for the both Threads concurrently	
	    	System.out.println("non-critical part (after the lock):");
	    	for (int i = 11; i < 13; i++) {System.out.println(i);} 
	}
}
