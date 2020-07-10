package pkg202007;

public class L136 {
	public int singleNumber(int[] nums) {
		int num = 0;
		for (int i = 0; i < nums.length; i++) {
			num = nums[i] ^ num;
		}
		return num;
	}
}
