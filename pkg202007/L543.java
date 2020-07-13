package pkg202007;

import java.util.Stack;

import utils.TreeNode;

public class L543 {

    public int diameterOfBinaryTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int diameter = 0;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                diameter = Math.max(height(root.left) + height(root.right), diameter);
                root = root.left;
            }
            else {
                TreeNode node = stack.pop();
                root = node.right;
            }
        }
        return diameter;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
