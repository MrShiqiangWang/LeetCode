package history.pkg201906;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CBTInserter {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(final int x) {
            this.val = x;
        }
    }

    List<TreeNode> list = new ArrayList<>();
    private TreeNode root = null;

    public CBTInserter(final TreeNode root) {
        this.root = root;
        if (root == null) {
            return;
        }
        final TreeNode node = root;

        final Queue<TreeNode> tempQueue = new LinkedList<>();
        tempQueue.add(node);
        while (!tempQueue.isEmpty()) {
            final TreeNode myNode = tempQueue.poll();
            if (myNode != null) {
                this.list.add(myNode);
            }
            if (myNode.left != null) {
                tempQueue.add(myNode.left);
            }
            if (myNode.right != null) {
                tempQueue.add(myNode.right);
            }
        }
    }

    public TreeNode get_root() {
        return this.root;
    }

    public int insert(final int v) {
        final TreeNode treeNode = new TreeNode(v);
        this.list.add(treeNode);
        final int size = this.list.size();
        if (size == 1) {
            this.root = treeNode;
            return this.root.val;
        }
        if (size % 2 == 0) {
            this.list.get(size / 2).left = treeNode;
        }
        else {
            this.list.get(size / 2).right = treeNode;
        }
        return this.list.get(0).val;
    }
}
