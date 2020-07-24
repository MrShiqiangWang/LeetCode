package history.pkg202007;

import java.util.Stack;

import utils.TreeNode;

public class L783 {

    public int minDiffInBST(TreeNode root) {
        int min = Integer.MAX_VALUE;
        Integer preNodeVal = null;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            }
            else {
                TreeNode tmp = stack.pop();
                if (preNodeVal == null) {
                    preNodeVal = tmp.val;
                }
                else {
                    min = Math.min(min, tmp.val - preNodeVal);
                    preNodeVal = tmp.val;
                }
                root = tmp.right;
            }
        }
        return min;
    }
}
