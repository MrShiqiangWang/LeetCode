package package_in_201907;

import java.util.Arrays;
import java.util.Comparator;

public class IsAlienSorted {
	public boolean isAlienSorted(String[] words, String order) {
		String[] newWords = Arrays.copyOfRange(words, 0, words.length);

		Arrays.sort(newWords, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				char[] o1s = o1.toCharArray();
				char[] o2s = o2.toCharArray();
				// 遍历
				for (int i = 0; i < o1s.length && i < o2s.length; i++) {
					if (o1s[i] != o2s[i]) {
						// 比较对应的字符在字符串order中的位置
						int inO1 = order.indexOf(o1s[i]);
						int inO2 = order.indexOf(o2s[i]);
						if (inO1 < inO2) {
							return -1;
						}
					}
				}
				if (o1s.length == o2s.length) {
					return 0;
				}
				if (o1.length() < o2s.length) {
					return -1;
				} else {
					return 1;
				}
			}
		});

		for (int i = 0; i < newWords.length; i++) {
			if (!newWords[i].equals(words[i])) {
				return false;
			}
		}
		return true;
	}
}
