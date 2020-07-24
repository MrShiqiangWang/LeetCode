package pkg202007;

import java.util.HashMap;
import java.util.Map;

public class L290 {
	public boolean wordPattern(String pattern, String str) {

		int[] pt = pattern(pattern.toCharArray());
		int[] st = pattern(str.split(" "));
		if (pt.length != st.length) {
			return false;
		}
		for (int i = 0; i < pt.length; i++) {
			if (pt[i] != st[i]) {
				return false;
			}
		}
		return true;
	}

	private int[] pattern(char[] charArray) {
		Character[] result = new Character[charArray.length];
		for (int i = 0; i < charArray.length; i++) {
			result[i] = charArray[i];
		}
		return pattern(result);
	}

	private <T> int[] pattern(T[] split) {
		Map<T, Integer> map = new HashMap<T, Integer>();
		int counter = 0;
		int[] result = new int[split.length];
		for (int i = 0; i < split.length; i++) {
			if (map.containsKey(split[i])) {
				result[i] = map.get(split[i]);
			} else {
				result[i] = counter;
				map.put(split[i], counter);
				counter++;
			}
		}
		return result;
	}
}
