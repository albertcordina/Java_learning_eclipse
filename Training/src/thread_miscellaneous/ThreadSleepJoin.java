package thread_miscellaneous;

class ThreadExample extends Thread {

	public void run () {
		for (int n = 1; n < 3; n++) {
			try {
				Thread.sleep(900); // '900' miliseconds of pause between the threads; method 'sleep' is mostly used;
				System.out.println("Current thread: " + Thread.currentThread().getName()); } // no need to write a text;
			catch (InterruptedException e) { System.out.println(e); }
			System.out.println(n);
		}		
	}
}

public class ThreadSleepJoin {

	public static void main(String[] args) {

		ThreadExample thread1 = new ThreadExample();
		ThreadExample thread2 = new ThreadExample();
		ThreadExample thread3 = new ThreadExample();	
	
	try {
		 System.out.println("Current thread: " + Thread.currentThread().getName());  // no need to write a text;
	thread1.join();}  //  'join' method is like a 'sleep' method above;
	catch (Exception e) { System.out.println(e); }
	
    thread1.start();
	
	
	try {
		 System.out.println("Current thread: " + Thread.currentThread().getName());  // no need to write a text;
	thread2.join();}  //  'join' method is like a 'sleep' method above;
	catch (Exception e) { System.out.println(e); }
	
	thread2.start();
 

	try {
		 System.out.println("Current thread: " + Thread.currentThread().getName());  // no need to write a text;
	thread3.join();}  //  'join' method is like a 'sleep' method above;
	catch (Exception e) { System.out.println(e); }
	
	thread3.start();
  }	
}	


	

