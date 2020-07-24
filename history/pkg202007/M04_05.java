package history.pkg202007;

import utils.TreeNode;

public class M04_05 {

    public boolean isValidBST(final TreeNode root) {
        return this.isValidBST(root, null, null);
    }

    private boolean isValidBST(final TreeNode root, final Integer minValue, final Integer maxValue) {
        if (root == null) {
            return true;
        }
        if (minValue != null && root.val <= minValue) {
            return false;
        }
        if (maxValue != null && root.val > maxValue) {
            return false;
        }
        return this.isValidBST(root.left, minValue, root.val) && this.isValidBST(root.right, root.val, maxValue);
    }
}
