package history.pkg202007;

import utils.ArrayHelper;

public class L643_1 {

	public static void main(String[] args) {
		System.out.println(new L643_1().findMaxAverage(ArrayHelper.stringToArray("[1,12,-5,-6,50,3]"), 4));
	}

	public double findMaxAverage(int[] nums, int k) {
		int sum[] = new int[nums.length + 1];
		sum[0] = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			sum[i + 1] = sum[i] + nums[i];
			if (i + 1 - k >= 0) {
				max = Math.max(sum[i + 1] - sum[i + 1 - k], max);
			}
		}
		return Integer.valueOf(max).doubleValue() / k;
	}
}
