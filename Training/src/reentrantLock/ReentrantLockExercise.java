package reentrantLock;
import java.util.concurrent.locks.*;
import java.util.concurrent.locks.ReentrantLock;
public class ReentrantLockExercise {
	
    private int sharedResource = 0;
    private final Lock resourceLock = new ReentrantLock(); // create instance of ReentrantLock
    
    public static void main(String[] args) {
    	
        ReentrantLockExercise rl = new ReentrantLockExercise(); 
        int numIncrementThreads = 3;
        int numDecrementThreads = 2;
        
        Thread[] threads = new Thread[numIncrementThreads +
                numDecrementThreads];
        
        //Two loops are used to create instances of IncrementThread and DecrementThread classes and store them in the threads array.   
        for (int i = 0; i < numIncrementThreads; i++) { // Initialize and store increment threads
            threads[i] = rl.new IncrementThread();}
        
        for (int i = 0; i < numDecrementThreads; i++) { // Initialize and store decrement threads
            threads[numIncrementThreads + i] = rl.new DecrementThread();}
        
        for (Thread thread : threads) { thread.start();} // Start all threads
        
        for (Thread thread : threads) { // Wait for all threads to finish
            try { thread.join();}
            catch (InterruptedException e) { e.printStackTrace();}
        }
        System.out.println("Final Shared Resource Value: " + rl.sharedResource);
    }
    
 //------------------------------------------------------------------------------------   
    class IncrementThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                resourceLock.lock();
                try {
                    System.out.println("incremeting threads");
                    sharedResource += 5; } 
                finally { resourceLock.unlock();}
            }
        }
    }
    class DecrementThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) { 
            	resourceLock.lock();
                try {
                    System.out.println("decrementing threads");
                    sharedResource -= 3; } 
                finally { resourceLock.unlock();}
            }
        }
    }
}