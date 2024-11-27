import java.util.Scanner;

public class MineSweeper {

    int firstDimension;
    int secondDimension;

    public MineSweeper() {

    }

    public void initializeMineSweeper() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Enter the 1st Dimension (min 2): ");
            this.firstDimension = scanner.nextInt();
        } while (this.firstDimension < 2);
        do {
            System.out.print("Enter the 2nd Dimension (min 2): ");
            this.secondDimension = scanner.nextInt();
        } while (this.secondDimension < 2);
    }

    public void createMineSweeper() {
        String[][] mineSweeper = new String[this.firstDimension][this.secondDimension];
        int totalMineCount = (int) ((this.firstDimension * this.secondDimension) / 4.0);

        // Create the empty minefield
        createMineFieldWithoutMines(mineSweeper);

        // Randomly place mines
        placeMines(mineSweeper, totalMineCount);

        // Display the minefield
        printMinefield(mineSweeper);

        System.out.println("==============================");

        //Start the game
        createGameMineField(mineSweeper, totalMineCount);
    }

    // Method to randomly place mines
    public void placeMines(String[][] mineSweeper, int totalMineCount) {
        int placedMines = 0;

        while (placedMines < totalMineCount) {
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
        for (int i = 0; i < this.firstDimension; i++) {
            for (int j = 0; j < this.secondDimension; j++) {
                mineSweeper[i][j] = "-";
            }
        }
    }

    public void createGameMineField(String[][] mineSweeper, int totalMineCount) {
        //Game Board
        String[][] mineSweeperGameBoard = new String[this.firstDimension][this.secondDimension];

        Scanner scan = new Scanner(System.in);
        int playedAreaCount = 0;

        System.out.println("Welcome to MineSweeper Game!");

        createEmptyBoard(mineSweeperGameBoard);

        while (true) {
            System.out.print("Enter row: ");
            int rowNum = scan.nextInt();
            System.out.print("Enter column: ");
            int columnNum = scan.nextInt();

            //Check the Entered Dimensions
            if (rowNum < 0 || columnNum < 0 || rowNum >= this.firstDimension || columnNum >= this.secondDimension) {
                System.out.println("Invalid number! \n");
                continue;
            }

            //Game Over Scenario
            if (mineSweeper[rowNum][columnNum].equals("*")) {
                System.out.println("GAME OVER!");
                break;
            }

            //Check Is it a previously played area?
            if (mineSweeperGameBoard[rowNum][columnNum].matches("\\d+")) {
                System.out.println("This Field is already played! Play Another Field!\n");
                continue;
            }

            playedAreaCount++;
            checkBoundsAndCountMines(rowNum, columnNum, mineSweeperGameBoard, mineSweeper);
            printMineBoard(mineSweeperGameBoard);

            //WIN Scenario
            if (playedAreaCount + totalMineCount == (this.firstDimension) * (this.secondDimension)) {
                System.out.println("YOU WIN!");
                printMineBoardWin(mineSweeperGameBoard);
                break;
            }
        }
    }

    public void createEmptyBoard(String[][] mineSweeperGameBoard) {
        for (int i = 0; i < this.firstDimension; i++) {
            for (int j = 0; j < this.secondDimension; j++) {
                mineSweeperGameBoard[i][j] = "-";
                System.out.print(mineSweeperGameBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void checkBoundsAndCountMines(int rowNum, int columnNum, String[][] mineSweeperGameBoard, String[][] mineSweeper) {
        // Define the relative positions of all 8 possible neighbors
        int[][] directions = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1}, {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };
        int mineCount = 0;

        for (int[] dir : directions) {
            int newRow = rowNum + dir[0];
            int newCol = columnNum + dir[1];

            // Check bounds and count mines
            if (newRow >= 0 && newRow < this.firstDimension && newCol >= 0 && newCol < this.secondDimension) {
                if (mineSweeper[newRow][newCol].equals("*")) {
                    mineCount++;
                }
            }
        }
        mineSweeperGameBoard[rowNum][columnNum] = Integer.toString(mineCount);
    }

    public void printMineBoard(String[][] mineSweeperGameBoard) {
        for (int i = 0; i < this.firstDimension; i++) {
            for (int j = 0; j < this.secondDimension; j++) {
                if (mineSweeperGameBoard[i][j].equals("-")) {
                    mineSweeperGameBoard[i][j] = "-";
                }
                System.out.print(mineSweeperGameBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printMineBoardWin(String[][] mineSweeperGameBoard) {
        for (int i = 0; i < this.firstDimension; i++) {
            for (int j = 0; j < this.secondDimension; j++) {
                if (mineSweeperGameBoard[i][j].equals("-")) {
                    mineSweeperGameBoard[i][j] = "*";
                }
                System.out.print(mineSweeperGameBoard[i][j] + " ");
            }
            System.out.println();
        }
    }
}
