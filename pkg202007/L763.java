package pkg202007;

import java.util.ArrayList;
import java.util.List;

public class L763 {
	public static void main(String[] args) {
		System.out.println((int) 'a');
	}

	public List<Integer> partitionLabels(String S) {
		char[] cs = S.toCharArray();
		int[] counter = new int[26];
		for (int i = 0; i < cs.length; i++) {
			counter[cs[i] - 'a'] = i;
		}

		List<Integer> result = new ArrayList<>();
		int j = 0, anchor = 0;
		for (int i = 0; i < cs.length; i++) {
			j = Math.max(j, counter[cs[i] - 'a']);
			if (i == j) {
				result.add(i - anchor + 1);
				anchor = i + 1;
			}
		}
		return result;
	}
}
