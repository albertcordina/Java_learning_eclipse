package thread_reentrantLock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock_rules {
/*
 * ReentrantLock is a type of lock that implements the Lock interface. 
 * It provides a way to synchronize access to a critical section of code, 
 * similar to using synchronized blocks. The term "reentrant" means that a thread
 *  that already holds the lock can acquire it again without blocking, which can
 *   be useful in certain scenarios.
 * 
  * In this example, two threads (thread1 and thread2) are trying to execute the performTask method, 
 * which is synchronized using a ReentrantLock. The lock object is an instance of ReentrantLock. 
 * The lock() method is called to acquire the lock, and the unlock() method is called to release the lock.
   The output may vary on each run, but it will demonstrate that the threads are taking turns acquiring and 
   releasing the lock. Note that the ReentrantLock allows the same thread to acquire the lock multiple times, 
   and it must release the lock an equal number of times before other threads can acquire it.

Keep in mind that using ReentrantLock gives you more flexibility than synchronized blocks, 
such as the ability to interrupt a thread waiting for the lock (lockInterruptibly), specify 
a timeout for attempting to acquire the lock (tryLock), and more.
 * 
 */
	 private static final ReentrantLock example = new ReentrantLock();

	    public static void main(String[] args) {
	    	
	        // Create the threads and start them
	        Thread thread1 = new Thread(ReentrantLock_rules::performTask);
	        Thread thread2 = new Thread(ReentrantLock_rules::performTask);
	        Thread thread3 = new Thread(ReentrantLock_rules::performTask);
	        Thread thread4 = new Thread(ReentrantLock_rules::performTask);

	        thread1.start();
	        thread2.start();
	        thread3.start();
	        thread4.start();
	    }

	    public static void performTask() {
	    	
	        System.out.println(Thread.currentThread().getName() + " is trying to acquire the lock.");

	        	        
	        // Acquiring the lock
	        example.lock();
	        try {
	            System.out.println(Thread.currentThread().getName() + " has acquired the lock.");

	            // Simulating some critical section code (e.g. each thread is executed 3 times)
	            for (int i = 0; i < 3; i++) { 
	            	System.out.println(Thread.currentThread().getName() + ": " + i);
	            }
	        } finally {
	      // Always release/ unblock the lock in a finally block to ensure it's released even if an exception occurs
	        	example.unlock();
	            System.out.println(Thread.currentThread().getName() + " has released the lock.");
	        }
	    }
	}
/*
 * ReentrantLock and ScheduledExecutorService serve different purposes in Java, 
 * and they are used in different contexts.

ReentrantLock:

ReentrantLock is part of the java.util.concurrent.locks package and provides a more 
flexible alternative to the traditional synchronized keyword for managing access to shared resources.
It allows for greater control over the locking and unlocking process. 
For example, it supports interruptible lock acquisition, non-blocking lock acquisition, and the ability to lock with a timeout.
ReentrantLock is used for managing critical sections of code where multiple threads might contend for access. 
It supports reentrant locking, meaning a thread can acquire the same lock multiple times without deadlocking itself.
 * 
 * ScheduledExecutorService:

ScheduledExecutorService is part of the java.util.concurrent package and is designed for scheduling tasks to run periodically or with a delay.
It provides methods to schedule tasks with fixed-rate, fixed-delay, or single-execution policies. It's commonly used for background tasks, 
periodic maintenance, or any situation where you need to execute tasks at specified intervals.
ScheduledExecutorService can manage multiple threads internally, providing a way to parallelize the execution of scheduled tasks.
 */
 