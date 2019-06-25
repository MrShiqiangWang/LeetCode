package convertbst;

import java.util.Stack;

public class ConvertBST {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode convertBST(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		int size = 0;
		TreeNode node = root;
		while (!stack.isEmpty() || node != null) {
			if (node != null) {
				stack.push(node);
				node = node.right;
			} else {
				TreeNode node2 = stack.pop();
				size = size + node2.val;
				node2.val = size;
				node = node2.left;
			}
		}
		return root;
	}

}
