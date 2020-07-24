package history.pkg202007;

import java.util.LinkedList;
import java.util.Queue;

import utils.TreeNode;

public class L662_1 {

    private class TempNode {

        TreeNode node;
        int depth;
        int pos;

        TempNode(final TreeNode node, final int depth, final int pos) {
            this.node = node;
            this.depth = depth;
            this.pos = pos;
        }
    }

    public int widthOfBinaryTree(final TreeNode root) {
        final Queue<TempNode> queue = new LinkedList<TempNode>();
        queue.add(new TempNode(root, 0, 0));
        int curDepth = 0, left = 0, ans = 0;
        while (!queue.isEmpty()) {
            final TempNode tempNode = queue.poll();
            if (tempNode.node != null) {
                queue.add(new TempNode(tempNode.node.left, tempNode.depth + 1, tempNode.pos * 2 + 1));
                queue.add(new TempNode(tempNode.node.right, tempNode.depth + 1, tempNode.pos * 2 + 2));
                if (curDepth != tempNode.depth) {
                    curDepth = tempNode.depth;
                    left = tempNode.pos;
                }
                ans = Math.max(ans, tempNode.pos - left + 1);
            }
        }
        return ans;
    }

}
