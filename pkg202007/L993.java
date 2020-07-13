package pkg202007;

import java.util.LinkedList;
import java.util.Queue;

import javafx.util.Pair;
import utils.TreeNode;

public class L993 {

    private class Node {

        int height;
        TreeNode node;
        TreeNode parentNode;

        public Node(int height, TreeNode node,TreeNode parentNode) {
            this.height = height;
            this.node = node;
            this.parentNode=parentNode;
        }
    }

        public boolean isCousins(TreeNode root, int x, int y) {
            // 父节点不相同
            // 高度相同
            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(1, root, null));

            Node nodex;
            Node nodey;
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                if (node.node.val == x) {
                    nodex = node;
                }
                if (node.node.val == y) {
                    nodey = node;
                }
                if (node.node.left != null) {
                    queue.add(new Node(1 + node.height, node.node.left, node.node));
                }
                if (node.node.right != null) {
                    queue.add(new Node(1 + node.height, node.node.right, node.node));
                }
            }
            return false;

        }
}
