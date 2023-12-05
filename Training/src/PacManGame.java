
import java.util.Random;
import java.util.Scanner;

public class PacManGame {
	
    private static final char PACMAN = 'P';
    private static final char GHOST = 'G';
    private static final char DOT = '.';
    private static final char POWER_UP = '*';

    private static final int MAZE_SIZE = 10;
    private static final int STARTING_SCORE = 0;
    private static final int POWER_UP_DURATION = 3;

    private static char[][] maze = new char[MAZE_SIZE][MAZE_SIZE];
    private static int pacmanRow;
    private static int pacmanCol;
    private static int score;

    public static void main(String[] args) {
    	
        initializeGame();
        printMaze();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            char move = getMove(scanner);

            if (!isValidMove(move)) {
                System.out.println("Invalid move. Use 'U', 'D', 'L', or 'R'.");
                continue;
            }

            movePacman(move);
            moveGhosts();
            updateGame();

            if (isGameOver()) {
                System.out.println("Game over! Your final score: " + score);
                break;
            }

            printMaze();
        }

        scanner.close();
    }

    private static void initializeGame() {
        for (int i = 0; i < MAZE_SIZE; i++) {
            for (int j = 0; j < MAZE_SIZE; j++) {
                maze[i][j] = DOT;
            }
        }

        pacmanRow = MAZE_SIZE / 2;
        pacmanCol = MAZE_SIZE / 2;
        maze[pacmanRow][pacmanCol] = PACMAN;

        spawnGhosts();
        spawnPowerUp();

        score = STARTING_SCORE;
    }

    private static void spawnGhosts() {
        Random random = new Random();

        for (int i = 0; i < 2; i++) {
            int ghostRow, ghostCol;

            do {
                ghostRow = random.nextInt(MAZE_SIZE);
                ghostCol = random.nextInt(MAZE_SIZE);
            } while (maze[ghostRow][ghostCol] != DOT);

            maze[ghostRow][ghostCol] = GHOST;
        }
    }

    private static void spawnPowerUp() {
        Random random = new Random();
        int powerUpRow, powerUpCol;

        do {
            powerUpRow = random.nextInt(MAZE_SIZE);
            powerUpCol = random.nextInt(MAZE_SIZE);
        } while (maze[powerUpRow][powerUpCol] != DOT);

        maze[powerUpRow][powerUpCol] = POWER_UP;
    }

    private static void printMaze() {
        for (int i = 0; i < MAZE_SIZE; i++) {
            for (int j = 0; j < MAZE_SIZE; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Score: " + score);
        System.out.println();
    }

    private static char getMove(Scanner scanner) {
        System.out.print("Enter move (U/D/L/R): ");
        return scanner.next().charAt(0);
    }

    private static boolean isValidMove(char move) {
        return move == 'U' || move == 'D' || move == 'L' || move == 'R';
    }

    private static void movePacman(char move) {
        maze[pacmanRow][pacmanCol] = DOT;

        switch (move) {
            case 'U' -> pacmanRow--;
            case 'D' -> pacmanRow++;
            case 'L' -> pacmanCol--;
            case 'R' -> pacmanCol++;
        }

        if (maze[pacmanRow][pacmanCol] == DOT) {
            score++;
        } else if (maze[pacmanRow][pacmanCol] == POWER_UP) {
            score += 5;
            activatePowerUp();
        }

        maze[pacmanRow][pacmanCol] = PACMAN;
    }

    private static void moveGhosts() {
        Random random = new Random();

        for (int i = 0; i < MAZE_SIZE; i++) {
            for (int j = 0; j < MAZE_SIZE; j++) {
                if (maze[i][j] == GHOST) {
                    maze[i][j] = DOT;

                    int move = random.nextInt(4);

                    switch (move) {
                        case 0 -> {if(i > 0) i--;}                   // Move up
                        case 1 -> {if (i < MAZE_SIZE - 1) i++;}     //  Move down
                        case 2 -> {if (j > 0) j--;}                //   Move left
                        case 3 -> {if (j < MAZE_SIZE - 1) { j++;} //    Move right
                        }
                    }
                    if (maze[i][j] != PACMAN) {
                        maze[i][j] = GHOST;
                    }
                }
            }
        }
    }

    private static void activatePowerUp() {
        for (int i = 0; i < MAZE_SIZE; i++) {
            for (int j = 0; j < MAZE_SIZE; j++) {
                if (maze[i][j] == GHOST) {
                    maze[i][j] = DOT;
                }
            }
        }

        System.out.println("Power-up activated! Pac-Man can now eat ghosts for a limited time.");
    }

    private static void updateGame() {
        if (score % 10 == 0) {
            spawnPowerUp();
        }
    }

    private static boolean isGameOver() {
        return maze[pacmanRow][pacmanCol] == GHOST;
    }
}

