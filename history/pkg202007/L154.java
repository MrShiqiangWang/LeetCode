package history.pkg202007;

import utils.ArrayHelper;

public class L154 {

    public static void main(final String[] args) {
        System.out.println(new L154().findMin(ArrayHelper.stringToArray("[3,3,1,3]")));
    }

    public int findMin(final int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == nums[right]) {
                if (nums[mid] == nums[left]) {
                    right = right - 1;
                }
                else {
                    right = mid;
                }
            }
            else if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return nums[mid];
    }
}
