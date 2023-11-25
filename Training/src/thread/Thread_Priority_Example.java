package thread;
/*
 *  In Java, threads can be assigned priorities ranging from Thread.MIN_PRIORITY (1) 
 *  to Thread.MAX_PRIORITY (10), with Thread.NORM_PRIORITY (5) as the default. 
 *  The thread scheduler uses these priorities to determine the order in which 
 *  threads are scheduled for execution. A higher-priority thread is more 
 *  likely to be scheduled before a lower-priority thread.
 */
class PriorityTask implements Runnable {
    private String name;

    public PriorityTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + " - Count: " + i + " - Priority: " + Thread.currentThread().getPriority());
            // Simulate some work
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
/*
 * In this example:

Two threads (Thread A and Thread B) are created, each running a PriorityTask.
The setPriority method is used to set the priorities of the threads. 
Thread.MAX_PRIORITY is 10, and Thread.MIN_PRIORITY is 1.
The run method of PriorityTask prints messages along with the current count and thread priority.
Keep in mind that thread priorities are platform-dependent, and their effectiveness might vary across 
different systems. It's generally a good practice not to rely too heavily on thread priorities for 
critical application behavior, as they may not provide consistent results across different platforms.
 */
public class Thread_Priority_Example {
	
    public static void main(String[] args) {
    	
        Thread thread1 = new Thread(new PriorityTask("Thread A"));
        Thread thread2 = new Thread(new PriorityTask("Thread B"));

        // Set thread priorities
        thread1.setPriority(Thread.MIN_PRIORITY); // Priority 1
        thread2.setPriority(Thread.MAX_PRIORITY); // Priority 10

        // Start the threads
        thread1.start();
        thread2.start();
    }
}
