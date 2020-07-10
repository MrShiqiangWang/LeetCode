package pkg202007;

import utils.TreeNode;

public class L100 {

    public boolean isSameTree(final TreeNode p, final TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        else if (p == null) {
            return false;
        }
        else if (q == null) {
            return false;
        }
        else {
            if (p.val != q.val) {
                return false;
            }
            else {
                return this.isSameTree(p.left, q.left) && this.isSameTree(p.right, q.right);
            }
        }
    }
}
