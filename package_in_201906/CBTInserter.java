package package_in_201906;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CBTInserter {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<TreeNode> list = new ArrayList<>();
    private TreeNode root = null;

    public CBTInserter(TreeNode root) {
        this.root = root;
        if (root == null) {
            return;
        }
        TreeNode node = root;

        Queue<TreeNode> tempQueue = new LinkedList<>();
        tempQueue.add(node);
        while (!tempQueue.isEmpty()) {
            TreeNode myNode = tempQueue.poll();
            if (myNode != null) {
                list.add(myNode);
            }
            if (myNode.left != null) {
                tempQueue.add(myNode.left);
            }
            if (myNode.right != null) {
                tempQueue.add(myNode.right);
            }
        }
    }

    public int insert(int v) {
        TreeNode treeNode = new TreeNode(v);
        list.add(treeNode);
        int size = list.size();
        if (size == 1) {
            this.root = treeNode;
            return this.root.val;
        }
        if (size % 2 == 0) {
            list.get(size / 2).left = treeNode;
        }
        else {
            list.get(size / 2).right = treeNode;
        }
        return list.get(0).val;
    }

    public TreeNode get_root() {
        return this.root;
    }
}
