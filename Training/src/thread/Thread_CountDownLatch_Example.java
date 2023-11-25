package thread;

import java.util.concurrent.CountDownLatch;
/*
 * CountDownLatch is a synchronization aid provided by Java's concurrency utilities. 
 * It allows one or more threads to wait until a set of operations being performed 
 * in other threads completes. The count is decremented each time a thread finishes 
 * its operation, and when the count reaches zero, the waiting threads are released.
 * 
 */
class Worker implements Runnable {
	
	private final String name;
	private final CountDownLatch latch;

	public Worker(String name, CountDownLatch latch) {
		this.name = name;
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println(name + " is performing its task.");
		try {
			Thread.sleep(2000); // Simulate some task
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name + " has completed its task.");
		latch.countDown(); // Signal that this worker has completed its task
	}
}
/*
 * In this example:
 * 
The Worker class represents a worker thread that performs a task (simulated by sleeping
for 2 seconds) and then counts down the latch. The CountDownLatch is initialized with 
the number of workers (in this case, 3). Each worker is started in a separate thread.
The main thread waits for all workers to complete their tasks using latch.await().
Once all workers have completed their tasks, the main thread continues its execution.
This is a basic example, but in real-world scenarios, CountDownLatch can be useful for
coordinating the startup or shutdown of components in a concurrent system or waiting 
for the completion of multiple parallel tasks before proceeding with further processing.
 */
public class Thread_CountDownLatch_Example {
	
	public static void main(String[] args) throws InterruptedException {
		
		int numberOfWorkers = 3;
		CountDownLatch latch = new CountDownLatch(numberOfWorkers);

		for (int i = 1; i <= numberOfWorkers; i++) {
			Thread workerThread = new Thread(new Worker("Worker " + i, latch));
			workerThread.start();
		}

		// Wait until all workers complete their tasks
		latch.await();

		// All workers have completed their tasks, main thread continues
		System.out.println("All workers have completed their tasks. Main thread continues.");
	}
}