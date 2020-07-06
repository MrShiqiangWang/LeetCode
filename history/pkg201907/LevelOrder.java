package history.pkg201907;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(final int x) {
            this.val = x;
        }
    }

    public List<List<Integer>> levelOrder(final TreeNode root) {
        final List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> from = new LinkedList<>();
        final List<Integer> list = new ArrayList<>();
        list.add(root.val);
        from.add(root);
        result.add(list);

        while (!from.isEmpty()) {
            final Queue<TreeNode> to = new LinkedList<>();
            final List<Integer> subList = new ArrayList<>();
            while (!from.isEmpty()) {
                final TreeNode node = from.poll();
                if (node.left != null) {
                    to.add(node.left);
                    subList.add(node.left.val);
                }
                if (node.right != null) {
                    to.add(node.right);
                    subList.add(node.right.val);
                }
            }
            from = to;
            result.add(subList);
        }

        return result;

    }
}
