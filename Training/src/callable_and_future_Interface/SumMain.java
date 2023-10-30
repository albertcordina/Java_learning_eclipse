package callable_and_future_Interface;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
//----------------------------------------------------------------------
class SumCalculator implements Callable <Integer> {
	
	int start, end;
	public SumCalculator (int start, int end) {
		this.start = start;
		this.end = end;
	}
	@Override
	public Integer call() throws Exception {
        int sum = 0;
		for (int i = start; i <= end; i++) {sum += i;}
		return sum;
	}
}
//------------------------------------------------------------------------
public class SumMain {
	
	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService task = Executors.newFixedThreadPool(3); // '3' is the size 
		List <SumCalculator> list = new ArrayList<> ();
		
		list.add(new SumCalculator (5, 15));
		list.add(new SumCalculator (25, 35));
		list.add(new SumCalculator (45, 55));
		
		
		List<Future<Integer>> future = new ArrayList<>();
        for (SumCalculator calculator : list) {
        	future.add(task.submit(calculator)); 
        	}

        for (int i = 0; i < list.size(); i++) {
            SumCalculator calculator = list.get(i);
            int result;
            try {
                result = future.get(i).get();
                System.out.println("Sum of integers in range [" + calculator.start + ", " + calculator.end + "]: " + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        task.shutdown();
        task.awaitTermination(1, TimeUnit.HOURS);
    }
}
