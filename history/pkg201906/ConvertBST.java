package history.pkg201906;

import java.util.Stack;

public class ConvertBST {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(final int x) {
            this.val = x;
        }
    }

    public TreeNode convertBST(final TreeNode root) {
        final Stack<TreeNode> stack = new Stack<>();
        int size = 0;
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.right;
            }
            else {
                final TreeNode node2 = stack.pop();
                size = size + node2.val;
                node2.val = size;
                node = node2.left;
            }
        }
        return root;
    }

}
