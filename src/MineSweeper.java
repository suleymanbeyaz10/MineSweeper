import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    int rowNumber;
    int columnNumber;
    char[][] mineField;
    char[][] tempMineField;


    public MineSweeper(int rowNumber, int columnNumber) {
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
        this.mineField = new char[rowNumber][columnNumber];
        this.tempMineField = new char[rowNumber][columnNumber];
    }

    Random random = new Random();
    char star = '*';

    void createGameArea() {
        int starLimit = rowNumber * columnNumber / 4; // Eleman sayısının çeyreği kadar limit belirle
        int starCount = 0;

        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < columnNumber; j++) {
                // Eleman sayısının çeyreği kadar star ataması yap
                if (starCount < starLimit && random.nextDouble() < 0.3) {
                    mineField[i][j] = star;
                    starCount++;
                } else {
                    mineField[i][j] = '-';
                }
                System.out.print(mineField[i][j] + "  ");
            }
            System.out.println();
        }
    }
    void printMineField(char mineField[][]){
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < columnNumber; j++) {
                System.out.print(mineField[i][j] + " ");
            }
            System.out.println();
        }
    }

    void gameplay() {
        Scanner input = new Scanner(System.in);
        createGameArea();
        // setter tempMineField
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < columnNumber; j++) {
                tempMineField[i][j] = '-';
            }
        }

        while (true) {
            System.out.print("Satır sayısını giriniz : ");
            int incomingRowValue = input.nextInt();
            System.out.print("Sütun sayısını giriniz : ");
            int incomingColumnValue = input.nextInt();
            if (mineField[incomingRowValue][incomingColumnValue] == '*') {
                System.out.println("!!!GAME OVER!!!");
                break;
            }else {
                tempMineField[incomingRowValue][incomingColumnValue] = 'x';
            }
            printMineField(tempMineField);
        }

    }

    void playGame() {
        gameplay();
    }
}








































/*import java.util.Scanner;
import java.util.Random;

public class MineSweeper {
    private int row;
    private int column;
    private int[][] minefield;
    private boolean[][] revealed;
    private int mines;

    public MineSweeper(int row, int column) {
        this.row = row;
        this.column = column;
        this.minefield = new int[row][column];
        this.revealed = new boolean[row][column];
        this.mines = (row * column) / 4;
        initializeGame();
    }

    private void initializeGame() {
        placeMines();
        calculateAdjacentMines();
    }

    private void placeMines() {
        Random random = new Random();

        for (int i = 0; i < mines; i++) {
            int randRow = random.nextInt(row);
            int randCol = random.nextInt(column);

            // Check if there is already a mine at the randomly selected location
            while (minefield[randRow][randCol] == -1) {
                randRow = random.nextInt(row);
                randCol = random.nextInt(column);
            }

            minefield[randRow][randCol] = -1; // -1 represents a mine
        }
    }

    private void calculateAdjacentMines() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (minefield[i][j] == -1) {
                    continue; // Skip calculation for mine cells
                }

                int count = 0;

                // Check all neighboring cells
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        int newRow = i + x;
                        int newCol = j + y;

                        if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < column
                                && minefield[newRow][newCol] == -1) {
                            count++;
                        }
                    }
                }

                minefield[i][j] = count; // Set the count as the value for non-mine cells
            }
        }
    }

    private void printBoard() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (revealed[i][j]) {
                    System.out.print(minefield[i][j] + " ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

    private void revealCell(int r, int c) {
        if (r < 0 || r >= row || c < 0 || c >= column || revealed[r][c]) {
            return; // Ignore invalid or already revealed cells
        }

        revealed[r][c] = true;

        if (minefield[r][c] == 0) {
            // If the selected cell has no adjacent mines, recursively reveal its neighbors
            for (int x = -1; x <= 1; x++) {
                for (int y = -1; y <= 1; y++) {
                    revealCell(r + x, c + y);
                }
            }
        }
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Mayın Tarlası Oyuna Hoşgeldiniz!");
        printBoard();

        while (true) {
            System.out.print("Satır Giriniz: ");
            int selectedRow = scanner.nextInt();

            System.out.print("Sütun Giriniz: ");
            int selectedColumn = scanner.nextInt();

            if (selectedRow < 0 || selectedRow >= row || selectedColumn < 0 || selectedColumn >= column) {
                System.out.println("Geçersiz bir nokta girdiniz. Lütfen tekrar deneyin.");
                continue;
            }

            if (minefield[selectedRow][selectedColumn] == -1) {
                System.out.println("Game Over!!");
                break;
            } else {
                revealCell(selectedRow, selectedColumn);
                printBoard();

                boolean allCellsRevealed = true;

                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < column; j++) {
                        if (!revealed[i][j] && minefield[i][j] != -1) {
                            allCellsRevealed = false;
                            break;
                        }
                    }
                }

                if (allCellsRevealed) {
                    System.out.println("Oyunu Kazandınız!");
                    break;
                }
            }
        }

        scanner.close();
    }
}*/
