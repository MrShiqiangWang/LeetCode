package pkg202007;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import utils.TreeHelper;
import utils.TreeNode;

public class L437 {

    public static void main(final String[] args) {
        System.out.println(new L437().pathSum(TreeHelper.stringToTree("[10,5,-3,3,2,null,11,3,-2,null,1]"), 8));
    }

    public int pathSum(final TreeNode root, final int sum) {

        final Stack<TreeNode> stack = new Stack<>();

        int size = 0;
        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()) {
            if (curNode != null) {
                // 从当前节点开始计算pathsum
                size += this.pathSumRoot(curNode, sum);
                stack.push(curNode);
                curNode = curNode.left;
            }
            else {
                final TreeNode node = stack.pop();
                curNode = node.right;
            }
        }
        return size;
    }

    private int pathSumRoot(final TreeNode curNode, final int sum) {
        final HashMap<TreeNode, Integer> nodePathSum = new HashMap<>();
        final Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(curNode);
        int size = 0;
        nodePathSum.put(curNode, curNode.val);
        while (!queue.isEmpty()) {
            final TreeNode node = queue.poll();
            final int pathSum = nodePathSum.get(node);
            if (pathSum == sum) {
                size++;
            }
            if (node.left != null) {
                nodePathSum.put(node.left, pathSum + node.left.val);
                queue.add(node.left);
            }
            if (node.right != null) {
                nodePathSum.put(node.right, pathSum + node.right.val);
                queue.add(node.right);
            }
        }
        return size;
    }
}
