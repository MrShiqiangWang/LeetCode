package history.pkg201906;

public class UniquePaths {

    public int uniquePaths(final int m, final int n) {
        if (m == 1 && n == 1) {
            return 1;
        }
        final int[][] memo = new int[m + 1][n + 1];
        return this.uniquePaths(1, 0, m, n, memo) + this.uniquePaths(0, 1, m, n, memo);
    }

    private int uniquePaths(final int i, final int j, final int m, final int n, final int[][] memo) {
        if (i >= m || j >= n) {
            return 0;
        }
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (memo[i][j] > 0) {
            return memo[i][j];
        }
        final int value = this.uniquePaths(i + 1, j, m, n, memo) + this.uniquePaths(i, j + 1, m, n, memo);
        memo[i][j] = value;
        return value;
    }
}
