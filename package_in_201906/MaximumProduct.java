package package_in_201906;

import java.util.Arrays;

public class MaximumProduct {
	public int maximumProduct(int[] nums) {
		// 排序
		Arrays.sort(nums);
		// 三个正数
		// 一个正数两个负数
		int max = 0;
		if (nums[0] < 0 && nums[1] < 0 && nums[nums.length - 1] > 0) {
			max=Math.max(max, nums[0] * nums[1] * nums[nums.length - 1]);
		}
		if (nums[nums.length - 1] > 0 && nums[nums.length - 2] > 0 && nums[nums.length - 3] > 0) {
			max=Math.max(max, nums[nums.length - 2] * nums[nums.length - 3] * nums[nums.length - 1]);
		}
		return max;
	}
}
