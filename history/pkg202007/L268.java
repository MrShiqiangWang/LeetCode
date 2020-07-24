package history.pkg202007;

import java.util.Arrays;

public class L268 {

    public int missingNumber(final int[] nums) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return mid + 1;
    }
}
