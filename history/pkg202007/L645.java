package history.pkg202007;

import java.util.Arrays;

import utils.ArrayHelper;

public class L645 {

	public static void main(String[] args) {
		System.out.println(new L645().findErrorNums(ArrayHelper.stringToArray("[2,2]")));
	}

	public int[] findErrorNums(int[] nums) {
		Arrays.sort(nums);
		int counter = 0, repeat = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == counter + 1) {
				counter++;
			}
			if (i - 1 >= 0 && nums[i] == nums[i - 1]) {
				repeat = nums[i];
			}
		}
		int[] re = { repeat, counter + 1 };
		return re;
	}
}
