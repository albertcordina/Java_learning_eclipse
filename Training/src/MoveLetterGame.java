
import java.util.Scanner;

public class MoveLetterGame {
    private static final char DOT = '.';
    private static final char LETTER = 'L';

    private static final int TABLE_SIZE = 10;

    private static char[][] table = new char[TABLE_SIZE][TABLE_SIZE];
    private static int letterRow;
    private static int letterCol;

    public static void main(String[] args) {
        initializeTable();
        printTable();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            char move = getMove(scanner);

            if (!isValidMove(move)) {
                System.out.println("Invalid move. Use 'U', 'D', 'L', or 'R'.");
                continue;
            }

            moveLetter(move);
            printTable();
        }
    }

    private static void initializeTable() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            for (int j = 0; j < TABLE_SIZE; j++) {
                table[i][j] = DOT;
            }
        }

        letterRow = TABLE_SIZE / 2;
        letterCol = TABLE_SIZE / 2;
        table[letterRow][letterCol] = LETTER;
    }

    private static void printTable() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            for (int j = 0; j < TABLE_SIZE; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static char getMove(Scanner scanner) {
        System.out.print("Enter move (U/D/L/R): ");
        return scanner.next().charAt(0);
    }

    private static boolean isValidMove(char move) {
        return move == 'U' || move == 'D' || move == 'L' || move == 'R';
    }

    private static void moveLetter(char move) {
        table[letterRow][letterCol] = DOT;

        switch (move) {
            case 'U' -> {if (letterRow > 0) letterRow--;}
            case 'D' -> {if (letterRow < TABLE_SIZE - 1) letterRow++;}
            case 'L' -> {if (letterCol > 0) letterCol--;}
            case 'R' -> {if (letterCol < TABLE_SIZE - 1) letterCol++;}
        }
        table[letterRow][letterCol] = LETTER;
    }
}


