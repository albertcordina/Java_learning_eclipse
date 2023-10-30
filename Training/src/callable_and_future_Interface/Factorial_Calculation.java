package callable_and_future_Interface;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Callable;

public class Factorial_Calculation {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService calculation = Executors.newSingleThreadExecutor();
		Future<String> future = calculation.submit(new FactorialCalculation("Calculation"));

		try {
			String thread = future.get();
			System.out.println(thread);
		} catch (Exception e) {
			System.out.println("An error occurred while calculating the factorial.");
		}

		calculation.shutdown();
		calculation.awaitTermination(5, TimeUnit.MINUTES);

	}
}

//-------------------------------------------------------
class FactorialCalculation implements Callable<String> {

	Scanner scanner = new Scanner(System.in);

	private String result;

	public FactorialCalculation(String result) {
		this.result = result;
	}

	@Override
	public String call() throws Exception {

		int i, fact = 1;
		System.out.print("The calculation of the factorial\nPlease, enter your number: ");
		int n = scanner.nextInt();

		if (n < 0) {
			while (n <= 0) { // the 'while' loop requests the user to enter only a positive number;
				System.out.print("Please, enter a positive number: ");
				n = scanner.nextInt();
				if (n > 0) {
					for (i = 1; i <= n; i++) {
						fact = fact * i;
					}
					System.out.println("Factorial of " + n + " is " + fact);
				}
			}
		} else {
			for (i = 1; i <= n; i++) {
				fact = fact * i;
			}
		}

		scanner.close();
		return "Factorial of " + n + " is " + fact;
	}
}