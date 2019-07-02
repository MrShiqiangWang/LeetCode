package haspathsum;

public class HasPathSum {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		int s = 0;
		if (root == null) {
			return false;
		}
		s = root.val;
		return hasPathSum(root, sum, s);
	}

	private boolean hasPathSum(TreeNode root, int sum, int s) {
		if (root.left == null && root.right == null) {
			if (s == sum) {
				return true;
			} else {
				return false;
			}
		}
		if (root.left != null) {
			int sleft = root.left.val + s;
			if (hasPathSum(root.left, sum, sleft)) {
				return true;
			}
		}
		if (root.right != null) {
			int sright = root.right.val + s;
			if (hasPathSum(root.right, sum, sright)) {
				return true;
			}
		}
		return false;
	}
}
