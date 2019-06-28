package canconstruct;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct {

    public static void main(String[] args) {
        System.out.println(new CanConstruct().canConstruct("aa", "ab"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        char[] ran = ransomNote.toCharArray();
        char[] mag = magazine.toCharArray();
        Map<Character, Integer> ranmap = new HashMap<>();
        Map<Character, Integer> magmap = new HashMap<>();
        // 对于每个数组遍历，计数每个字符
        for (int i = 0; i < ran.length; i++) {
            // 计数加一
            if (!ranmap.containsKey(ran[i])) {
                ranmap.put(ran[i], 1);
            }
            else {
                ranmap.put(ran[i], ranmap.get(ran[i]) + 1);
            }
        }

        // 对于每个数组遍历，计数每个字符
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
        for (Character c : ranmap.keySet()) {

            if ((!magmap.containsKey(c)) || ranmap.get(c) > magmap.get(c)) {
                return false;
            }
        }
        return true;
    }
}
