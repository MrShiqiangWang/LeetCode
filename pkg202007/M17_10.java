package pkg202007;

import java.util.Arrays;

public class M17_10 {

	public int majorityElement(int[] nums) {
		int temp = nums[0];
		int counter = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == temp) {
				counter++;
			} else {
				counter--;
			}
			if (counter < 0) {
				counter = 1;
				temp = nums[i];
			}
		}
		return temp;
	}
}
