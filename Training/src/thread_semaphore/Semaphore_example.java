package thread_semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Semaphore_example {

	public static void main(String[] args) throws InterruptedException { // Exception in the method is only for the checked Exceptions

		ExecutorService executor = Executors.newCachedThreadPool(); // only for the large number of Threads;
		
		for (int n = 0; n < 25; n++) {executor.submit( new Runnable() { // sends 25 messages at the same time; the whole package
			
			@Override  
			public void run () {Messages.getValue().send();}
			
		    });
		}
		executor.shutdown();
		executor.awaitTermination(5, TimeUnit.HOURS);	
	}
}

//---------------------------------------------------------------------------------------------------
class Messages {

	private int messages = 0;
	
	private static Messages value = new Messages (); // to make the data as private as possible
	private Semaphore semaphore = new Semaphore (20); // set a limit to 20 threads can be locked and unlocked   
	
	private Messages () {}
	
	public static Messages getValue () {return value;} // for privicy
	
	public void send () {
							try { semaphore.acquire();} // sends the only 20 messages according to the 'Semaphore' above
			        catch (InterruptedException e1) {e1.printStackTrace();}
	
	
	try {sendMsg ();} // call the method 'sendMsg' below
	finally {semaphore.release();}
}
	
	public void sendMsg () {
					synchronized (this) { // 'synchronized' is always combined only with the objects or methods
			        messages++;
			        System.out.println("Current messages: " + messages);}
		
		try { Thread.sleep(2000);} // the pouses the action for 2 sec.
		catch (InterruptedException e) {e.printStackTrace();}
		
		synchronized (this) {messages--;}
		semaphore.release();
	}
}
