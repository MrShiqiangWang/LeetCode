package history.pkg202007;

public class L1416 {

    public static void main(final String[] args) {
        System.out.println(new L1416().numberOfArrays("1317", 2000));
    }

    public int numberOfArrays(final String s, final int k) {
        final char[] cs = s.toCharArray();
        final int[] dp = new int[cs.length];
        dp[0] = 1;
        for (int i = 1; i < cs.length; i++) {
            if (cs[i] == '0') {
                continue;
            }
            for (int j = i; j < cs.length; j++) {
                if (this.sum(cs, i, j) <= k) {
                    dp[i] += dp[j];
                }
                else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[dp.length - 1];
    }

    private int sum(final char[] cs, int i, final int j) {
        final StringBuilder builder = new StringBuilder();
        for (; i < j; i++) {
            builder.append(cs[i]);
        }
        return Integer.parseInt(builder.toString());
    }

}
