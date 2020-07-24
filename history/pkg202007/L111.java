package history.pkg202007;

import utils.TreeHelper;
import utils.TreeNode;

public class L111 {

    public static void main(final String[] args) {
        System.out.println(new L111().minDepth(TreeHelper.stringToTree("[1,2,3,4,5]")));
    }

    public int minDepth(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        else if (root.left == null) {
            return this.minDepth(root.right) + 1;
        }
        else if (root.right == null) {
            return this.minDepth(root.left) + 1;
        }
        else {
            return Math.min(this.minDepth(root.left), this.minDepth(root.right)) + 1;
        }
    }
}
