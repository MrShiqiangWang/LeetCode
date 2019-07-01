package package_in_201906;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Queue<TreeNode> targets = new LinkedList<>();
            while (!nodes.isEmpty()) {
                TreeNode node = nodes.poll();
                if (nodes.isEmpty()) {
                    result.add(node.val);
                }
                if (node.left != null) {
                    targets.add(node.left);
                }
                if (node.right != null) {
                    targets.add(node.right);
                }
            }
            nodes = targets;
        }
        return result;
    }
}
