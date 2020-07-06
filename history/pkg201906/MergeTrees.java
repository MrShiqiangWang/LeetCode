package history.pkg201906;

public class MergeTrees {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(final int x) {
            this.val = x;
        }
    }

    public TreeNode mergeTrees(final TreeNode t1, final TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val = t1.val + t2.val;
        t1.left = this.mergeTrees(t1.left, t2.left);
        t1.right = this.mergeTrees(t1.right, t2.right);
        return t1;
    }
}
