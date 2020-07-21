package pkg202007;

public class L463 {

    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return islandPerimeter(grid, i, j);
                }
            }
        }
        return -1;
    }

    private int islandPerimeter(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
            return 1;
        }
        if (grid[i][j] == 0) {
            return 1;
        }
        if (grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 2;
        return islandPerimeter(grid, i + 1, j)
                + islandPerimeter(grid, i - 1, j)
                + islandPerimeter(grid, i, j + 1)
                + islandPerimeter(grid, i, j - 1);
    }
}
