package pkg202007;

import utils.TreeNode;

public class L104 {

    public int maxDepth(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(this.maxDepth(root.left), this.maxDepth(root.right)) + 1;
    }
}
