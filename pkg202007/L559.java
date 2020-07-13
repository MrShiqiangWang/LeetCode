package pkg202007;

import java.util.ArrayList;
import java.util.List;

import utils.Node;

public class L559 {

    public static void main(String[] args) {
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        List<Node> nodes = new ArrayList<Node>();
        nodes.add(node5);
        nodes.add(node6);
        Node node3 = new Node(3, nodes);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        List<Node> sNodes = new ArrayList<>();
        sNodes.add(node3);
        sNodes.add(node2);
        sNodes.add(node4);
        Node node1 = new Node(1, sNodes);
        System.out.println(new L559().maxDepth(node1));
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        for (int i = 0; i < root.children.size(); i++) {
            depth = Math.max(maxDepth(root.children.get(i)), depth);
        }
        return depth + 1;
    }
}
