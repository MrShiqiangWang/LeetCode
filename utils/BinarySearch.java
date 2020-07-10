package utils;

public class BinarySearch {
	/**
	 * 重复最左
	 * 
	 * @param nums
	 * @param left
	 * @param right
	 * @param target
	 * @return
	 */
	public static int searchLeft(int[] nums, int left, int right, int target) {
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return right + 1;
	}

	/**
	 * 重复最右
	 * 
	 * @param nums
	 * @param left
	 * @param right
	 * @param target
	 * @return
	 */
	public static int searchRight(int[] nums, int left, int right, int target) {
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left - 1;
	}
}
