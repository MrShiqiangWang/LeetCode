package pkg202007;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utils.TreeHelper;
import utils.TreeNode;

public class L107 {

    public static void main(String[] args) {
        new L107().levelOrderBottom(TreeHelper.stringToTree("[3,9,20,null,null,15,7]"));
    }

    private static class Node {

        int height;
        TreeNode node;

        public Node(int height, TreeNode node) {
            this.height = height;
            this.node = node;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Node node = new Node(0, root);
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        int curHeight = -1;
        List<Integer> items = null;
        while (!queue.isEmpty()) {
            Node node2 = queue.poll();
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
