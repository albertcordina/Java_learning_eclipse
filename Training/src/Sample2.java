import java.util.InputMismatchException;
import java.util.Scanner;

class NumberAnalyzer {
	
	private int sum = 0;
	private int product = 1;
	private int max = Integer.MAX_VALUE;
	private int min = Integer.MIN_VALUE;
	
	public void analyzeNumbers() {
		Scanner scanner = new Scanner(System.in);
		
		int num = 0;
		boolean shouldContinue = true;
		boolean maxMin = true;
		
		while(shouldContinue) {
			num = getInput(scanner, "Enter a number (or -1 to quit): ");
			
			if(num == -1) {
				shouldContinue = false;
			} else {
				sum += num;
				product *= num; 
				
				if(maxMin) {
					max = num;
					min = num; 
					maxMin = false; 
				} else {
					 if (num > max) {
		                max = num;
		            }
					 
					if (num < min) {
		                min = num;
		            } 
				}
			}
		}
		
		if(maxMin) {
			System.out.println("No numbers were entered!");
		} else {
			System.out.println("Sum: " + sum + "\nProduct: " + product + "\nMaximum: " + max + "\nMinimum: " + min);
		}       
	}
	
	private int getInput(Scanner scanner, String message) {
		
		int input = 0;
		boolean validInput = false; 
		
		while(!validInput) {
			try {
				System.out.println(message);
				input = scanner.nextInt();
				scanner.nextLine();
				
				if(input == -1) {
					validInput = true; 
				} else {
					validInput = true;
				}
			} catch(InputMismatchException e) {
				System.err.println("Invalid Input. Please enter a number.");
				scanner.nextLine();
			}
		}
		
		return input;
	}
}

public class Sample2 {

    public static void main(String[] args) {
    
        System.out.println("Welcome to the Number Analysis Program!");
        
        NumberAnalyzer analyzer = new NumberAnalyzer();
        analyzer.analyzeNumbers();
    }
}
