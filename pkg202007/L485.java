package pkg202007;

public class L485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int consecutiveOnes = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (consecutiveOnes != 0) {
                    max = Math.max(max, consecutiveOnes);
                }
                consecutiveOnes = 0;
            }
            else {
                consecutiveOnes++;
            }
        }
        return max;

    }
}
