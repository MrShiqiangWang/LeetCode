package package201907;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.xml.stream.events.EndDocument;

public class LevelOrder {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> from = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        from.add(root);
        result.add(list);

        while (!from.isEmpty()) {
            Queue<TreeNode> to = new LinkedList<>();
            List<Integer> subList = new ArrayList<>();
            while (!from.isEmpty()) {
                TreeNode node = from.poll();
                if (node.left != null) {
                    to.add(node.left);
                    subList.add(node.left.val);
                }
                if (node.right != null) {
                    to.add(node.right);
                    subList.add(node.right.val);
                }
            }
            from = to;
            result.add(subList);
        }

        return result;

    }
}
