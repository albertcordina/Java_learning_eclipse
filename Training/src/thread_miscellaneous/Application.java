package thread_miscellaneous;

/*
 * Two ways of creating threads:
 * 
 * 1. Extending Thread class -
 * 2. Implementing Runnable class -
 */

public class Application {
	int number = 0;

	public synchronized void numberIncrementation() { // 'synchronized' is important to have a stable run of the program 
		number++;                                    //  for a usage by many users at the same time;
	}                                               // in this case, 'synchronized' make the two 'run' methods to run simultaneously; 
//---------------------------------------------------------------------
	public static void main(String[] args) {
		
		Application app = new Application ();
		app.multipleThread(); // since there is only one shared variable 'number', the result of 
                             // the two methods 'run' inside the two objects are added, i.e. the '40000';
	}
//---------------------------------------------------------------------
	public void multipleThread() {  
		
		Thread firstThread = new Thread(new Runnable() {
			public void run() {
				for (int n = 0; n < 20000; n++) { numberIncrementation(); }
			}
		});

		Thread secondThread = new Thread(new Runnable() {
			public void run() {
				for (int n = 0; n < 20000; n++) { numberIncrementation(); }
			}
		});

		firstThread.start();   // start() method causes this thread to begin execution, the Java Virtual Machine calls the run method of this thread. 
		secondThread.start(); // The result is that two threads are running concurrently: the current thread (which returns from the call to the start method) 
                             // and the other thread (which executes its run method).
		try {
			firstThread.join();    // Join method in Java allows one thread to wait until another thread completes its execution.   
			secondThread.join(); } // In simpler words, it means it waits for the other thread to die. It has a void type and throws InterruptedException.
		
		catch (InterruptedException e) { System.out.println(e); }
		System.out.println("Number is: " + number);
	}
}
