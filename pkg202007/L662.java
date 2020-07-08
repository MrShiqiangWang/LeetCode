package pkg202007;

import java.util.LinkedList;
import java.util.Queue;

import utils.TreeHelper;
import utils.TreeNode;

public class L662 {

    public static void main(final String[] args) {
        final TreeNode node = TreeHelper.stringToTree("[1,3,2,5,3,null,9]");
        System.out.println(new L662().widthOfBinaryTree(node));
    }

    public int widthOfBinaryTree(final TreeNode root) {

        Queue<TreeNode> fromQueue = new LinkedList<>();
        Queue<TreeNode> toQueue = new LinkedList<>();
        fromQueue.add(root);
        int max = 1;
        int first = -1;
        int second = -1;
        do {
            first = -1;
            second = -1;
            int i = -1;
            while (!fromQueue.isEmpty()) {
                final TreeNode node = fromQueue.poll();
                if (node == null) {
                    toQueue.add(null);
                    toQueue.add(null);
                    i = i + 2;
                }
                else {
                    toQueue.add(node.left);
                    i++;
                    if (node.left != null) {
                        if (first == -1) {
                            first = i;
                        }
                        second = i;
                    }

                    toQueue.add(node.right);
                    i++;
                    if (node.right != null) {
                        if (first == -1) {
                            first = i;
                        }
                        second = i;
                    }
                }
            }
            max = Math.max(second - first + 1, max);
            fromQueue = toQueue;
            toQueue = new LinkedList<>();
        }
        while (first != -1);
        return max;
    }

}
