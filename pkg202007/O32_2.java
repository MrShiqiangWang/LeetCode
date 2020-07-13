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

        public Node(int height, TreeNode node) {
            this.height = height;
            this.treeNode = node;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(1, root));
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int curHeight = -1;
        List<Integer> item = null;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.height != curHeight) {
                item = new ArrayList<>();
                curHeight=node.height;
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
