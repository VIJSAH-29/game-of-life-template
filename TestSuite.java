import java.util.Arrays;

public class TestSuite {
    public static void runTests() {
        System.out.println("Initiating Test Suite");
        boolean allPassed = true;

        GameOfLife gameGrid = new GameOfLife(5, 5);

        // Test neighbor counting
        int[][] singleCell = {{ 1 }};

        // Place a single live cell and check its neighbors
        gameGrid.placePattern(2, 3, singleCell);
        allPassed &= verify(gameGrid.countAliveNeighbors(2, 3), 0, "Single live cell should have zero neighbors");

        // Place an additional live cell at the top
        gameGrid.placePattern(1, 2, singleCell);
        allPassed &= verify(gameGrid.countAliveNeighbors(2, 2), 2, "One neighbor should be detected");

        // Place another live cell at the bottom
        gameGrid.placePattern(3, 2, singleCell);
        allPassed &= verify(gameGrid.countAliveNeighbors(2, 2), 3, "Two neighbors should be detected");

        // Test grid evolution
        gameGrid.evolve();
        gameGrid.display();
        allPassed &= verify(gameGrid.getCell(2, 3), 1, "Pattern should evolve correctly");

        if (allPassed) {
            System.out.println("--- ALL TESTS PASSED! Great job! ---");
        } else {
            System.out.println("--- SOME TESTS FAILED! Recheck logic. ---");
        }
    }

    private static boolean verify(int result, int expected, String description) {
        if (result == expected) {
            return true;
        }
        System.out.println(description + " | Got: " + result + ", Expected: " + expected);
        return false;
    }
}
