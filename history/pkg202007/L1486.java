package history.pkg202007;

public class L1486 {

    public int xorOperation(final int n, final int start) {
        final int dp[] = new int[n];
        dp[0] = start;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + 2;
        }
        int result = 0;
        for (int i = 0; i < dp.length; i++) {
            result = result ^ dp[i];
        }
        return result;
    }
}
