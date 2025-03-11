import java.util.Arrays;

public class LifeGame implements Grid {

    // Integers: 0 or 1 for alive or dead
    private int[][] grid;

    public LifeGame(int rows, int cols) {
        // Construct a 2D array of the given rows and cols size.
        grid = new int[rows][cols];
    }

    // Set values on the grid
    public void placePattern(int row, int col, int[][] pattern) {
        for (int i = 0; i < pattern.length; i++) {
            for (int j = 0; j < pattern[0].length; j++) {
                grid[i + row][j + col] = pattern[i][j];
            }
        }
    }

    // Run the simulation for a number of generations
    public void simulate(int generations) {
        for (int i = 0; i < generations; i++) {
            evolve();
        }
    }

    // Step the simulation forward one generation.
    public void evolve() {
        display();
        int[][] newGrid = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int neighbors = countAliveNeighbors(i, j);
                if (grid[i][j] == 1) {
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
        grid = newGrid;
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

    // Get a value from the grid with "wrap around"
    public int getCell(int row, int col) {
        int rowLimit = grid.length;
        int colLimit = grid[0].length;
        return grid[(row + rowLimit) % rowLimit][(col + colLimit) % colLimit];
    }

    // Test helper to get the whole grid state
    public int[][] getGrid() {
        return grid;
    }