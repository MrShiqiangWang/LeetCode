package pkg202007;

import utils.ArrayHelper;

public class O53_1 {

	public static void main(String[] args) {
		new O53_1().search(ArrayHelper.stringToArray("[5,7,7,8,8,10]"), 8);
	}

	public int search(int[] nums, int target) {
		int right = searchRight(nums, 0, nums.length - 1, target);
		int left = searchLeft(nums, 0, nums.length - 1, target);
		return right - left + 1;
	}

	private int searchLeft(int[] nums, int left, int right, int target) {
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

	private int searchRight(int[] nums, int left, int right, int target) {
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
