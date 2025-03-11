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

    // Run the simulation for a number of turns
    public void run(int turns) {
        // call step the number of times requested
    }

    // Step the simulation forward one turn.
    public void step()
    {
        print();
        // Update the game board, store a 1 if the cell is alive and a 0 otherwise.
    }


    public int countNeighbors(int x, int y) {
        int count = 0;
        // count the number of neighbors the cell has
        // use the get(x,y) method to read any board state you need.
        return count;
    }

    // Get a value from the board with "wrap around"
    // Locations outside the board will loop back into the board.
    // Ex: -1 will read board.length-1
    public int get(int x, int y) {
        int xLimit = board.length;
        int yLimit= board[0].length;
        return board[(x+xLimit)%xLimit][(y+yLimit)%yLimit];
    }

    // Test helper to get the whole board state
    public int[][] get()
    {
        return board;
    }

    // Test helper to print the current state
    public void print(){
        // Print the header
        System.out.print("\n ");
        for (int y = 0; y < board[0].length; y++) {
            System.out.print(y%10 + " ");
        }

        for (int x = 0; x < board.length; x++) {
            System.out.print("\n" + x%10);
            for (int y=0; y<board[x].length; y++)
            {
                if (board[x][y] == 1)
                {
                    System.out.print("⬛");
                }
                else
                {
                    System.out.print("⬜");
                }
            }
        }
        System.out.println();
    }
}
