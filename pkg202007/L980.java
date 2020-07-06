package pkg202007;

import utils.MatrixHelper;

public class L980 {

    public static void main(final String[] args) {
        final int[][] matrix = MatrixHelper.stringToMatrix("[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]");
        System.out.println(new L980().uniquePathsIII(matrix));
    }

    public int uniquePathsIII(final int[][] grid) {

        int startI = -1;
        int startJ = -1;
        // 找到起始位置
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    startI = i;
                    startJ = j;
                    break;
                }
            }
        }

        return this.run(grid, startI, startJ);
    }

    private boolean end(final int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private int run(final int[][] grid, final int i, final int j) {
        // 如果走出去了，则0次
        if (i < 0
                || i >= grid.length
                || j < 0
                || j >= grid[0].length) {
            return 0;
        }

        // 被堵住了，则当前次数为0
        if (grid[i][j] == -1) {
            return 0;
        }
        // 如果是2,如果已经全部走了一遍
        if (grid[i][j] == 2) {
            if (this.end(grid)) {
                return 1;
            }
        }
        final int tmp = grid[i][j];
        grid[i][j] = -1;
        int sum = 0;
        sum += this.run(grid, i - 1, j);
        sum += this.run(grid, i + 1, j);
        sum += this.run(grid, i, j - 1);
        sum += this.run(grid, i, j + 1);
        grid[i][j] = tmp;
        return sum;
    }
}
