package package_in_201906;

public class NumArray {
	private int nums[];

	public NumArray(int[] nums) {
		this.nums = nums;
	}

	public void update(int i, int val) {
		this.nums[i] = val;
	}

	public int sumRange(int i, int j) {
		int sum = 0;
		for (int k = i; k <= j; k++) {
			sum = nums[k] + sum;
		}
		return sum;
	}
}
