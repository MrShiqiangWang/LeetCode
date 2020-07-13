package pkg202007;

import java.util.Stack;

import utils.TreeHelper;
import utils.TreeNode;

public class L530 {

    public static void main(final String[] args) {
        System.out.println(new L530().getMinimumDifference(TreeHelper.stringToTree("[1,null,3,null,null,2]")));
    }

    public int getMinimumDifference(final TreeNode root) {
        final Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        int min = Integer.MAX_VALUE;
        int pre = -1;
        while (curNode != null || !stack.isEmpty()) {
            if (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            else {
                final TreeNode node = stack.pop();
                if (pre == -1) {
                    pre = node.val;
                }
                else {
                    min = Math.min(node.val - pre, min);
                    pre = node.val;
                }
                curNode = node.right;
            }
        }
        return min;
    }
}
