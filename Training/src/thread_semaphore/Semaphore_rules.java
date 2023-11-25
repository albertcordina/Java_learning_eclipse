package thread_semaphore;
import java.util.*;
import java.util.concurrent.Semaphore;
public class Semaphore_rules {

	public static void main(String[] args) {

		Semaphore semaphore = new Semaphore (5); // restricts the number of shared data. to limit the number of Threads
		
		semaphore.release(); // increments the number of permits
		
		try { semaphore.acquire(); } // reduses the number of available permits by one
		catch (InterruptedException e) { e.printStackTrace(); } 
		
		System.out.println("Number of permits: " + semaphore.availablePermits());
	}
}
