package history.pkg202007;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utils.TreeHelper;
import utils.TreeNode;

public class L107 {

    private static class Node {

        int height;
        TreeNode node;

        public Node(final int height, final TreeNode node) {
            this.height = height;
            this.node = node;
        }
    }

    public static void main(final String[] args) {
        new L107().levelOrderBottom(TreeHelper.stringToTree("[3,9,20,null,null,15,7]"));
    }

    public List<List<Integer>> levelOrderBottom(final TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        final List<List<Integer>> result = new ArrayList<>();
        final Node node = new Node(0, root);
        final Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        int curHeight = -1;
        List<Integer> items = null;
        while (!queue.isEmpty()) {
            final Node node2 = queue.poll();
            if (node2.height != curHeight) {
                curHeight = node2.height;
                items = new ArrayList<>();
                result.add(items);
            }
            items.add(node2.node.val);
            if (node2.node.left != null) {
                queue.add(new Node(node2.height + 1, node2.node.left));
            }
            if (node2.node.right != null) {
                queue.add(new Node(node2.height + 1, node2.node.right));
            }
        }
        Collections.reverse(result);
        return result;
    }
}
