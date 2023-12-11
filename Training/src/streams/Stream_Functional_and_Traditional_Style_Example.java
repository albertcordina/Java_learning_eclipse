package streams;

import java.util.Arrays;
import java.util.List;
/*
  Usage Considerations:

If you are working in a context where functional programming constructs and Java Streams are well-understood and 
accepted, the 'sumEvenNumbersFunctional' method may be a preferred choice for its conciseness and expressiveness.

If you are working in a codebase where traditional imperative programming is more common or if the logic is 
relatively simple, the 'sumEvenNumbersTraditional' method might be preferred for its simplicity and readability.

Both methods achieve the same result, so the choice between them depends on factors such as code readability, 
developer familiarity, and the specific coding standards or patterns used in your project or team.

 */
public class Stream_Functional_and_Traditional_Style_Example {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		System.out.println("Original List: " + numbers);
		System.out.println("Sum of Even Numbers via stream: " + sumEvenNumbersFunctional(numbers));
		System.out.println("Sum of Even Numbers via method: " + sumEvenNumbersTraditional(numbers));
	}
/*
 * The functional programming:
 * stream is used to filter even numbers from the List
 * 'mapToInt' converts the stream of integers to IntStream
 * 'sum' calculates the sum of the even numbers
 */
	public static int sumEvenNumbersFunctional(List<Integer> numbers) {
		int evenSum = numbers.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum(); 
		return evenSum;
	}
/*
 * The traditional operative programming style:
 */
	public static int sumEvenNumbersTraditional(List<Integer> numbers) {
		int evenSum = 0;
		for (int n : numbers) { if (n % 2 == 0) { evenSum += n;}}
		return evenSum;
	}
}
