package thread_scheduledexecutorservice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Exercise {

	public static void main(String[] args) {

		ScheduledExecutorService task = Executors.newSingleThreadScheduledExecutor();

		Runnable thread1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("We");
			}
		};

		Runnable thread2 = new Runnable() {
			@Override
			public void run() {
				System.out.println("are");
			}
		};

		Runnable thread3 = new Runnable() {
			@Override
			public void run() {
				System.out.println("the");
			}
		};

		Runnable thread4 = new Runnable() {
			@Override
			public void run() {
				System.out.println("people!\n");
			}
		};
		
		
		
	    task.scheduleAtFixedRate(thread1, 0, 8, TimeUnit.SECONDS); // the first parameter is for how long wait to start, the second one is an interval between;
	    task.scheduleAtFixedRate(thread2, 1, 8, TimeUnit.SECONDS);
	    task.scheduleAtFixedRate(thread3, 2, 8, TimeUnit.SECONDS);
	    task.scheduleAtFixedRate(thread4, 3, 8, TimeUnit.SECONDS);
	    
/*
		task.schedule(thread1, 1, TimeUnit.SECONDS); // NOTE: method 'schedule' is for only one time task at a scheduled
														// time
		task.schedule(thread2, 2, TimeUnit.SECONDS);
		task.schedule(thread3, 3, TimeUnit.SECONDS);
		task.schedule(thread4, 4, TimeUnit.SECONDS); */

		try {
			Thread.sleep(15000);
		} // the duration of the whole action
		catch (InterruptedException e) {
			e.printStackTrace();
		}

		task.shutdown(); // always used to cancel any further submitting ,
		try {
			task.awaitTermination(1, TimeUnit.HOURS);
		} // always used to make sure the task is done, like 'scanner.close;'
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
