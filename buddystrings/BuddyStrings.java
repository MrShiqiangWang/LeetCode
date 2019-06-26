package buddystrings;

import java.util.ArrayList;
import java.util.List;

public class BuddyStrings {

    public static void main(String[] args) {
        System.out.println(new BuddyStrings().buddyStrings("ab", "ba"));
    }

    public boolean buddyStrings(String A, String B) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        // 如果两者的长度不相同
        if (a.length != b.length) {
            return false;
        }

        List<Integer> list = new ArrayList<>();
        // 如果仅有两个位置的字符不同
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                list.add(i);
            }
        }
        // 如果有多余两个的数据，则返回
        if (list.size() != 2 && list.size() != 0) {
            return false;
        }
        // 如果是两个位置
        if (list.size() == 2) {
            if (a[list.get(0)] == b[list.get(1)] && a[list.get(1)] == b[list.get(0)]) {
                return true;
            }
        }

        if (list.size() == 0) {
            // 需要判断是否有两个相同的字符
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
