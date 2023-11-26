package thread;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
public class Threads_and_Streams {
/*
 * Combining threads and streams in Java can be powerful for concurrent and parallel processing of data. 
 * Here are a few common examples:
 */
	static int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	public static void main(String[] args) throws InterruptedException {

/*
 * Example 1: Parallel Stream Processing with Threads:	
 * In this example, the parallel() method is used to convert a sequential stream to a parallel stream, 
 * allowing elements to be processed concurrently by multiple threads. The forEach operation is then 
 * performed on each element, and the thread information is printed.	
 */
        // Using parallel stream to process elements concurrently
        Arrays.stream(numbers)
                .parallel()
                .forEach(num -> {
                    // Perform some computation using threads
                    System.out.println(Thread.currentThread().getName() + ": " + num);
                });
/*
 * Example 2: Concurrent Processing with ExecutorService and Stream:
 * 	In this example, an ExecutorService is used to manage a pool of threads. The parallel() method
 *  is applied to the stream, and tasks are submitted to the ExecutorService for concurrent execution.
 */
        // Create an ExecutorService with a fixed number of threads
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        // Submit tasks to the ExecutorService using parallel stream
        Arrays.stream(numbers)
                .parallel()
                .forEach(num -> executorService.submit(() -> {
                    // Perform some computation using threads
                    System.out.println(Thread.currentThread().getName() + ": " + num);
                }));

        // Shut down the ExecutorService
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
	}
}
