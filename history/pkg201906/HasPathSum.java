package history.pkg201906;

public class HasPathSum {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(final int x) {
            this.val = x;
        }
    }

    public boolean hasPathSum(final TreeNode root, final int sum) {
        int s = 0;
        if (root == null) {
            return false;
        }
        s = root.val;
        return this.hasPathSum(root, sum, s);
    }

    private boolean hasPathSum(final TreeNode root, final int sum, final int s) {
        if (root.left == null && root.right == null) {
            if (s == sum) {
                return true;
            }
            else {
                return false;
            }
        }
        if (root.left != null) {
            final int sleft = root.left.val + s;
            if (this.hasPathSum(root.left, sum, sleft)) {
                return true;
            }
        }
        if (root.right != null) {
            final int sright = root.right.val + s;
            if (this.hasPathSum(root.right, sum, sright)) {
                return true;
            }
        }
        return false;
    }
}
