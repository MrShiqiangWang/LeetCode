package pkg202007;

import java.util.LinkedList;
import java.util.Queue;

public class L643 {
	public double findMaxAverage(int[] nums, int k) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			queue.add(nums[i]);
			if (queue.size() == k) {
				sum += nums[i];
				max = Math.max(sum, max);
			} else if (queue.size() < k) {
				sum += nums[i];
			} else {
				int val = queue.poll();
				sum -= val;
				max = Math.max(sum, max);
			}
		}
		return Integer.valueOf(max).doubleValue() / k;
	}
}
