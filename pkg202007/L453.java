package pkg202007;

import java.util.Arrays;

public class L453 {

    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int moves = 0;
        for (int i = 1; i < nums.length; i++) {
            int diff = (nums[i] + moves) - nums[i - 1];
            nums[i] += moves;
            moves += diff;
        }
        return moves;
    }
}
