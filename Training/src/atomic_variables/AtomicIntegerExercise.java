package atomic_variables;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExercise {
	
    public static void main(String[] args) {
    	
        // create an AtomicInteger named counter and initialize it with a value of 0.
        // This will serve as our shared counter
        AtomicInteger counter = new AtomicInteger(0);
        
        // Create multiple threads to increment and decrement the counter
        Thread incrementThread = new Thread(new IncrementTask(counter));
        Thread decrementThread = new Thread(new DecrementTask(counter));
        
        incrementThread.start();
        decrementThread.start();
        
        try {
            incrementThread.join();
            decrementThread.join();}
        catch (InterruptedException e) { e.printStackTrace();}
             
        int finalValue = counter.get(); // Get the final value of the counter
        System.out.println("Final counter value: " + finalValue);
    }
}
//------------------------------------------------------
class IncrementTask implements Runnable {
	
    private AtomicInteger counter;
    
    public IncrementTask(AtomicInteger counter) { this.counter = counter;}
    
    @Override
    public void run() { for (int i = 0; i < 30000; i++) { counter.incrementAndGet();} 
    }
}
//------------------------------------------------------
class DecrementTask implements Runnable {
	
    private AtomicInteger counter;
    
    public DecrementTask(AtomicInteger counter) { this.counter = counter;}
    
    @Override
    public void run() { for (int i = 0; i < 30000; i++) { counter.decrementAndGet();}
    
    }
}
