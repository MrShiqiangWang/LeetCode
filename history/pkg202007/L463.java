package history.pkg202007;

public class L463 {

    public int islandPerimeter(final int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return this.islandPerimeter(grid, i, j);
                }
            }
        }
        return -1;
    }

    private int islandPerimeter(final int[][] grid, final int i, final int j) {
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
        return this.islandPerimeter(grid, i + 1, j)
                + this.islandPerimeter(grid, i - 1, j)
                + this.islandPerimeter(grid, i, j + 1)
                + this.islandPerimeter(grid, i, j - 1);
    }
}
