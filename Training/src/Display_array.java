import java.util.*;
public class Display_array {
	
	private static String board[][] = {
			                    {"LOVE", "      ", "    "}, 
			                    {"    ", " you  ", "    "},
			                    {"    ", "      ", "LOVE"}
	                                  };
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);
		
		display(board);
		
	}

	public static void display(String board[][]) {

		for (int i = 0; i < 3; i++) {

			System.out.println(board[i][0] + " | " + board[i][1] + " | " + board[i][2]);

		}
	}
}
