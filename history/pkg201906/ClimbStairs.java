package history.pkg201906;

public class ClimbStairs {

    public int climbStairs(final int n) {
        final int[] memo = new int[n + 1];
        return this.climbStairs(1, n, memo) + this.climbStairs(2, n, memo);
    }

    private int climbStairs(final int i, final int n, final int[] memo) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = this.climbStairs(i + 1, n, memo) + this.climbStairs(i + 2, n, memo);
        return memo[i];
    }
}
