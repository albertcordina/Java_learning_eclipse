package callable_and_future_Interface;

import java.time.LocalDateTime;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/*
 * Callable is like Runnable and Thread but returns the result
 *  Future interface is to help us to store the return result
 */

class Task implements Callable <String> {

	private String name;
	public Task (String name) {this.name = name;}
	
	@Override
	public String call() throws Exception { // method 'call' is like 'run' for Runnable 
		System.out.println(name + " executed on: " + LocalDateTime.now().toString());
		return name;
	}	
}
public class Callable_and_Future_Interface_rules {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService task = Executors.newFixedThreadPool(1); // the parameter is the number of threads
		
		Future <String> future1 = task.submit(new Task ("Task1")); // Future interface is always combined with Callable
		Future <String> future2 = task.submit(new Task ("Task2")); // we create and submit the new Tasks, i.e. 'future1' and 'future2'

		String thread1 = future1.get();
		String thread2 = future2.get();
		
		System.out.println("thread completed: " + thread1);
		System.out.println("thread completed: " + thread2);
		
		task.shutdown();
		task.awaitTermination(4, TimeUnit.MINUTES);

	}
}
