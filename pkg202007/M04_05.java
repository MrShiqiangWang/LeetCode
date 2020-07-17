package pkg202007;

import utils.TreeNode;

public class M04_05 {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer minValue, Integer maxValue) {
        if (root == null) {
            return true;
        }
        if (minValue != null && root.val <= minValue) {
            return false;
        }
        if (maxValue != null && root.val > maxValue) {
            return false;
        }
        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
    }
}
