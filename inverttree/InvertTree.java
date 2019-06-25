package inverttree;

import java.util.Stack;

public class InvertTree {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public TreeNode invertTree1(TreeNode root) {
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || stack.size() != 0) {
            if (node != null) {
                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
                stack.push(node);
                node = node.left;
            }
            else {
                TreeNode node2 = stack.pop();
                node = node2.right;
            }
        }
        return root;
    }
}
