package history.pkg201906;

import java.util.Stack;

public class RangeSumBST {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(final int x) {
            this.val = x;
        }
    }

    public int rangeSumBST(final TreeNode root, final int L, final int R) {

        final Stack<TreeNode> stacks = new Stack<RangeSumBST.TreeNode>();
        TreeNode node = root;
        int sum = 0;
        while (!stacks.isEmpty() || node != null) {
            if (node != null) {
                if (node.val >= L && node.val <= R) {
                    sum += node.val;
                }
                stacks.push(node);
                node = node.left;
            }
            else {
                final TreeNode treeNode = stacks.pop();
                node = treeNode.right;
            }
        }
        return sum;
    }

    public int rangeSumBSTR(final TreeNode root, final int L, final int R) {
        if (root == null) {
            return 0;
        }
        int val = 0;
        if (root.val >= L && root.val <= R) {
            val = root.val;
        }
        return val + this.rangeSumBSTR(root.left, L, R) + this.rangeSumBSTR(root.right, L, R);
    }

}
