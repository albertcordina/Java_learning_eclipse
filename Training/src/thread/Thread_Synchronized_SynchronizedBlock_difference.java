package thread;
/*
 * Both methods simulate some task using Thread.sleep(2000) 
 * to make it clear when the threads enter and exit the synchronized sections.

Key differences are the Granularity of Locking:

Synchronized Method: Locks the entire method, preventing other threads from executing
                     any synchronized method of the same object.
Synchronized Block:  Locks only the specific block of code, allowing other threads to access 
                     other synchronized blocks of the same object concurrently.
And the Lock Object:

Synchronized Method: The lock is implicitly associated with the object on which the method is called (this in most cases).
Synchronized Block: The lock is explicitly specified using the synchronized block's parameter.

It's a good practice to use synchronized blocks when you need more fine-grained control over 
 locking or when locking a smaller portion of the code is sufficient for your synchronization needs:
 
 */
class SharedResource {
	/*
	 * Synchronized method:
	 * In this approach, the entire method is marked as synchronized using the synchronized keyword. 
	 * When a thread enters a synchronized method, it acquires the lock for the entire object, preventing 
	 * other threads from entering any synchronized method of the same object until the lock is released.
	 */
    public synchronized void synchronizedMethod() {  
        System.out.println("Start of synchronized method by Thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000); // Simulate some additional task
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End of synchronized method by Thread: " + Thread.currentThread().getName());
    }
    
    /*
     * Synchronized block:
     * In this approach, a specific block of code is marked as synchronized using the synchronized keyword 
     * followed by an object or a class instance. When a thread enters a synchronized block, it acquires 
     * the lock associated with the specified object, allowing other threads to access other synchronized 
     * blocks of the same object concurrently.
     */
    public void synchronizedBlock() {
    	
    	System.out.println("non-critical part (before the synchronizedBlock):");
    	for (int i = 0; i < 2; i++) {System.out.println(i);}
    	
        synchronized (this) {
            System.out.println("\nStart of synchronizedBlock by Thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000); // Simulate some additional task
            	System.out.println("critical part (the synchronizedBlock):");
            	for (int i = 3; i < 5; i++) {System.out.println(i);}
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("End of synchronizedBlock by Thread: " + Thread.currentThread().getName());
            
        	System.out.println("non-critical part (after the synchronizedBlock):");
        	for (int i = 11; i < 13; i++) {System.out.println(i);}
        }
    }
}

public class Thread_Synchronized_SynchronizedBlock_difference {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        // Creating multiple threads to access the shared resource
        Thread thread1 = new Thread(() -> sharedResource.synchronizedMethod());
        Thread thread2 = new Thread(() -> sharedResource.synchronizedBlock());

        // Start the threads
        thread1.start();
        thread2.start();
    }
}
