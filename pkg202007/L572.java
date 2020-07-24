package pkg202007;

import utils.TreeNode;

public class L572 {
	public boolean isSubtree(TreeNode s, TreeNode t) {
		return isSubTree1(s, t);
	}

	private boolean isSubTree1(TreeNode s, TreeNode t) {
		if (isSameTree(s, t)) {
			return true;
		}
		if (s != null && isSubTree1(s.left, t)) {
			return true;
		}
		if (s != null && isSubTree1(s.right, t)) {
			return true;
		}
		return false;
	}

	private boolean isSameTree(TreeNode s, TreeNode t) {
		if (s == null && t == null) {
			return true;
		}
		if (s == null) {
			return false;
		}
		if (t == null) {
			return false;
		}
		if (s.val == t.val) {
			return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
		}
		return false;
	}
}
