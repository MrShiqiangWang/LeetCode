package history.pkg201906;

import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetric {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(final int x) {
            this.val = x;
        }
    }

    public boolean isSymmetric(final TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Queue<TreeNode> toQueue = new LinkedList<>();
        while (!queue.isEmpty()) {
            final Object[] nodes = queue.toArray();
            for (int i = 0; i < nodes.length; i++) {
                final TreeNode node = (TreeNode) nodes[i];
                final TreeNode node2 = (TreeNode) nodes[nodes.length - i - 1];
                if (node == null && node2 == null) {
                    continue;
                }
                if (node == null || node2 == null) {
                    return false;
                }
                if (node.val != node2.val) {
                    return false;
                }
            }
            while (!queue.isEmpty()) {
                final TreeNode node = queue.poll();
                if (node != null) {
                    toQueue.add(node.left);
                    toQueue.add(node.right);
                }

            }
            final Queue<TreeNode> tmp = queue;
            queue = toQueue;
            toQueue = tmp;
        }
        return true;
    }
}
