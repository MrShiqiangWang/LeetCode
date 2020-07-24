package history.pkg202007;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class L748 {

    public String shortestCompletingWord(final String licensePlate, final String[] words) {
        // 分析单词牌照包含哪些字母

        final char[] cs = licensePlate.toCharArray();
        final Map<Character, Integer> licenseMap = new HashMap<Character, Integer>();
        for (int i = 0; i < cs.length; i++) {
            if (Character.isAlphabetic(cs[i])) {
                licenseMap.put(Character.toLowerCase(cs[i]), licenseMap.getOrDefault(Character.toLowerCase(cs[i]), 0) + 1);
            }
        }
        int min = 16;
        String shortestWord = null;
        // 对每个字母分析是否包含这些字�?
        for (int i = 0; i < words.length; i++) {
            if (this.passLicense(licenseMap, words[i])) {
                if (words[i].length() < min) {
                    // 更新�?短长�?
                    shortestWord = words[i];
                    min = words[i].length();
                }
            }
        }
        // 包含的这些字母里面获取最小的长度

        // 取出第一�?
        return shortestWord;
    }

    private boolean passLicense(final Map<Character, Integer> licenseMap, final String word) {
        final Map<Character, Integer> map = new HashMap<>();
        final char[] cs = word.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            map.put(cs[i], map.getOrDefault(cs[i], 0) + 1);
        }
        for (final Entry<Character, Integer> entry : licenseMap.entrySet()) {
            if (map.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
