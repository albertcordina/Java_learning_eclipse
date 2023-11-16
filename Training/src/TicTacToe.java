
import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            printBoard();
            makeMove();
        } while (!isGameFinished());

        scanner.close();
    }
//--------------------------------------------------
    private static void printBoard() {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("  -----");
            }
        }
        System.out.println();
    }
//----------------------------------------------------
    private static void makeMove() {
        Scanner scanner = new Scanner(System.in);
        int row, col;

        do {
            System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
            row = scanner.nextInt();
            col = scanner.nextInt();

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                switchPlayer();
                break;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        } while (true);
    }
//---------------------------------------------------------------
    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' '; }
//-----------------------------------------------------------------------------
    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';}
//-----------------------------------------------------------------------------
    private static boolean isGameFinished() {
        if (checkWinner()) {
            printBoard();
            System.out.println("Player " + currentPlayer + " wins!");
            return true;
        } else if (isBoardFull()) {
            printBoard();
            System.out.println("It's a draw!");
            return true;
        } else {
            return false;
        }
    }
//-----------------------------------------------------------------------------
    private static boolean checkWinner() {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            if (checkRow(i) || checkColumn(i)) {
                return true;
            }
        }

        return checkDiagonals();
    }
//-----------------------------------------------------------------------------
    private static boolean checkRow(int row) {
        return board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer;}
//-----------------------------------------------------------------------------
    private static boolean checkColumn(int col) {
        return board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer;}
//-----------------------------------------------------------------------------
    private static boolean checkDiagonals() {
        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
               (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);}
//-----------------------------------------------------------------------------
    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}