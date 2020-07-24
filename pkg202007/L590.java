package pkg202007;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class L590 {
	public List<Integer> postorder(Node root) {
		Stack<Node> stack = new Stack<>();
		Node node = null;
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		stack.push(root);
		while (!stack.isEmpty()) {
			node = stack.pop();
			result.add(node.val);
			if (node.children != null) {
				for (int i = 0; i < node.children.size(); i--) {
					stack.push(node.children.get(i));
				}
			}
		}
		Collections.reverse(result);
		return result;
	}
}
