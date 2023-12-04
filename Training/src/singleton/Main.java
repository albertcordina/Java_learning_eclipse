package singleton;
/*
 * Singleton class - means a class can have only one instance.
 * Spring helps to deal with singleton
 * 
 */

class Car {

	// static Car car = new Car(); // Step 1 (Instance)
	static Car car;

	private Car() { System.out.println("Instance created.");} // Step 2 (Constractor)

	public static Car getInstance() { // Step 3 (Method)

		if (car == null) { // double-check locking mechanism
			synchronized (Car.class) {
				if (car == null) {
					car = new Car();
				}
			}
		}
		return car;
	}
}

public class Main {

	public static void main(String[] args) {

		// Car car1 = Car.getInstance();
		// Car car2 = Car.getInstance();

		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				Car car = Car.getInstance();
			}
		});

		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				Car car = Car.getInstance();
			}
		});

		thread1.start();
		thread2.start();

	}
}