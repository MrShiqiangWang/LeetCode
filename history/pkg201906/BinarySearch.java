package history.pkg201906;

public class BinarySearch {

    public static int binarySearch(final int[] nums, int left, int right, final int key) {
        if (nums[left] > key) {
            return -1;
        }
        if (nums[right] < key) {
            return -1;
        }
        while (left <= right) {
            final int mid = (left + right) / 2;
            final int value = nums[mid];
            if (value == key) {
                return mid;
            }
            else if (value < key) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
