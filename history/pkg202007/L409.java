package history.pkg202007;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class L409 {

    public int longestPalindrome(final String s) {
        final char[] cs = s.toCharArray();
        final Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < cs.length; i++) {
            map.put(cs[i], map.getOrDefault(cs[i], 0) + 1);
        }
        boolean odd = false;
        int longest = 0;
        for (final Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                odd = true;
            }
            longest += entry.getValue() / 2 * 2;
        }
        if (odd) {
            longest++;
        }
        return longest;
    }
}
