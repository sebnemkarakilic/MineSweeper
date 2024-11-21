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

        // Display the empty minefield
        createMineFieldWithoutMines(mineSweeper);

        System.out.println("======================");

        // Randomly place mines
        placeMines(mineSweeper, mineNum);
        // Display the minefield
        printMinefield(mineSweeper);
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
        for (int i = 0; i < mineSweeper.length; i++) {
            for (int j = 0; j < mineSweeper[i].length; j++) {
                System.out.print(mineSweeper[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Method to print the minefield, not displaying mines
    public void createMineFieldWithoutMines(String[][] mineSweeper) {
        for (int i = 0; i < firstDimension; i++) {
            for (int j = 0; j < secondDimension; j++) {
                mineSweeper[i][j] = "-";
                System.out.print(mineSweeper[i][j] + " ");
            }
            System.out.println();
        }
    }
}
