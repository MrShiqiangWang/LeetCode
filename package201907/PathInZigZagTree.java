package package201907;

import java.util.ArrayList;
import java.util.List;

public class PathInZigZagTree {

    public List<Integer> pathInZigZagTree(int label) {
        // 1
        // 2.3
        // 4,5,6,7
        // 8,9,10,11,12,13,14,15
        // 16

        // 假设是正确的标记方式
        List<Integer> result = new ArrayList<>();

        int key = label;
        while (key > 0) {
            // 父节点的标记
            key = key / 2;
            result.add(key);
        }

        // 得到成熟
        int level = result.size();

        while (level % 2 == 1) {

        }

    }
}
