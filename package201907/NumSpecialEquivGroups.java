package package201907;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class NumSpecialEquivGroups {

    public static void main(String[] args) {
        String[] A = { "abc", "acb", "bac", "bca", "cab", "cba" };
        System.out.println(new NumSpecialEquivGroups().numSpecialEquivGroups(A));
    }

    class GroupItem {

        int jishuLength = 0;
        int oushuLength = 0;
        char[] jishu;
        char[] oushu;
    }

    public int numSpecialEquivGroups(String[] A) {

        List<GroupItem> groupItems = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            // 需要判断奇数，偶数位置上面的数据是否个数相同，形状相同
            char[] chas = A[i].toCharArray();
            if (chas.length == 0) {
                GroupItem groupItem = new GroupItem();
                groupItem.jishuLength = 0;
                groupItem.oushuLength = 0;
                groupItem.jishu = new char[0];
                groupItem.oushu = new char[0];
                if (!hasGroupItem(groupItem, groupItems)) {
                    sum++;
                    groupItems.add(groupItem);
                }
                continue;
            }

            int length = chas.length;
            char[] jishu = new char[length / 2 + length % 2];
            char[] oushu = new char[length / 2];

            for (int j = 0; j < chas.length; j++) {
                // 奇数
                if (j % 2 == 0) {
                    jishu[j / 2] = chas[j];
                }
                // 偶数
                else {
                    oushu[j / 2] = chas[j];
                }
            }

            GroupItem groupItem = new GroupItem();
            Arrays.sort(jishu);
            Arrays.sort(oushu);
            groupItem.jishu = jishu;
            groupItem.oushu = oushu;
            groupItem.jishuLength = jishu.length;
            groupItem.oushuLength = oushu.length;

            if (!hasGroupItem(groupItem, groupItems)) {
                sum++;
                groupItems.add(groupItem);
            }
        }
        return sum;
    }

    private boolean hasGroupItem(GroupItem groupItem, List<GroupItem> groupItems) {
        Optional<GroupItem> optional = groupItems.stream().filter(r -> {
            if (r.jishuLength == groupItem.jishuLength && r.oushuLength == groupItem.oushuLength) {
                char[] rjishu = r.jishu;
                char[] jishu = groupItem.jishu;
                for (int i = 0; i < r.jishuLength; i++) {
                    if (rjishu[i] != jishu[i]) {
                        return false;
                    }
                }

                char[] roushu = r.oushu;
                char[] oushu = groupItem.oushu;
                for (int i = 0; i < r.oushuLength; i++) {
                    if (roushu[i] != oushu[i]) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }).findAny();

        if (optional.isPresent()) {
            return true;
        }
        return false;
    }
}
