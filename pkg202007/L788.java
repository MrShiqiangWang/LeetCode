package pkg202007;

public class L788 {

    public int rotatedDigits(int N) {
        // 不变，等于1
        // 好数，等于2,
        // 不好数，等于3，
        int dp[] = new int[N + 1 < 10 ? 10 : N + 1];
        dp[0] = 7;
        dp[1] = 7;
        dp[2] = 5;
        dp[3] = 1;
        dp[4] = 1;
        dp[5] = 5;
        dp[6] = 5;
        dp[7] = 1;
        dp[8] = 7;
        dp[9] = 5;
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if ((dp[i] = dp[i / 10] & dp[i % 10]) == 5) {
                sum++;
            }
        }
        return sum;
    }
}
