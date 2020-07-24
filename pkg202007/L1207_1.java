package pkg202007;

import java.util.Arrays;

public class L1207_1 {
	public boolean uniqueOccurrences(int[] arr) {
		int[] array = new int[2001];
		for (Integer val : arr) {
			arr[val + 1000] += 1;
		}
		Arrays.sort(array);
		int pre = array[0];
		for (int i = 1; i < array.length; i++) {
			if (pre != 0 && array[i] == pre) {
				return false;
			}
			pre = array[i];
		}
		return true;
	}

}
