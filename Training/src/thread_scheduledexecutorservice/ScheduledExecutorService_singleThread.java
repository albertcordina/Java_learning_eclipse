package thread_scheduledexecutorservice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/*
 * fixed-size thread executor creates an executor with only one thread, so it can only execute one task at a time.
 */
public class ScheduledExecutorService_singleThread { // one Thread with many tasks

	public static void main(String[] args) {

		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor(); 
		//-------------------------------------------------------------------------------------	
		Runnable repeatedTask = new Runnable () {

			@Override
			public void run() { System.out.println("Repeated task.");}			
		};  // the method 'scheduleAtFixedRate' is for a multiple tasks within the sleep time below
		executor.scheduleAtFixedRate(repeatedTask, 0, 3, TimeUnit.SECONDS);// the first parameter is for how long wait to start
	//-------------------------------------------------------------------------------------	
		Runnable singleTask = new Runnable () {

			@Override
			public void run() { System.out.println("Delayed task.");}		
		};
		executor.schedule(singleTask, 22, TimeUnit.SECONDS); // NOTE: method 'schedule' is for only one time task at a scheduled time
	    executor.scheduleAtFixedRate(singleTask, 1, 3, TimeUnit.SECONDS); // the Threads of the many other Runnalbe objects can also 
		// work concurrently or can be set the way we want them to be executed;

	//-------------------------------------------------------------------------------------	
		try { Thread.sleep(15000);} // the duration of the whole action
		catch (InterruptedException e) { e.printStackTrace();}
		
		executor.shutdown();  // always used to cancel any further submitting ,
		try { executor.awaitTermination(1, TimeUnit.HOURS);}  // always used to make sure the task is done, like 'scanner.close;'
		catch (InterruptedException e) { e.printStackTrace();}
	}
}
/*
 * Creates a single-threaded executor that can schedule commands to run after a given delay, or to execute periodically. 
 * (Note however that if this single thread terminates due to a failure during execution prior to shutdown, a new one will 
 * take its place if needed to execute subsequent tasks.) Tasks are guaranteed to execute sequentially, and no more than one task
 * will be active at any given time. Unlike the otherwise equivalent newScheduledThreadPool(1) the returned executor is guaranteed
 * not to be reconfigurable to use additional threads.

Returns:
the newly created scheduled executor
*/