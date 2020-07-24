package pkg202007;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node {
	public int val;
	public List<Node> children;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
};

public class L589 {
	public List<Integer> preorder(Node root) {
		Stack<Node> stack = new Stack<>();
		Node node = null;
		List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
		stack.push(root);
		while (!stack.isEmpty()) {
			node = stack.pop();
			result.add(node.val);
			if (node.children != null) {
				for (int i = node.children.size() - 1; i >= 0; i--) {
					stack.push(node.children.get(i));
				}
			}
		}
		return result;
	}
}
