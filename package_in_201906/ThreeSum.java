package package_in_201906;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		// 对数组排序
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		// 排序后使用双指针发
		int i = 0;
		int j = nums.length;
		for (; i < nums.length; i++) {
			// 两个方向的指针
			for (j = nums.length - 1; j > i; j--) {
				
				for (int k = i+1; k <j; k++) {
					if (nums[i] + nums[j] + nums[k] == 0) {
						List<Integer> item = new ArrayList<>();
						item.add(nums[i]);
						item.add(nums[j]);
						item.add(nums[k]);
						result.add(item);
					}
				}
			}
		}
		return result;
	}
}
