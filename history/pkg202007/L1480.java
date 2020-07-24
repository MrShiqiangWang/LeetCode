package history.pkg202007;

public class L1480 {

    public int[] runningSum(final int[] nums) {
        if (nums.length == 0) {
            return new int[0];
        }
        final int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }
        return dp;
    }
}
