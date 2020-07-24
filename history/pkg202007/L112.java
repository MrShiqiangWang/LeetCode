package history.pkg202007;

import utils.TreeHelper;
import utils.TreeNode;

public class L112 {

    public static void main(final String[] args) {
        final TreeNode root = TreeHelper.stringToTree("[5,4,8,11,null,13,4,7,2,null,null,null,1]");
        System.out.println(new L112().hasPathSum(root, 22));
    }

    public boolean hasPathSum(final TreeNode root, final int sum) {
        return this.hasPathSum(root, sum, 0);
    }

    private boolean hasPathSum(final TreeNode root, final int sum, int pathSum) {
        if (root == null) {
            return false;
        }
        pathSum = pathSum + root.val;
        if (root.left == null && root.right == null) {
            if (pathSum == sum) {
                return true;
            }
            return false;
        }
        if (this.hasPathSum(root.left, sum, pathSum)) {
            return true;
        }
        return this.hasPathSum(root.right, sum, pathSum);
    }
}
