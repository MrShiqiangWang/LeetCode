package pkg202007;

import utils.TreeHelper;
import utils.TreeNode;

public class L110 {

    public static void main(String[] args) {
        TreeNode node = TreeHelper.stringToTree("[3,9,20,null,null,15,7]");
        System.out.println(new L110().isBalanced(node));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return false;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (Math.abs(leftHeight - rightHeight) <= 1) {
            if (root.left == null && root.right == null) {
                return true;
            }
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        else if (root.left == null) {
            return 1 + height(root.right);
        }
        else if (root.right == null) {
            return 1 + height(root.left);
        }
        else {
            return 1 + Math.max(height(root.left), height(root.right));
        }
    }
}
