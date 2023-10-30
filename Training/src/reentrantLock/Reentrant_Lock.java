package reentrantLock;
import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ReentrantLockExample {
	/*
	 * 'ReentrantLock' - good alternative of synchronized block and methods. It is
	 * fast and it implements Lock, Serizable interface; To serialize an object
	 * means to convert its state to a byte stream so that the byte stream can be
	 * reverted back into a copy of the object;
	 * 
	 * wait() await()
	 */

	private int value = 0;
	private Lock lock = new ReentrantLock(); // create instance of class ReentrantLock via the superclass Lock;
	//private Condition condition = new lock.newCondition();

	private void increaseValue() {
		for (int n = 0; n < 2000; n++) { value++;}
	}
//------------------------------------------------------
	public void thread1() throws InterruptedException {

		lock.lock();  // <---  call the Lock class and the method - LOCK - in it;
		
		System.out.println("Waiting ...");
//		condition.await(); // 'await' hands over the execution in the Thread; therefore, it jumps to the method 'thread2' below;
		System.out.println("Another thread woke me up!");
		
		try { increaseValue(); }
		finally { lock.unlock(); } // <---  call the Lock class and the method - UNLOCK - in it;
	}

	
	public void thread2() throws InterruptedException {

		Thread.sleep(1000);
		lock.lock();  // <---  call the Lock class and the method - LOCK - in it;
		
		System.out.println("Press enter to continue.");
		new Scanner(System.in).nextLine(); // no need veriable for one enter action;
		
		System.out.println("You pressed enter!");
	//	condition.signal(); // method signal always works with unlock method below; Only signal can unlock the lock;
		
		try { increaseValue(); }
		finally { lock.unlock(); } // <---  call the Lock class and the method - UNLOCK - in it;
	}
//------------------------------------------------------
	public void finished() { System.out.println("Value is: " + value);}
}

//-------------------------------------------------------------------------------------
public class Reentrant_Lock {

	public static void main(String[] args) throws InterruptedException {

		ReentrantLockExample rl = new ReentrantLockExample();
//       ----------------------------------------
		Thread thread1 = new Thread(new Runnable() {

			public void run() {

				try { rl.thread1(); } 
				catch (InterruptedException e) { e.printStackTrace();}
			   }
		});
//      ----------------------------------------

		Thread thread2 = new Thread(new Runnable() {

			public void run() {

				try { rl.thread2(); } 
				catch (InterruptedException e) { e.printStackTrace();}
			}
		});
//      ----------------------------------------

		thread1.start();
		thread2.start();

		thread1.join();
		thread2.join();

		rl.finished();
	}
}
/*
 * Locking is a mechanism in Java that allows a thread to exclusively acquire a lock on an object or a class, preventing 
 * other threads from accessing the locked object or class until the lock is released.
 * 
 * ReentrantLock: This is the most widely used implementation class of Lock interface. 
 * This class implements the Lock interface in similar way as synchronized keyword. 
 * Apart from Lock interface implementation, ReentrantLock contains some utility 
 * methods to get the thread holding the lock, threads waiting to acquire the lock etc. 
 * synchronized block are reentrant in nature i.e if a thread has lock on the monitor 
 * object and if another synchronized block requires to have the lock on the same monitor 
 * object then thread can enter that code block. I think this is the reason for the class name to be ReentrantLock. 
 * 
 * https://www.digitalocean.com/community/tutorials/java-lock-example-reentrantlock
 * 
 */
