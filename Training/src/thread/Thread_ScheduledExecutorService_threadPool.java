package thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/*
 * 'ExecutorService' provides mechanisms for safely starting, closing down, submitting, executing,
 *  and blocking on the successful or abrupt termination of tasks (expressed as Runnable or Callable).
 */
public class Thread_ScheduledExecutorService_threadPool {

	public static void main(String[] args) { // we can specify also the delay time of Thread

		ScheduledExecutorService executor = Executors.newScheduledThreadPool(2); // 2 Threads can be executed at the same time
	//-------------------------------------------------------------------------------------------	
		Runnable repeatedTask = new Runnable() { // create instance of Runnable interface

			@Override
			public void run() { System.out.println("Beep");}		
		};
	//-------------------------------------------------------------------------------------------	
		Runnable singleTask = new Runnable () { // create instance of Runnable interface

			@Override
			public void run() { System.out.println("One-time task");}		
		};
	//-------------------------------------------------------------------------------------------	
		executor.scheduleAtFixedRate(repeatedTask, 0, 3, TimeUnit.SECONDS); // the first parameter is for how long wait to start, the second one is an interval inbetween;
		executor.schedule(singleTask, 6, TimeUnit.SECONDS);
		
		try { Thread.sleep(15000);} // sleep can be used for specifiying the time for how long the Thread is active
		catch (InterruptedException e) { e.printStackTrace();}	
		
		executor.shutdown(); // if there is a further code, the method 'shutdown' is not nessessary
		try { executor.awaitTermination(1, TimeUnit.HOURS);} // always used to make sure the task is done, like 'scanner.close;'
		catch (InterruptedException e) { e.printStackTrace();}			
	}
}
/*
 * The ScheduledExecutorService in Java is a higher-level replacement for the traditional Timer class 
 * and provides more flexibility and control over the scheduling of tasks. However, it doesn't replace 
 * all types of threads.

The ScheduledExecutorService is specifically designed for scheduling tasks to run periodically or after 
a certain delay. It's great for scenarios where you need to execute tasks at fixed intervals or with a 
delay. It's particularly useful for background tasks, periodic maintenance, and similar scenarios.

However, it doesn't replace all types of threads. Threads in Java are more general-purpose and can be 
used for a wide range of concurrency scenarios. For example:

Worker Threads: If you have a more complex concurrency scenario where you need to manage multiple threads 
                doing different tasks concurrently, ScheduledExecutorService may not be sufficient. 
                You might need to create and manage your threads explicitly.

Thread Pools: While ScheduledExecutorService provides a form of thread pooling for scheduling tasks, if 
              you have a more complex application with various types of tasks, you might need a more 
              sophisticated thread pool. ExecutorService provides a more general-purpose thread pool 
              that can handle different types of tasks.

Asynchronous Programming: If you are dealing with asynchronous programming, where you want to perform 
                          tasks concurrently without blocking the main thread, you might use features like 
                          CompletableFuture or the ExecutorService directly for more fine-grained control.

Custom Thread Management: If you need low-level control over thread management, such as manipulating thread 
                          priorities, creating custom thread groups, or dealing with more advanced synchronization 
                          scenarios, you would need to work directly with threads.

In summary, while ScheduledExecutorService is a powerful tool for scheduling periodic tasks, it doesn't replace 
all use cases for threads. Depending on the complexity and requirements of your application, you might still need 
to use threads directly or other concurrency utilities provided by Java.

 * 
 * 
 */