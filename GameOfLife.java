import java.util.Arrays;

public class GameOfLife implements Board {

    private int[][] board;

    public GameOfLife(int rows, int cols) {
        board = new int[rows][cols];
    }

    public void placePattern(int row, int col, int[][] pattern) {
        for (int i = 0; i < pattern.length; i++) {
            for (int j = 0; j < pattern[0].length; j++) {
                board[i + row][j + col] = pattern[i][j];
            }
        }
    }

    public void simulate(int generations) {
        for (int i = 0; i < generations; i++) {
            evolve();
        }
    }

    public void evolve() {
        display();
        int[][] newGrid = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int neighbors = countAliveNeighbors(i, j);
                if (board[i][j] == 1) {
                    // Alive cell rules
                    if (neighbors < 2 || neighbors > 3) {
                        newGrid[i][j] = 0; // Dies
                    } else {
                        newGrid[i][j] = 1; // Stays alive
                    }
                } else {
                    // Dead cell rule
                    if (neighbors == 3) {
                        newGrid[i][j] = 1; // Becomes alive
                    }
                }
            }
        }
        board = newGrid;
    }

    public int countAliveNeighbors(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (!(i == 0 && j == 0)) {
                    count += getCell(row + i, col + j);
                }
            }
        }
        return count;
    }

    public int getCell(int row, int col) {
        int rowLimit = board.length;
        int colLimit = board[0].length;
        return board[(row + rowLimit) % rowLimit][(col + colLimit) % colLimit];
    }

    public int[][] getGrid() {
        return board;
    }

    public void display() {
        System.out.print("\n ");
        for (int y = 0; y < board[0].length; y++) {
            System.out.print(y % 10 + " ");
        }

        for (int x = 0; x < board.length; x++) {
            System.out.print("\n" + x % 10);
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y] == 1) {
                    System.out.print("⬛");
                } else {
                    System.out.print("⬜");
                }
            }
        }
        System.out.println();
    }
}
