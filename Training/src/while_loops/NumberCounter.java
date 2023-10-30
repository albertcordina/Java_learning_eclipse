package while_loops;

public class NumberCounter {

	void countAndDisplay(int start, int end) {
		int current = start;
		while (current <= end) {
			System.out.println(current);
			current++;
		}
	}
}

class WhileLoopAssignment {

	public static void main(String[] args) {
		NumberCounter numberCounter = new NumberCounter();
		numberCounter.countAndDisplay(1, 10);

	}
}
