package uniquepaths;

import java.util.HashMap;
import java.util.Map;

public class UniquePaths {
	public int uniquePaths(int m, int n) {
		if (m == 1 && n == 1) {
			return 1;
		}
		int[][] memo = new int[m + 1][n + 1];
		return uniquePaths(1, 0, m, n, memo) + uniquePaths(0, 1, m, n, memo);
	}

	private int uniquePaths(int i, int j, int m, int n, int[][] memo) {
		if (i >= m || j >= n) {
			return 0;
		}
		if (i == m - 1 && j == n - 1) {
			return 1;
		}
		if (memo[i][j]>0) {
			return memo[i][j];
		}
		int value = uniquePaths(i + 1, j, m, n, memo) + uniquePaths(i, j + 1, m, n, memo);
		memo[i][j]=value;
		return value;
	}
}
