import java.util.*;
public class Display_array {
	
	private static String board[][] = {
			                    {"X", " ", " "}, 
			                    {" ", " ", " "},
			                    {" ", " ", " "},};
	                                  
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);
		
		display(board);
		
	}

	public static void display(String board[][]) {

		for (int i = 0; i < 3; i++) {

			// symbols in horisontal line
			//System.out.println(board[i][0] + " | " + board[i][0] + " | " + board[i][0]);
			//System.out.println("----------------");
			System.out.println(board[i][1] + " | " + board[i][1] + " | " + board[i][1]);
			System.out.println("----------");
			
			
			
			
		/*	System.out.println(board[i][2] + " | " + board[i][2] + " | " + board[i][2]);
			
			// symbols in diagonal 
			System.out.println(board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
			System.out.println(board[i][2] + " | " + board[i][1] + " | " + board[i][0]);
			
			System.out.println(board[i][0] + " | " + board[i][0] + " | " + board[i][0]);
			System.out.println(board[i][0] + " | " + board[i][0] + " | " + board[i][0]);
            System.out.println(board[i][0] + " | " + board[i][1] + " | " + board[i][2]);*/


		}
	}
}
