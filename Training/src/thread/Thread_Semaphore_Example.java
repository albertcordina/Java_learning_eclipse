package thread;

import java.util.concurrent.Semaphore;
/*
 * The Semaphore class in Java is a synchronization aid that allows a specified number of threads 
 * to access a resource concurrently. Semaphores are often used to control access to a resource 
 * in a multithreaded environment. Here's a simple example demonstrating the use of a Semaphore:
 */
class SharedResource6 {
    private Semaphore semaphore = new Semaphore(2); // Allow 2 threads to access the resource concurrently

    public void accessResource() {
        try {
            semaphore.acquire(); // Acquire a permit from the semaphore
            // Code to be executed with the acquired permit
            System.out.println("Thread " + Thread.currentThread().getName() + " is accessing the resource.");
            Thread.sleep(2000); // Simulate some work
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(); // Release the permit back to the semaphore
            System.out.println("Thread " + Thread.currentThread().getName() + " released the permit.");
        }
    }
}
/*
 * In this example:

The SharedResource class has a Semaphore with a permit count of 2, meaning up to 2 threads can access 
the resource concurrently. The accessResource method is called by multiple threads. Before accessing 
the resource, a thread must acquire a permit from the semaphore using semaphore.acquire(). 
The semaphore.release() method is called in the finally block to release the permit when the thread 
is done using the resource. Output may vary, but you should see that only two threads access 
the resource concurrently due to the semaphore's permit count.

Note: The Thread.sleep(2000) in the accessResource method is used to simulate some work being done by the 
threads. In a real-world scenario, this could be replaced with the actual work that needs to be synchronized.
 */
public class Thread_Semaphore_Example {
    public static void main(String[] args) {
        SharedResource6 sharedResource = new SharedResource6();

        // Creating multiple threads to access the shared resource
        Thread thread1 = new Thread(() -> sharedResource.accessResource());
        Thread thread2 = new Thread(() -> sharedResource.accessResource());
        Thread thread3 = new Thread(() -> sharedResource.accessResource());
        Thread thread4 = new Thread(() -> sharedResource.accessResource());

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}

