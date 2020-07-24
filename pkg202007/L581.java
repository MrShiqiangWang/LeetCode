package pkg202007;

import java.util.Arrays;

public class L581 {
	public int findUnsortedSubarray(int[] nums) {
		int[] newArray = Arrays.copyOfRange(nums, 0, nums.length);
		Arrays.sort(newArray);
		int startIndex = -1;
		int endIndex = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != newArray[i]) {
				if (startIndex == -1) {
					startIndex = i;
				} else {
					endIndex = i;
				}
			}
		}
		return endIndex - startIndex + 1;
	}
}
