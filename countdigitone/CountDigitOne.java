package countdigitone;

import java.util.HashMap;
import java.util.Map;

public class CountDigitOne {
	
	public int countDigitOne1(int n) {
		return 0;
	}
	public int countDigitOne(int n) {
		Map<Integer, Integer> count1 = new HashMap<>();
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int sum = 1;
		count1.put(1, 1);
		for (int i = 2; i <= n; i++) {
			int count = count1.get(i - 1);
			int ii = tickCount(i);
			sum += ii;
			count = count + ii;
			count1.put(i, count);
		}
		return sum;
	}

	private int tickCount(int s) {
		String string = String.valueOf(s);
		char[] cs = string.toCharArray();
		int count = 0;
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] == '1') {
				count++;
			}
		}
		return count;
	}
}
