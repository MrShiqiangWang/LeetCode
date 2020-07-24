package history.pkg202007;

import utils.TreeNode;

public class L700 {

    public TreeNode searchBST(TreeNode root, final int val) {
        while (root != null) {
            if (val == root.val) {
                return root;
            }
            else if (val < root.val) {
                root = root.left;
            }
            else {
                root = root.right;
            }
        }
        return null;
    }
}
