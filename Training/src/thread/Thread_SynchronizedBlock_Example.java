package thread;
/*
 * In Java, synchronized blocks provide a way to control access to a shared resource within a 
 * specific block of code. Here's a simple example demonstrating the use of a synchronized block:
 */
class SharedResource7 {
	
    private int sharedVariable = 0;

    public void performTask() {
        // Some non-critical section code here
        System.out.println(Thread.currentThread().getName() + " non-critical code beginning.");
        // Synchronized block ensures only one thread can execute it at a time
        synchronized (this) {
            // Code to be executed in a synchronized manner
            sharedVariable++;
            System.out.println(Thread.currentThread().getName() + " incremented sharedVariable to: " + sharedVariable);
        }

        // Some non-critical section code here
        System.out.println(Thread.currentThread().getName() + " some code at the end.");
    }
}
/*
 * In this example:

The SharedResource class has a method called performTask.
Inside the performTask method, there is a synchronized block using synchronized (this). 
This means that only one thread can execute this block at a time for the same instance 
of the SharedResource object (this). The shared variable sharedVariable is incremented 
within the synchronized block, ensuring that the increment operation is atomic and 
mutually exclusive between threads. The output will show that the sharedVariable is 
incremented in a thread-safe manner.

Note: It's important to use synchronization cautiously to avoid performance issues and deadlocks. 
Synchronized blocks should be used only where necessary to protect shared resources. 
In some cases, using higher-level concurrency utilities, 
such as java.util.concurrent classes, might be more appropriate.
 */
public class Thread_SynchronizedBlock_Example {
    public static void main(String[] args) {
        SharedResource7 sharedResource = new SharedResource7();

        // Creating multiple threads to access the shared resource
        Thread thread1 = new Thread(() -> sharedResource.performTask());
        Thread thread2 = new Thread(() -> sharedResource.performTask());
        Thread thread3 = new Thread(() -> sharedResource.performTask());

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

