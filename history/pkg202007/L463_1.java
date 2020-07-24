package history.pkg202007;

import utils.MatrixHelper;

public class L463_1 {

    public static void main(final String[] args) {

        System.out.println(new L463_1().islandPerimeter(MatrixHelper.stringToMatrix("[[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]")));
    }

    public int islandPerimeter(final int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res += 4;
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        res -= 2;
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        res -= 2;
                    }
                }
            }
        }
        return res;
    }

}
