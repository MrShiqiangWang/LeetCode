package history.pkg202007;

public class L1 {

    public int[] twoSum(final int[] nums, final int target) {
        final int result[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
}
