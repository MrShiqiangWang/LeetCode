package binarysearch;

public class BinarySearch {

    public static int binarySearch(int[] nums, int left, int right, int key) {
        if (nums[left] > key) {
            return -1;
        }
        if (nums[right] < key) {
            return -1;
        }
        while (left <= right) {
            int mid = (left + right) / 2;
            int value = nums[mid];
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
