package history.pkg202007;

import java.util.Stack;

import utils.TreeNode;

public class L543 {

    public int diameterOfBinaryTree(TreeNode root) {
        final Stack<TreeNode> stack = new Stack<>();
        int diameter = 0;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                diameter = Math.max(this.height(root.left) + this.height(root.right), diameter);
                root = root.left;
            }
            else {
                final TreeNode node = stack.pop();
                root = node.right;
            }
        }
        return diameter;
    }

    private int height(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(this.height(root.left), this.height(root.right)) + 1;
    }
}
