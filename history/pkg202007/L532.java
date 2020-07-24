package history.pkg202007;

import java.util.Arrays;

import utils.ArrayHelper;

public class L532 {

    public static void main(final String[] args) {
        System.out.println(new L532().findPairs(ArrayHelper.stringToArray("[3,1,4,1,5]"), 2));
    }

    public int findPairs(final int[] nums, final int k) {
        Arrays.sort(nums);
        int i = 0, j = 0, sum = 0;
        for (; i < nums.length;) {
            if (i - 1 >= 0 && nums[i - 1] == nums[i]) {
                i++;
                continue;
            }
            for (j = i + 1; j < nums.length;) {
                if (j - 1 >= 0 && nums[j - 1] == nums[j]) {
                    j++;
                    continue;
                }
                if (Math.abs(nums[i] - nums[j]) == k) {
                    sum++;
                }
                j++;
            }
            i++;
        }
        return sum;
    }
}
