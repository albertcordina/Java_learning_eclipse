package thread_synchronizedRules;
import java.util.*; 
class Calculations1 {  

	private Random random = new Random ();
	
	private Object firstBlock = new Object (); // smoller scope, faster speed than with methods;
	private Object secondBlock = new Object ();

	
	private List <Integer> firstList = new ArrayList<>();
	private List <Integer> secondList = new ArrayList<>();
	
//-------------------------------------------------------------
	public synchronized void firstCalculation () {
    synchronized (firstBlock) {
		try {
			Thread.sleep(1);
		} catch (Exception e) {System.out.println(e);}
	
	firstList.add(random.nextInt(200));
	  }
	}
	
	public synchronized void secondCalculation () {
		synchronized (secondBlock) {
		try {
			Thread.sleep(1);
		} catch (Exception e) {System.out.println(e);}
		
		secondList.add(random.nextInt(200));
	  }	
	}
//-------------------------------------------------------------	
	
	public void calculating () {
		for (int i = 0; i < 500; i++) {
			firstCalculation();
			secondCalculation();}
	}
	
	public void main () {
		
		System.out.println("Started...");
		long started = System.currentTimeMillis();
		
		Thread thread1 = new Thread (new Runnable() { 
			
			public void run () { calculating ();}
			
		});
		
		Thread thread2 = new Thread (new Runnable() {
			
			public void run () { calculating ();}
			
		});
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();} 
		catch (InterruptedException e) {System.out.println(e);}
		
		long ended = System.currentTimeMillis();
		System.out.println("Duration: " + (ended - started));
		System.out.println("First list: " + firstList.size() + " Second list: " + secondList.size());
		
	}
}
//------------------------------------------------------
public class Synchronized_object {
	
	public static void main(String[] args) {
		
		Calculations1 cal = new Calculations1();
		cal.main();
		
	}
}
