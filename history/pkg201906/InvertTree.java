package history.pkg201906;

import java.util.Stack;

public class InvertTree {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(final int x) {
            this.val = x;
        }
    }

    public TreeNode invertTree(final TreeNode root) {
        if (root == null) {
            return null;
        }
        final TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        this.invertTree(root.left);
        this.invertTree(root.right);
        return root;
    }

    public TreeNode invertTree1(final TreeNode root) {
        TreeNode node = root;
        final Stack<TreeNode> stack = new Stack<>();
        while (node != null || stack.size() != 0) {
            if (node != null) {
                final TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
                stack.push(node);
                node = node.left;
            }
            else {
                final TreeNode node2 = stack.pop();
                node = node2.right;
            }
        }
        return root;
    }
}
