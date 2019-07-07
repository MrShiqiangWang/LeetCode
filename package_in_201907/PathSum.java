package package_in_201907;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class PathSum {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class TmpResult {
		int val;
		List<Integer> list;
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {

		Stack<TreeNode> stack = new Stack<>();
		List<List<Integer>> result = new ArrayList<>();

		Map<TreeNode, TmpResult> map = new HashMap<>();

		TreeNode node = root;
		while (!stack.isEmpty() || node != null) {
			if (node != null) {
				stack.push(node);
				TmpResult tmpResult = null;
				if (map.containsKey(node)) {
					tmpResult = map.get(node);
				} else {
					tmpResult = new TmpResult();
					tmpResult.val = node.val;
					List<Integer> tmp = new ArrayList<>();
					tmp.add(node.val);
					tmpResult.list = tmp;
					map.put(node, tmpResult);
				}
				int mySum = 0;
				if (node.left == null && node.right == null) {
					// 说明是叶子节点
					TmpResult tmpResult2 = map.get(node);
					if (tmpResult2.val == sum) {
						result.add(tmpResult2.list);
					}
				}
				if(node.left!=null) {
					if(!map.containsKey(node.left)) {
						TmpResult tmpResult2=new TmpResult();
						tmpResult2.val=tmpResult.val+node.left.val;
						List<Integer>list=new ArrayList<>();
						for(int i=0;i<tmpResult.list.size();i++) {
							list.add(tmpResult.list.get(i));
						}
						list.add(node.left.val);
						tmpResult2.list=list;
						map.put(node.left, tmpResult2);
					}
				}
				node = node.left;
			} else {
				TreeNode node2 = stack.pop();
				TmpResult tmpResult = map.get(node2);

				if(node2.right!=null) {
					if(!map.containsKey(node2.right)) {
						TmpResult tmpResult2=new TmpResult();
						tmpResult2.val=tmpResult.val+node2.right.val;
						List<Integer>list=new ArrayList<>();
						Collections.copy(list, tmpResult.list);
						list.add(node2.right.val);
						tmpResult2.list=list;
						map.put(node2.right, tmpResult2);
					}
				}
				node = node2.right;
			}
		}
		return result;
	}
}
