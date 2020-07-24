package pkg202007;

import java.util.Arrays;

public class L16 {

    public static void main(final String[] args) {
        final int[] S = { 0, 1, 2 };
        final int target = 0;
        System.out.println(new L16().threeSumClosest(S, target));
    }

    public int threeSumClosest(final int[] nums, final int target) {
        Arrays.sort(nums);
        int nearest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                // ����i
                if (left == i) {
                    left++;
                }
                if (right == i) {
                    right--;
                }
                if (left >= right) {
                    break;
                }
                final int value = nums[i] + nums[left] + nums[right];
                if (Math.abs(nearest - target) > Math.abs(value - target)) {
                    nearest = value;
                }
                if (value - target >= 0) {
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        return nearest;
    }

    // public int getNearestTarget(int[] S, int target) {
    // int dp[][] = new int[S.length][S.length];
    // for (int i = 0; i < S.length; i++) {
    // dp[i][i] = S[i];
    // }
    // for (int i = 0; i < S.length; i++) {
    // for (int j = i + 1; j < S.length; j++) {
    // dp[i][j] = dp[i][i] + S[j];
    // }
    // }
    //
    // int nearest = Integer.MAX_VALUE;
    // boolean first = true;
    // for (int i = 0; i < S.length; i++) {
    // for (int j = i + 1; j < S.length; j++) {
    // for (int k = j + 1; k < S.length; k++) {
    // int value = dp[i][j] + S[k];
    // if (first) {
    // first = false;
    // nearest = value;
    // } else {
    // if (Math.abs(nearest - target) > Math.abs(value - target)) {
    // nearest = value;
    // }
    // }
    // }
    // }
    // }
    //
    // return nearest;
    //
    // }
}
