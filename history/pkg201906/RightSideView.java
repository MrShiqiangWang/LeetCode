package history.pkg201906;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(final int x) {
            this.val = x;
        }
    }

    public List<Integer> rightSideView(final TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        final List<Integer> result = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            final Queue<TreeNode> targets = new LinkedList<>();
            while (!nodes.isEmpty()) {
                final TreeNode node = nodes.poll();
                if (nodes.isEmpty()) {
                    result.add(node.val);
                }
                if (node.left != null) {
                    targets.add(node.left);
                }
                if (node.right != null) {
                    targets.add(node.right);
                }
            }
            nodes = targets;
        }
        return result;
    }
}
