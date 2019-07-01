package package_in_201906;

import java.util.Stack;

public class RangeSumBST {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int rangeSumBST(TreeNode root, int L, int R) {

		Stack<TreeNode> stacks = new Stack<RangeSumBST.TreeNode>();
		TreeNode node = root;
		int sum = 0;
		while (!stacks.isEmpty() || node != null) {
			if (node != null) {
				if (node.val >= L && node.val <= R) {
					sum += node.val;
				}
				stacks.push(node);
				node = node.left;
			} else {
				TreeNode treeNode = stacks.pop();
				node = treeNode.right;
			}
		}
		return sum;
	}

	public int rangeSumBSTR(TreeNode root, int L, int R) {
		if (root == null) {
			return 0;
		}
		int val = 0;
		if (root.val >= L && root.val <= R) {
			val = root.val;
		}
		return val + rangeSumBSTR(root.left, L, R) + rangeSumBSTR(root.right, L, R);
	}

}
