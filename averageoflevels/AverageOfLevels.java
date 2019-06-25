package averageoflevels;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Double> averageOfLevels(TreeNode root) {
		Queue<TreeNode> from = new LinkedList<AverageOfLevels.TreeNode>();
		Queue<TreeNode> to = new LinkedList<AverageOfLevels.TreeNode>();
		from.add(root);
		List<Double> result = new ArrayList<Double>();
		while (true) {
			// 计算from 队列里面的数据的均值
			result.add(averageOfNodes(from));
			while (from.size() != 0) {
				TreeNode node = from.poll();
				if (node.left != null) {
					to.add(node);
				}
				if(node.right!=null) {
					to.add(node);
				}
			}
			if(to.size()==0) {
				break;
			}
			Queue<TreeNode> tmp = from;
			from = to;
			to = tmp;
		}
		return result;

	}

	private Double averageOfNodes(Queue<TreeNode> from) {
		Double sum = 0.0;
		for (TreeNode node : from) {
			sum += node.val;
		}
		return sum / from.size();
	}
}
