package history.pkg202007;

import java.util.ArrayList;
import java.util.List;

public class L821 {
	public int[] shortestToChar(String S, char C) {
		char[] cs = S.toCharArray();
		List<Integer> charIndexMap = new ArrayList<Integer>();
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] == C) {
				charIndexMap.add(i);
			}
		}
		int v = 0;
		int[] re = new int[cs.length];
		for (int i = 0; i < cs.length;) {
			int valueIndex = charIndexMap.get(v);
			if (v == 0 && valueIndex >= i) {
				re[i] = valueIndex - i;
				i++;
				continue;
			} else if (valueIndex < i && v + 1 == charIndexMap.size()) {
				re[i]=i-valueIndex;
				i++;
				continue;
			}else if(i>valueIndex&&i<=charIndexMap.get(v+1)) {
				re[i]=Math.min(i-valueIndex, charIndexMap.get(v+1)-i);
				i++;
				continue;
			}else {
				v++;
			}
		}
		return re;
	}
}
