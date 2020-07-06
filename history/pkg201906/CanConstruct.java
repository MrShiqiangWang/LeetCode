package history.pkg201906;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct {

    public static void main(final String[] args) {
        System.out.println(new CanConstruct().canConstruct("aa", "ab"));
    }

    public boolean canConstruct(final String ransomNote, final String magazine) {
        final char[] ran = ransomNote.toCharArray();
        final char[] mag = magazine.toCharArray();
        final Map<Character, Integer> ranmap = new HashMap<>();
        final Map<Character, Integer> magmap = new HashMap<>();
        // 对于每个数组遍历，计数每个字�?
        for (int i = 0; i < ran.length; i++) {
            // 计数加一
            if (!ranmap.containsKey(ran[i])) {
                ranmap.put(ran[i], 1);
            }
            else {
                ranmap.put(ran[i], ranmap.get(ran[i]) + 1);
            }
        }

        // 对于每个数组遍历，计数每个字�?
        for (int i = 0; i < mag.length; i++) {
            // 计数加一
            if (!magmap.containsKey(mag[i])) {
                magmap.put(mag[i], 1);
            }
            else {
                magmap.put(mag[i], magmap.get(mag[i]) + 1);
            }
        }
        if (ranmap.keySet().size() > magmap.keySet().size()) {
            return false;
        }
        for (final Character c : ranmap.keySet()) {

            if ((!magmap.containsKey(c)) || ranmap.get(c) > magmap.get(c)) {
                return false;
            }
        }
        return true;
    }
}
