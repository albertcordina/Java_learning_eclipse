package thread_miscellaneous;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.*;
class Tasks implements Runnable {
	
	private int id;
	
	public Tasks (int id) { this.id = id;}
	
	public void run () {System.out.println("Task " + id + ": started...");
	
	try { Thread.sleep(50);} // we give a pause in between the tasks to be executed; i.e. if '0' --> all the taskes are executed at the same time;
	catch (InterruptedException e) {System.out.println(e);}
	System.out.println("Task " + id + ": is finished.");
  }
}

public class ThreadPool_rules {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(1); // 'ExecutorService' is executing many tasks with out insequents;
		// example: submitting a message to many users at ones;
		//'executor' is taking care of the action;
		
		for (int i = 1; i < 6; i++) { executor.submit(new Tasks(i));}
		
		executor.shutdown();  // 'shutdown' is only for finishing the submitting the task;
		System.out.println("Tasks are now submitted.");
		
		try { executor.awaitTermination(1, TimeUnit.MINUTES);} 
		catch (InterruptedException e) { e.printStackTrace();} // 'e.printStackTrace()' is similar to an ordinary message, see above;
		
		System.out.println("Tasks are now finished.");
	}
}
