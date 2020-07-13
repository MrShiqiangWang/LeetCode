package pkg202007;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import utils.TreeHelper;
import utils.TreeNode;

public class L872 {

    public static void main(String[] args) {
        new L872().leafSimilar(TreeHelper.stringToTree("[1]"), TreeHelper.stringToTree("[2]"));
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> re1 = leafSequence(root1);
        List<Integer> re2 = leafSequence(root2);
        if (re1.size() != re2.size()) {
            return false;
        }
        for (int i = 0; i < re1.size(); i++) {
            if (re1.get(i) != re2.get(i)) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> leafSequence(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<Integer>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                if (root.left == null && root.right == null) {
                    result.add(root.val);
                }
                stack.push(root);
                root = root.left;
            }
            else {
                TreeNode node = stack.pop();
                root = node.right;
            }
        }
        return result;
    }
}
