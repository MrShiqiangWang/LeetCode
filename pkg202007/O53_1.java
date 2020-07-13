package pkg202007;

import utils.ArrayHelper;

public class O53_1 {

    public static void main(final String[] args) {
        new O53_1().search(ArrayHelper.stringToArray("[5,7,7,8,8,10]"), 8);
    }

    public int search(final int[] nums, final int target) {
        final int right = this.searchRight(nums, 0, nums.length - 1, target);
        final int left = this.searchLeft(nums, 0, nums.length - 1, target);
        return right - left + 1;
    }

    private int searchLeft(final int[] nums, int left, int right, final int target) {
        while (left <= right) {
            final int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return right + 1;
    }

    private int searchRight(final int[] nums, int left, int right, final int target) {
        while (left <= right) {
            final int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return left - 1;
    }
}
