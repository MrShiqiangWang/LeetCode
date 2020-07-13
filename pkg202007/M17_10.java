package pkg202007;

import java.util.Arrays;

public class M17_10 {

    public int majorityElement(final int[] nums) {
        Arrays.sort(nums);
        final int mid = nums.length / 2 + 1;
        if (nums[mid] != nums[0] && nums[mid] != nums[nums.length - 1]) {
            return -1;
        }
        return nums[mid];
    }
}
