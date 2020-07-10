package pkg202007;

import utils.ArrayHelper;

public class L35 {

    public static void main(final String[] args) {

        new L35().searchInsert(ArrayHelper.stringToArray("[1,3,5,6]"), 2);
    }

    public int searchInsert(final int[] nums, final int target) {
        return this.searchInsert(nums, 0, nums.length, target);
    }

    private int searchInsert(final int[] nums, final int left, final int right, final int target) {
        if (right < left) {

        }
        final int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] > target) {
            return this.searchInsert(nums, left, mid - 1, target);
        }
        else {
            return this.searchInsert(nums, mid + 1, right, target);
        }
    }
}
