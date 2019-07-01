package package_in_201906;

import java.util.ArrayList;
import java.util.List;

public class BuddyStrings {

    public static void main(String[] args) {
        System.out.println(new BuddyStrings().buddyStrings("ab", "ba"));
    }

    public boolean buddyStrings(String A, String B) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        // 濡傛灉涓よ�呯殑闀垮害涓嶇浉鍚�
        if (a.length != b.length) {
            return false;
        }

        List<Integer> list = new ArrayList<>();
        // 濡傛灉浠呮湁涓や釜浣嶇疆鐨勫瓧绗︿笉鍚�
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                list.add(i);
            }
        }
        // 濡傛灉鏈夊浣欎袱涓殑鏁版嵁锛屽垯杩斿洖
        if (list.size() != 2 && list.size() != 0) {
            return false;
        }
        // 濡傛灉鏄袱涓綅缃�
        if (list.size() == 2) {
            if (a[list.get(0)] == b[list.get(1)] && a[list.get(1)] == b[list.get(0)]) {
                return true;
            }
        }

        if (list.size() == 0) {
            // 闇�瑕佸垽鏂槸鍚︽湁涓や釜鐩稿悓鐨勫瓧绗�
            for (int i = 0; i < a.length; i++) {
                for (int j = i + 1; j < a.length; j++) {
                    if (a[i] == b[j]) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
