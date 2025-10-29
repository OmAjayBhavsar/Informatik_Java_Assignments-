import java.util.Random;

public class Percolation {

    public static void main(String[] args) {
        // Command line parameters
        int height = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);
        double p = Double.parseDouble(args[2]);
        int n = Integer.parseInt(args[3]);

        // Simulate percolation for given probabilities
        for (double prob = 0.0; prob <= 1.0; prob += 0.01) {
            int percolatingCount = 0;

            // Run simulation for n matrices
            for (int i = 0; i < n; i++) {
                boolean[][] matrix = generateRandomMatrix(height, width, prob);
                if (percolates(matrix)) {
                    percolatingCount++;
                }
            }

            // Calculate and print percolation probability
            double percolationProbability = (double) percolatingCount / n;
            System.out.println("Probability " + prob + ": " + percolationProbability);
        }
    }

    // Generate a random matrix with given dimensions and blocking probability
    private static boolean[][] generateRandomMatrix(int height, int width, double p) {
        boolean[][] matrix = new boolean[height][width];
        Random random = new Random();

        // Populate matrix with blocked fields based on probability
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                matrix[y][x] = random.nextDouble() <= p;
            }
        }

        return matrix;
    }

    // Check if the matrix percolates
    private static boolean percolates(boolean[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;

        // Mark visited sites
        boolean[][] visited = new boolean[height][width];

        // Check for percolation from the top row
        for (int x = 0; x < width; x++) {
            if (!matrix[0][x] && !visited[0][x]) {
                if (dfs(matrix, visited, 0, x, height, width)) {
                    return true;
                }
            }
        }

        return false;
    }

    // Depth-First Search (DFS) to explore open sites
    private static boolean dfs(boolean[][] matrix, boolean[][] visited, int y, int x, int height, int width) {
        // Base case: reached the bottom row
        if (y == height - 1) {
            return true;
        }

        visited[y][x] = true;

        // Explore adjacent open sites
        if (y > 0 && !matrix[y - 1][x] && !visited[y - 1][x]) {
            if (dfs(matrix, visited, y - 1, x, height, width)) {
                return true;
            }
        }

        if (x > 0 && !matrix[y][x - 1] && !visited[y][x - 1]) {
            if (dfs(matrix, visited, y, x - 1, height, width)) {
                return true;
            }
        }

        if (x < width - 1 && !matrix[y][x + 1] && !visited[y][x + 1]) {
            if (dfs(matrix, visited, y, x + 1, height, width)) {
                return true;
            }
        }

        if (y < height - 1 && !matrix[y + 1][x] && !visited[y + 1][x]) {
            if (dfs(matrix, visited, y + 1, x, height, width)) {
                return true;
            }
        }

        return false;
    }
}
