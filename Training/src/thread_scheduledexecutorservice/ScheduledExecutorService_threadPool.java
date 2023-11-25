package thread_scheduledexecutorservice;
// 'ExecutorService' provides mechanisms for safely starting, closing down, submitting, executing, 
// and blocking on the successful or abrupt termination of tasks (expressed as Runnable or Callable).
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/*
 * fixed-size thread executor creates an executor with only one thread, so it can only execute one task at a time.
 */
public class ScheduledExecutorService_threadPool {

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

