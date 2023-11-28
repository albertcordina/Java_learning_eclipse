package thread;

public class Thread_ConcurrentMethodsExample {
/*
 * If you want to run different methods or blocks of code concurrently, you can define those 
 * methods or blocks of code in the run method of your Thread or Runnable implementation. 
 * Here's a simple example where two threads run different methods concurrently:	
 */
    public static void main(String[] args) {
    	
        // Create two threads with different tasks
        Thread thread1 = new Thread(() -> { printNumbers("Thread 1", 4);});// Method 1
        Thread thread2 = new Thread(() -> { printLetters("Thread 2", 4);});// Method 2

        // Start the threads
        thread1.start();
        thread2.start();
/*
 * The class "Thread_ConcurrentMethodsExample" doesn't extend Thread or implement Runnable directly. 
 * Instead, it creates instances of Thread and specifies the tasks using lambda expressions. 
 * This is a common approach when you have specific tasks to run in separate threads, 
 * and there's no need to create a dedicated class for each thread.        
 */
    }
/*
 * In this example:

The main method creates two threads, "thread1" and "thread2", each with a different task specified by 
the lambda expressions passed to their constructors."thread1" prints numbers using the printNumbers 
method, and "thread2" prints letters using the printLetters method.

Both threads are started concurrently using the start method.

Each method (printNumbers and printLetters) runs in its own thread, and they execute concurrently.
This example demonstrates how you can run different methods concurrently by assigning each method 
to a separate thread. Keep in mind that if the methods share data, you need to be careful about 
synchronization to avoid data inconsistencies.
 */
    private static void printNumbers(String threadName, int count) {
        System.out.println(threadName + " is printing numbers:");
        for (int i = 1; i <= count; i++) {
            System.out.println(threadName + ": " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printLetters(String threadName, int count) {
        System.out.println(threadName + " is printing letters:");
        for (char c = 'A'; c <= 'A' + count - 1; c++) {
            System.out.println(threadName + ": " + c);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

