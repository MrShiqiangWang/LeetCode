package package_in_201907;

import java.util.ArrayList;
import java.util.List;

public class FindTilt {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class NodeInf {
		// ºÍ
		int sum;
		// ÆÂ¶È
		int tilt;
	}

	public int findTilt(TreeNode root) {
		List<NodeInf> result = new ArrayList<>();
		findTiltMy(root, result);
		int sum = 0;
		for (NodeInf nodeInf2 : result) {
			sum += nodeInf2.tilt;
		}
		return sum;
	}

	private NodeInf findTiltMy(TreeNode root, List<NodeInf> result) {
		NodeInf nodeInf = new NodeInf();
		if (root == null) {
			nodeInf.sum = 0;
			nodeInf.tilt = 0;
			result.add(nodeInf);
			return nodeInf;
		}
		NodeInf leftInf = findTiltMy(root.left, result);
		NodeInf rightInf = findTiltMy(root.right, result);
		nodeInf.sum = leftInf.sum + rightInf.sum + root.val;
		nodeInf.tilt = Math.abs(leftInf.sum - rightInf.sum);
		result.add(nodeInf);
		return nodeInf;
	}
}
