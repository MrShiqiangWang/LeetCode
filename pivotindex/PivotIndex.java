package pivotindex;

public class PivotIndex {

	public static void main(String[] args) {
		int[] a = { 1, 7, 3, 6, 5, 6 };
		System.out.println(new PivotIndex().pivotIndex(a));
	}

	public int pivotIndex(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if (nums.length == 0) {
			return -1;
		}
		if (nums.length == 1) {
			return 0;
		}
		int left = 0;
		int right = sum;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				right -= nums[i];
			} else {
				right -= nums[i];
				left = nums[i - 1] + left;
			}
			if (left == right) {
				return i;
			}
			if (right < left) {
				return -1;
			}
		}

		return -1;
	}
}
