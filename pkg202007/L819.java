package pkg202007;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class L819 {

	public static void main(String[] args) {
		String[] banned = { "bob", "hit" };
		System.out.println(new L819().mostCommonWord("Bob. hIt, baLl", banned));
	}

	public String mostCommonWord(String paragraph, String[] banned) {
		char[] cs = paragraph.toCharArray();
		StringBuilder wordBuilder = new StringBuilder();
		HashSet<String> set = new HashSet<>();
		for (String arg : banned) {
			set.add(arg);
		}
		Map<String, Integer> map = new HashMap<String, Integer>();
		int frequence = 0;
		String re = null;
		for (int i = 0; i < cs.length; i++) {
			if (Character.isLetter(cs[i])) {
				wordBuilder.append(Character.toLowerCase(cs[i]));

			} else {
				if (wordBuilder.length() == 0) {
					continue;
				}
				if (!set.contains(wordBuilder.toString())) {
					map.put(wordBuilder.toString(), map.getOrDefault(wordBuilder.toString(), 0) + 1);
					if (map.getOrDefault(wordBuilder.toString(), 0) > frequence) {
						re = wordBuilder.toString();
						frequence = map.getOrDefault(wordBuilder.toString(), 0);
					}
				}
				wordBuilder = new StringBuilder();
			}
		}
		if (wordBuilder.length() > 0 && !set.contains(wordBuilder.toString())) {
			map.put(wordBuilder.toString(), map.getOrDefault(wordBuilder.toString(), 0) + 1);
			if (map.getOrDefault(wordBuilder.toString(), 0) > frequence) {
				return wordBuilder.toString();
			}
		}
		return re;
	}
}
