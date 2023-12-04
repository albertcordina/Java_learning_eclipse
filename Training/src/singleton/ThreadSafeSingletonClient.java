package singleton;

class ThreadSafeSingletonExample {

    // The single instance of the class
    private static ThreadSafeSingletonExample instance;

    // Private constructor to prevent instantiation from outside the class
    private ThreadSafeSingletonExample() {}

    // Double-checked locking mechanism to ensure thread safety
    public static ThreadSafeSingletonExample getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingletonExample.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingletonExample();
                }
            }
        }
        return instance;
    }

    // The method to demonstrate the usage of the Singleton instance
    public void displayMessage() {
        System.out.println("Hello, this is the ThreadSafeSingletonInstance!");
    }
}
public class ThreadSafeSingletonClient {

    public static void main(String[] args) {
    	
        // Create multiple threads, each trying to obtain and display the message from the Singleton instance
        Thread thread1 = new Thread(() -> {
            ThreadSafeSingletonExample singletonInstance = ThreadSafeSingletonExample.getInstance();
            singletonInstance.displayMessage();
        });

        Thread thread2 = new Thread(() -> {
            ThreadSafeSingletonExample singletonInstance = ThreadSafeSingletonExample.getInstance();
            singletonInstance.displayMessage();
        });

        // Start the threads
        thread1.start();
        thread2.start();
    }
}
