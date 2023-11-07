package atomic_variables;

import java.util.concurrent.atomic.AtomicInteger;

/*
 * 'AtimicInteger' makes sure that the two threads are working together properly 
 *  All the subsiquent threads are waiting to be reviewed by the 'AtimicInteger', 
 *  and then all of them get executed at the same time.	
 *  
 *  AtomicInteger extends Number and implements the Sir
 *  java.util.concurrent.atomic.AtomicInteger
 */

class Counter extends Thread {
	
//	AtomicInteger count;                         
//	Counter () { count = new AtomicInteger();}
	AtomicInteger count = new AtomicInteger (); // a short way of the above
	
	public void run () { for (int n = 0; n < 30000; n++ ) { count.addAndGet(1);} // parameter of 'addAndGet' method is
	}                                                                           // for a number of the sessions to execute
}

public class AtomicInteger_rules {

	public static void main(String[] args) throws InterruptedException { // 'throws' is only for checked Exceptions
		
		Counter counter = new Counter ();
		
		Thread thread1 = new Thread (counter, "Thread1"); // 
		Thread thread2 = new Thread (counter, "Thread2");
		// the both threads are working at the same time in case of using a simple int in stead of the AtimicInteger
		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();
		
		System.out.println(counter.count);
	}
}
/*
 * AtomicInteger Methods
Following is the list of important methods available in the AtomicInteger class.

Sr.No.	Method & Description
1	
public int addAndGet(int delta)

Atomically adds the given value to the current value.

2	
public boolean compareAndSet(int expect, int update)

Atomically sets the value to the given updated value if the current value is same as the expected value.

3	
public int decrementAndGet()

Atomically decrements by one the current value.

4	
public double doubleValue()

Returns the value of the specified number as a double.

5	
public float floatValue()

Returns the value of the specified number as a float.

6	
public int get()

Gets the current value.

7	
public int getAndAdd(int delta)

Atomiclly adds the given value to the current value.

8	
public int getAndDecrement()

Atomically decrements by one the current value.

9	
public int getAndIncrement()

Atomically increments by one the current value.

10	
public int getAndSet(int newValue)

Atomically sets to the given value and returns the old value.

11	
public int incrementAndGet()

Atomically increments by one the current value.

12	
public int intValue()

Returns the value of the specified number as an int.

13	
public void lazySet(int newValue)

Eventually sets to the given value.

14	
public long longValue()

Returns the value of the specified number as a long.

15	
public void set(int newValue)

Sets to the given value.

16	
public String toString()

Returns the String representation of the current value.

17	
public boolean weakCompareAndSet(int expect, int update)

Atomically sets the value to the given updated value if the current value is same as the expected value.

https://www.tutorialspoint.com/java_concurrency/concurrency_atomic_integer
 * 
 */
