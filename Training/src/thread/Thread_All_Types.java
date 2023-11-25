package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;


//--------------------------------
class MyThread1 extends Thread {
	public void run() {
		// Code to be executed in the thread
		System.out.println("Thread using Thread class");
	}
}
//------------------------------------
class MyRunnable1 implements Runnable {
	public void run() {
		// Code to be executed in the thread
		System.out.println("Thread using Runnable interface");
	}
}
//---------------------------------------------------------------------------------
class MyTask implements Runnable {
	public void run() {
		// Code to be executed in the thread
		System.out.println("Thread from Thread Pool");
	}
}
//----------------------------------------------------------------------------------
public class Thread_All_Types {
	/*
	 * In Java, threads are a way to execute multiple tasks concurrently. Here are
	 * examples of different types of threads in Java with short explanations and
	 * practical use cases:
	 */
	public static void main(String[] args) {

		/* 1. Extending the Thread Class: This is a basic example where a new thread is
		 *    created by extending the Thread class. Practical use cases include scenarios
		 *    where you need more control over the threading process.
		 */
		MyThread1 myThread1 = new MyThread1();
		myThread1.start(); // Start the thread

		/*
		 * 2. Implementing the Runnable Interface: This is useful when you want to
		 *    extend a class other than Thread or when you're dealing with multiple
		 *    inheritance. It is a more flexible way to create threads.
		 */
		Thread myThread2 = new Thread(new MyRunnable1());
		myThread2.start(); // Start the thread

		/*
		 * 3. Anonymous Thread: Useful when you need a thread for a SHORT, SIMPLE task
		 *                      and don't want to create a separate class for it.
		 */
		Thread myThread3 = new Thread(new Runnable() {
			public void run() {
				// Code to be executed in the thread
				System.out.println("Anonymous Thread");
			}
		});
		myThread3.start(); // Start the thread

		/*
		 * 4. Lambda Expression Thread: Similar to anonymous threads (even SHORTER), 
		 *    lambda expressions provide a concise way to define the run method for short tasks.
		 */
		Thread myThread4 = new Thread(() -> {
			// Code to be executed in the thread
			System.out.println("Thread using Lambda expression");
		});
		myThread4.start(); // Start the thread

		/*
		 * 5. Thread Pool using ExecutorService: Thread pools are beneficial when
		 *    dealing with a large number of short-lived tasks. They manage and reuse
		 *    threads efficiently, avoiding the overhead of creating new threads for each task.
		 */
		ExecutorService executor = Executors.newFixedThreadPool(5); // Create a thread pool
		for (int i = 0; i < 5; i++) {
			executor.execute(new MyTask()); // Execute tasks using the thread pool
		}
		executor.shutdown(); // Shutdown the thread pool

		
//---------------------- THE TOOLS FOR SYNCHRONIZATION BETWEEN THREADS ----------------------- 
// Each of the 5 tools is suitable for different synchronization requirements in concurrent programming.		

		/*
		 * 1. Synchronized Method: ensures only one thread can execute it at a time.
		 *    Locks the entire method, preventing other threads from executing any synchronized method of the same object.
		 */
		SharedResource1 sharedResource1 = new SharedResource1();

		// Creating multiple threads to access the shared resource
		Thread thread1 = new Thread(() -> sharedResource1.performTask());
		Thread thread2 = new Thread(() -> sharedResource1.performTask());

		// Start the threads
		thread1.start();
		thread2.start();

		/*
		 * 2. Synchronized Block: ensures only one thread can execute it at a time.
		 *    Locks only the specific block of code, allowing other threads to access other synchronized blocks of the same object concurrently.
		 */
		SharedResource2 sharedResource2 = new SharedResource2();

		// Creating multiple threads to access the shared resource
		Thread thread3 = new Thread(() -> sharedResource2.performTask());
		Thread thread4 = new Thread(() -> sharedResource2.performTask());

		// Start the threads
		thread3.start();
		thread4.start();

		/*
		 * 3. ReentrantLock is a part of Java's concurrency support and is a mechanism
		 * for controlling access to shared resources by multiple threads. It's a type
		 * of lock that provides similar functionality to the intrinsic locking provided
		 * by the synchronized keyword but with additional features.
		 * 
		 * In this example, ReentrantLock is used to control access to the performTask
		 * method of the SharedResource class. It allows a thread to enter the method if
		 * the lock is not held by another thread or if the lock is held by the same
		 * thread (reentrant property). This can be useful in scenarios where you need
		 * more fine-grained control over locking than what is provided by the
		 * synchronized keyword.
		 */
		SharedResource3 sharedResource3 = new SharedResource3();

		// Creating multiple threads to access the shared resource
		Thread thread5 = new Thread(() -> sharedResource3.performTask());
		Thread thread6 = new Thread(() -> sharedResource3.performTask());

		// Start the threads
		thread5.start();
		thread6.start();

		/*
		 * 4. Semaphore: Code to be executed with the acquired permit
		 */

        SharedResource4 sharedResource4 = new SharedResource4();

        // Creating multiple threads to access the shared resource
        Thread thread7 = new Thread(() -> sharedResource4.performTask());
        Thread thread8 = new Thread(() -> sharedResource4.performTask());

        // Start the threads
        thread7.start();
        thread8.start();
        
        /*
         * 5. CountDownLatch: Code to be executed before the latch countdown
         */
        
        SharedResource5 sharedResource5 = new SharedResource5();

        // Creating multiple threads to access the shared resource
        Thread thread9 = new Thread(() -> sharedResource5.performTask());
        Thread thread10 = new Thread(() -> {
            try {
                sharedResource5.waitForTask();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start the threads
        thread9.start();
        thread10.start();
	}
}
//---------------------------------------------------------------------------------
class SharedResource1 { // Synchronized method
	// Synchronized method ensures only one thread can execute it at a time
	public synchronized void performTask() {
		// Code to be executed in a synchronized manner
		System.out.println("Task performed by Synchronized Method Thread: " + Thread.currentThread().getName());
	}
}
//-----------------------------------------------------------------------------------
class SharedResource2 { // Synchronized block
	private Object lock = new Object();

	public void performTask() {
		// Synchronized block ensures only one thread can execute it at a time
		synchronized (lock) {
			// Code to be executed in a synchronized manner
			System.out.println("Task performed by Synchronized block Thread: " + Thread.currentThread().getName());
		}
	}
}
//-----------------------------------------------------------------------------------
class SharedResource3 { // ReentrantLock
	private final ReentrantLock lock = new ReentrantLock();

	public void performTask() {
		lock.lock(); // Acquire the lock
		try {
			// Code to be executed while holding the lock
			System.out.println("Task performed by ReentrantLock Thread: " + Thread.currentThread().getName());
		} finally {
			lock.unlock(); // Release the lock in the finally block to ensure it's always released
		}
	}
}
//-----------------------------------------------------------------------------------
class SharedResource4 {  // Semaphore
    private Semaphore semaphore = new Semaphore(1); // Only one thread allowed to access

    public void performTask() {
        try {
            semaphore.acquire(); // Acquire the permit
            // Code to be executed with the acquired permit
            System.out.println("Task performed by Semaphore Thread: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(); // Release the permit
        }
    }
}
//------------------------------------------------------------------------------------
class SharedResource5 { // CountDownLatch
    private CountDownLatch latch = new CountDownLatch(1);

    public void performTask() {
        // Code to be executed before the latch countdown
        System.out.println("Task preparation by Thread: " + Thread.currentThread().getName());
        latch.countDown(); // Countdown the latch
    }

    public void waitForTask() throws InterruptedException {
        latch.await(); // Wait for the latch countdown
        // Code to be executed after the latch countdown
        System.out.println("Task performed by CountDownLatch Thread: " + Thread.currentThread().getName());
    }
}
