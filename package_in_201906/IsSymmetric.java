package package_in_201906;

import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetric {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		Queue<TreeNode> toQueue = new LinkedList<>();
		while (!queue.isEmpty()) {
			Object[] nodes = queue.toArray();
			for (int i = 0; i < nodes.length; i++) {
				TreeNode node = (TreeNode) nodes[i];
				TreeNode node2 = (TreeNode) nodes[nodes.length - i - 1];
				if (node == null && node2 == null) {
					continue;
				}
				if (node == null || node2 == null) {
					return false;
				}
				if (node.val != node2.val) {
					return false;
				}
			}
			while (!queue.isEmpty()) {
				TreeNode node = queue.poll();
				if (node != null) {
					toQueue.add(node.left);
					toQueue.add(node.right);
				}

			}
			Queue<TreeNode> tmp = queue;
			queue = toQueue;
			toQueue = tmp;
		}
		return true;
	}
}
