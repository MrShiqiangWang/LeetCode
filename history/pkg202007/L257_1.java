package history.pkg202007;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utils.TreeNode;

public class L257_1 {

    public List<String> binaryTreePaths(final TreeNode root) {
        final List<String> paths = new ArrayList<String>();
        if (root == null) {
            return paths;
        }
        final HashMap<TreeNode, String> pathMap = new HashMap<>();
        final Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        pathMap.put(root, "" + root.val);
        while (!queue.isEmpty()) {
            final TreeNode node = queue.poll();
            final String path = pathMap.get(node);
            if (node.left == null && node.right == null) {
                paths.add(path);
            }
            else if (node.left == null) {
                pathMap.put(node.right, path + "->" + node.right.val);
                queue.add(node.right);
            }
            else if (node.right == null) {
                pathMap.put(node.left, path + "->" + node.left.val);
                queue.add(node.left);
            }
            else {
                pathMap.put(node.left, path + "->" + node.left.val);
                queue.add(node.left);
                pathMap.put(node.right, path + "->" + node.right.val);
                queue.add(node.right);
            }
        }
        return paths;
    }
}
