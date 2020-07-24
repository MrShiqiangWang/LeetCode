package history.pkg202007;

public class L283 {
	public void moveZeroes(int[] nums) {
		int numOfZero = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				numOfZero++;
			} else {
				if (numOfZero != 0) {
					nums[i - numOfZero] = nums[i];
					nums[i] = 0;
				}
			}
		}
	}
}
