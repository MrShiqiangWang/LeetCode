package pkg202007;

import java.util.HashMap;
import java.util.Map;

public class L205 {
	public boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] sx = mophic(s);
		int[] tx = mophic(t);
		for (int i = 0; i < sx.length; i++) {
			if (sx[i] != tx[i]) {
				return false;
			}
		}
		return true;

	}

	private int[] mophic(String s) {
		int[] re = new int[s.length()];
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int counter = 0;
		char[] cs = s.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if (map.containsKey(cs[i])) {
				re[i] = map.get(cs[i]);
			} else {
				map.put(cs[i], counter);
				re[i] = counter;
				counter++;
			}
		}
		return re;
	}
}
