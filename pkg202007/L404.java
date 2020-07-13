package pkg202007;

import java.util.Stack;

import utils.TreeHelper;
import utils.TreeNode;

public class L404 {

    public static void main(final String[] args) {
        System.out.println(new L404().sumOfLeftLeaves(TreeHelper.stringToTree("[3,9,20,null,null,15,7]")));
    }

    public int sumOfLeftLeaves(final TreeNode root) {
        final Stack<TreeNode> stack = new Stack<>();
        int sum = 0;
        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()) {
            if (curNode != null) {
                stack.add(curNode);
                curNode = curNode.left;
                if (curNode != null && curNode.left == null && curNode.right == null) {
                    sum += curNode.val;
                }
            }
            else {
                final TreeNode node = stack.pop();
                curNode = node.right;
            }
        }
        return sum;
    }
}
