package history.pkg201906;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(final int x) {
            this.val = x;
        }
    }

    public List<Double> averageOfLevels(final TreeNode root) {
        Queue<TreeNode> from = new LinkedList<AverageOfLevels.TreeNode>();
        Queue<TreeNode> to = new LinkedList<AverageOfLevels.TreeNode>();
        from.add(root);
        final List<Double> result = new ArrayList<Double>();
        while (true) {
            // ����from ������������ݵľ�ֵ
            result.add(this.averageOfNodes(from));
            while (from.size() != 0) {
                final TreeNode node = from.poll();
                if (node.left != null) {
                    to.add(node);
                }
                if (node.right != null) {
                    to.add(node);
                }
            }
            if (to.size() == 0) {
                break;
            }
            final Queue<TreeNode> tmp = from;
            from = to;
            to = tmp;
        }
        return result;

    }

    private Double averageOfNodes(final Queue<TreeNode> from) {
        Double sum = 0.0;
        for (final TreeNode node : from) {
            sum += node.val;
        }
        return sum / from.size();
    }
}
