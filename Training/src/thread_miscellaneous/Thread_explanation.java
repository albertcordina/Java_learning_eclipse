package thread_miscellaneous;

public class Thread_explanation {
/*
 *  the Thread class is a fundamental part of concurrent programming. 
 *  The main function of the Thread class is to provide a way to create 
 *  and manage threads, which are the smallest units of execution in a program. 
 *  Threads allow concurrent execution of tasks, enabling programs to perform multiple activities simultaneously.
 *  
 *  Thread Lifecycle: Threads go through different states in their lifecycle, including NEW, RUNNABLE, BLOCKED, 
 *  WAITING, TIMED_WAITING, and TERMINATED. The start() method transitions a thread from NEW to RUNNABLE, 
 *  and the run() method contains the code that will be executed when the thread is running.

Multithreading: allows multiple threads to execute concurrently within the same program. It is useful for 
improving the performance of certain types of applications, such as those that involve parallelism or responsiveness.

Thread Synchronization: When multiple threads access shared resources, synchronization mechanisms, 
such as locks (synchronized keyword or ReentrantLock), are used to prevent race conditions and ensure data consistency.
The synchronized keyword can be used to synchronize methods or blocks of code to control access to critical sections.

Thread Priorities: Threads can be assigned priority values, ranging from Thread.MIN_PRIORITY to Thread.MAX_PRIORITY. 
However, thread priorities are platform-dependent and may not be strictly enforced.
Daemon Threads: is a thread that runs in the background and does not prevent the JVM from exiting when all 
non-daemon threads have completed. They are typically used for tasks that can be terminated abruptly.
 *  
 */
	public static void main(String[] args) {

		// Create and start the thread
		MyThread myThread1 = new MyThread();
		myThread1.start();
		
		// Create a thread and pass the Runnable to its constructor
		Thread myThread2 = new Thread(new MyRunnable());
		myThread2.start();
		
	}
}

class MyThread extends Thread {
    public void run() {
        // Code to be executed in the thread
    }
}

class MyRunnable implements Runnable {
    public void run() {
        // Code to be executed in the thread
    }
}



