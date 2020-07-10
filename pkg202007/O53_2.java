package pkg202007;

public class O53_2 {
	public int missingNumber(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		int mid = -1;
		while (left <= right) {
			mid = (left + right) / 2;
			if (nums[mid] == mid) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		if (mid > 0) {
			return nums[mid];
		}
		return -1;
	}
}
