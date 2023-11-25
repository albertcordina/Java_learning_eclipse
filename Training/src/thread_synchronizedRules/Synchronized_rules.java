package thread_synchronizedRules;
import java.util.*; 
class Calculations {

	private Random random = new Random ();
	
	private List<Integer> firstList = new ArrayList<>();
	private List<Integer> secondList = new ArrayList<>();
//--------------------------------------------------
//   THE 'SYNCHRONIZED' MAKES THE TWO OR MORE METHODS TO BE CALLED AND OUTCOMED CONCURRENTLY/i.e. AT THE SAME TIME:
	
	public synchronized void firstCalculation () {
		
		try { Thread.sleep(1);} //  we give a pause before we add a random number to the first List;
		catch (Exception e) {System.out.println(e);}
	
	firstList.add(random.nextInt(200));
	}
	
	public synchronized void secondCalculation () {
		
		try { Thread.sleep(1); } //  we give a pause before we add a random number to the second List;
		catch (Exception e) {System.out.println(e);}
		
		secondList.add(random.nextInt(200));
	}	
//--------------------------------------------------	
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
public class Synchronized_rules {
	
	public static void main(String[] args) {
		
		Calculations cal = new Calculations();
		cal.main();
		
	}
}
