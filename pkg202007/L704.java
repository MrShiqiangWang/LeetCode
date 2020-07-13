package pkg202007;

public class L704 {

    public int search(final int[] nums, final int target) {

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            final int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
