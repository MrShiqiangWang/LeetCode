package pkg202007;

import utils.TreeNode;

public class O55_2 {

    public boolean isBalanced(final TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(this.maxDepth(root.left) - this.maxDepth(root.right)) > 1) {
            return false;
        }
        return this.isBalanced(root.left) && this.isBalanced(root.right);
    }

    public int maxDepth(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(this.maxDepth(root.left), this.maxDepth(root.right)) + 1;
    }
}
