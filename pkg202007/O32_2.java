package pkg202007;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utils.TreeNode;

public class O32_2 {

    private class Node {

        int height;
        TreeNode treeNode;

        public Node(final int height, final TreeNode node) {
            this.height = height;
            this.treeNode = node;
        }
    }

    public List<List<Integer>> levelOrder(final TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        final Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(1, root));
        final List<List<Integer>> result = new ArrayList<List<Integer>>();
        int curHeight = -1;
        List<Integer> item = null;
        while (!queue.isEmpty()) {
            final Node node = queue.poll();
            if (node.height != curHeight) {
                item = new ArrayList<>();
                curHeight = node.height;
                result.add(item);
            }
            item.add(node.treeNode.val);
            if (node.treeNode.left != null) {
                queue.add(new Node(node.height + 1, node.treeNode.left));
            }
            if (node.treeNode.right != null) {
                queue.add(new Node(node.height + 1, node.treeNode.right));
            }
        }
        return result;
    }
}
