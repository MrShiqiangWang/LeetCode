package history.pkg202007;

import utils.ArrayHelper;

public class L239 {

    public static void main(final String[] args) {
        final int[] nums = ArrayHelper.stringToArray("[1,3,-1,-3,5,3,6,7]");
        System.out.println(new L239().maxSlidingWindow(nums, 3));
    }

    public int[] maxSlidingWindow(final int[] nums, final int k) {
        final int[] max = new int[nums.length - k + 1];
        for (int i = 0, j = k - 1; i < nums.length && j < nums.length; i++, j++) {
            final int tempMax = this.max(nums, i, j);
            max[i] = tempMax;
        }
        return max;
    }

    private int max(final int[] nums, int i, final int j) {
        int max = nums[i];
        for (; i <= j; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        return max;
    }

}
