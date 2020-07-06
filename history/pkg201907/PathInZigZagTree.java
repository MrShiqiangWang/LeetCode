package history.pkg201907;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathInZigZagTree {

    public static void main(final String[] args) {
        new PathInZigZagTree().pathInZigZagTree(14);
    }

    public List<Integer> pathInZigZagTree(final int label) {
        int key = label;

        final List<Integer> result = new ArrayList<>();

        int level = 0;
        while (key > 0) {
            result.add(key);
            key = key / 2;
            level++;
        }

        // �����е�ż������е���
        for (int i = 1; i < result.size(); i = i + 2) {
            final int size = (int) Math.pow(2, level - 2);
            final int start = size;
            result.set(i, start + size - (result.get(i) - start) - 1);
            level = level - 2;
        }

        Collections.sort(result);
        return result;
    }
}
