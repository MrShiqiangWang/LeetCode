package pkg202007;

import utils.TreeHelper;
import utils.TreeNode;

public class L110 {

    public static void main(final String[] args) {
        final TreeNode node = TreeHelper.stringToTree("[3,9,20,null,null,15,7]");
        System.out.println(new L110().isBalanced(node));
    }

    private int height(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        else if (root.left == null) {
            return 1 + this.height(root.right);
        }
        else if (root.right == null) {
            return 1 + this.height(root.left);
        }
        else {
            return 1 + Math.max(this.height(root.left), this.height(root.right));
        }
    }

    public boolean isBalanced(final TreeNode root) {
        if (root == null) {
            return false;
        }
        final int leftHeight = this.height(root.left);
        final int rightHeight = this.height(root.right);
        if (Math.abs(leftHeight - rightHeight) <= 1) {
            if (root.left == null && root.right == null) {
                return true;
            }
            return this.isBalanced(root.left) && this.isBalanced(root.right);
        }
        return false;
    }
}
