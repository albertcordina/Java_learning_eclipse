package thread;

public class TaskManagementExercise {

	public static void main(String[] args) {
		
int numberOfWorkers = 5;

for (int i = 1; i <= numberOfWorkers; i++) { // we go through all workers;
	Worker worker = new Worker(i);  // we create object from class Worker as Thread with the list of all the workers (i);
	worker.start(); // we start the method run below for every worker;
		
	}
  }
}
//-----------------------------------------------------------------------
class Worker extends Thread {
	
	int workerId;

	public Worker(int workerId) { this.workerId = workerId;}

	public void run() {
		System.out.println("Worker " + workerId + " is performing a task.");

		try { Thread.sleep(1000);} 
		catch (InterruptedException e) { Thread.currentThread();}

		System.out.println("Worker " + workerId + " has completed the task.");
	}
}
