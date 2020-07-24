package history.pkg202007;

import java.util.HashMap;

public class L387 {

    public static void main(final String[] args) {
        System.out.println(new L387().firstUniqChar("leetcode"));
    }

    public int firstUniqChar(final String s) {
        final HashMap<Character, Integer> map = new HashMap<>();
        final char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            map.put(cs[i], map.getOrDefault(cs[i], 0) + 1);
        }

        for (int i = 0; i < cs.length; i++) {
            if (map.getOrDefault(cs[i], 0) == 1) {
                return i;
            }
        }
        return -1;
    }
}
