import java.util.Objects;
import java.util.Scanner;

public class MineSweeper {

    int firstDimension;
    int secondDimension;

    public MineSweeper() {

    }

    public void initializeMineSweeper() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter 1. Dimension of the MineSweeper: ");
        this.firstDimension = scanner.nextInt();
        System.out.print("Enter 2. Dimension of the MineSweeper: ");
        this.secondDimension = scanner.nextInt();

        while (firstDimension < 2 && secondDimension < 2) {
            System.out.print("Enter a valid 1. Dimension of the MineSweeper (min 2): ");
            firstDimension = scanner.nextInt();
            System.out.print("Enter a valid 2. Dimension of the MineSweeper (min 2): ");
            secondDimension = scanner.nextInt();
        }

    }

    public void createMineSweeper() {
        String[][] mineSweeperOriginal = new String[this.firstDimension][this.secondDimension];
        String[][] mineSweeper = new String[this.firstDimension][this.secondDimension];
        int mineNum = (int) ((this.firstDimension * this.secondDimension) / 4.0);

        // Create the empty minefield
        createMineFieldWithoutMines(mineSweeper);

        // Randomly place mines
        placeMines(mineSweeper, mineNum);
        // Display the minefield
        printMinefield(mineSweeper);
        System.out.println("======================");
        createGameMineField(mineSweeper, mineNum);
    }

    // Method to randomly place mines
    public void placeMines(String[][] mineSweeper, int mineNum) {
        int placedMines = 0;

        while (placedMines < mineNum) {
            int randRow = (int) (Math.random() * this.firstDimension); // Random row
            int randCol = (int) (Math.random() * this.secondDimension); // Random column

            // Only place a mine if the spot is empty
            if (mineSweeper[randRow][randCol].equals("-")) {
                mineSweeper[randRow][randCol] = "*"; // Place the mine
                placedMines++;
            }
        }
    }

    // Method to print the minefield
    public static void printMinefield(String[][] mineSweeper) {
        System.out.println("- Location of the Mines -");
        for (String[] strings : mineSweeper) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    // Method to print the minefield, not displaying mines
    public void createMineFieldWithoutMines(String[][] mineSweeper) {
        for (int i = 0; i < firstDimension; i++) {
            for (int j = 0; j < secondDimension; j++) {
                mineSweeper[i][j] = "-";
                //System.out.print(mineSweeper[i][j] + " ");
            }
            //System.out.println();
        }
    }

    public void createGameMineField(String[][] mineSweeper, int mineNum) {
        String[][] mineSweeperGameBoard = new String[this.firstDimension][this.secondDimension];
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to MineSweeper Game!");
        boolean isGameOver = false;

        for (int i = 0; i < firstDimension; i++) {
            for (int j = 0; j < secondDimension; j++) {
                mineSweeperGameBoard[i][j] = "-";
                System.out.print(mineSweeperGameBoard[i][j] + " ");
            }
            System.out.println();
        }
        int count = 0;
        while (true) {
            System.out.print("Enter row: ");
            int rowNum = scan.nextInt();
            System.out.print("Enter column: ");
            int columnNum = scan.nextInt();
            int mineCount = 0;
            if (mineSweeper[rowNum][columnNum].equals("*")) {
                System.out.println("GAME OVER!");
                break;
            }
            count++;
            if (count + mineNum == (this.firstDimension) * (this.secondDimension)) {
                System.out.println("YOU WIN!");
                break;
            }
            // Define the relative positions of all 8 possible neighbors
            int[][] directions = {
                    {-1, -1}, {-1, 0}, {-1, 1},
                    { 0, -1},          { 0, 1},
                    { 1, -1}, { 1, 0}, { 1, 1}
            };

            for (int[] dir : directions) {
                int newRow = rowNum + dir[0];
                int newCol = columnNum + dir[1];

                // Check bounds and count mines
                if (newRow >= 0 && newRow < firstDimension && newCol >= 0 && newCol < secondDimension) {
                    if (mineSweeper[newRow][newCol].equals("*")) {
                        mineCount++;
                    }
                }
            }
            mineSweeperGameBoard[rowNum][columnNum] = Integer.toString(mineCount);

                for (int i = 0; i < firstDimension; i++) {
                    for (int j = 0; j < secondDimension; j++) {
                        if (mineSweeperGameBoard[i][j].equals("-")) {
                            mineSweeperGameBoard[i][j] = "-";
                        }
                        System.out.print(mineSweeperGameBoard[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
