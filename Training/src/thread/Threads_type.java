package thread;

/*
 * 
 *  Threads are performing action;
 *  Accepted value of priority for a thread is in range of 1 to 10. There are 3 static variables defined in Thread class for priority.
public static int MIN_PRIORITY: This is minimum priority that a thread can have. Value for this is 1.
public static int NORM_PRIORITY: This is default priority of a thread if do not explicitly define it. Value for this is 5.
public static int MAX_PRIORITY: This is maximum priority of a thread. Value for this is 10.

Thread with highest priority will get execution chance prior to other threads. 
Suppose there are 3 threads t1, t2 and t3 with priorities 4, 6 and 1. So, thread t2 
will execute first based on maximum priority 6 after that t1 will execute and then t3.
Default priority for main thread is always 5, it can be changed later. 
Default priority for all other threads depends on the priority of parent thread.
 *  
 *  If two threads have same priority then we can’t expect which thread will execute first.
 *  
 *   At any given time, the highest priority thread is running. However, this is not guaranteed. 
 *   The thread scheduler may choose to run a lower priority thread to avoid starvation. 
 *   For this reason, use priority only to affect scheduling policy for efficiency purposes.
 *   
 *   A higher priority thread has a better chance of being executed before lower priority threads. 
 *   However, it's important to remember that priority alone does not determine the order of thread execution.
 *   
 *   
 */


public class Threads_type implements Runnable { // interface 'Runnable' contains mehtod 'run'; We can use many interfaces at the same time;
	
	public void run () { System.out.println("Thread1 class implements Runnable interface"); }

	public static void main(String[] args) {

		Threads_type thread1 = new Threads_type();   // we create object 'thread1';
		Thread t1 = new Thread (thread1); // converting it into thread 't1';
		t1.start();	
	}
}

//-------------------------------------------------------------------------
class Thread2 extends Thread { // you cannot extend another class ('extends' is only for something one);
	
	public void run () { System.out.println("Thread2 class extends Thread class."); }
	
	public static void main(String[] args) {
		
		Thread2 thread2 = new Thread2();
		thread2.start();
	}
}
//------------------------------------------------------------------------
 class ThereadSafe {
	 private int counter = 0;
	 
	 public synchronized int nextCounter () {
		 return counter ++;
	 }
 }
