package thread_miscellaneous;
import java.util.*;

public class SimpleThreadExercise {

	public static void main(String[] args) {

		SimpleThread simpleThread1 = new SimpleThread ();
		SimpleThread simpleThread2 = new SimpleThread ();
		SimpleThread simpleThread3 = new SimpleThread ();
       
		simpleThread1.start(); // method 'start' is always run in the main method
		simpleThread2.start(); // it activates the 'run' method via the object(s) of the class where the 'run' method is.
		simpleThread3.start();

	try {
		simpleThread1.join();
		simpleThread2.join();
		simpleThread3.join();
	}catch (InterruptedException e) { System.out.println("Main thread is interrupted");} // if an Error;
		System.out.println("Main thread is done."); // report a successful operation;
	}
}

class SimpleThread extends Thread {
	
	public void run () {
		Random random = new Random();
		int randomNumber = random.nextInt(100);
		System.out.println(getName() + " generated random number: " + randomNumber);
	}
}
