package pkg202007;

public class L63 {

    public int uniquePathsWithObstacles(final int[][] obstacleGrid) {
        final int[][] dp = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return this.uniquePathsWithObstacles(obstacleGrid, 0, 0, dp);
    }

    private int uniquePathsWithObstacles(final int[][] obstacleGrid, final int i, final int j, final int[][] dp) {
        if (i >= obstacleGrid.length) {
            return 0;
        }
        if (j >= obstacleGrid[0].length) {
            return 0;
        }
        if (obstacleGrid[i][j] == 1) {
            return 0;
        }
        if (i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1) {
            return 1;
        }
        if (dp[i + 1][j] == -1) {
            dp[i + 1][j] = this.uniquePathsWithObstacles(obstacleGrid, i + 1, j, dp);
        }
        if (dp[i][j + 1] == -1) {
            dp[i][j + 1] = this.uniquePathsWithObstacles(obstacleGrid, i, j + 1, dp);
        }

        return dp[i + 1][j] + dp[i][j + 1];
    }
}
