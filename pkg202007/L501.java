package pkg202007;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import utils.TreeNode;

public class L501 {

    public int[] findMode(TreeNode root) {
        final Map<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
        final Stack<TreeNode> stack = new Stack<>();
        int max = 0;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                final int value = sumMap.getOrDefault(root.val, 0) + 1;
                max = Math.max(value, max);
                sumMap.put(root.val, value);
                stack.push(root);
                root = root.left;
            }
            else {
                final TreeNode node = stack.pop();
                root = node.right;
            }
        }

        final List<Integer> result = new ArrayList<Integer>();
        for (final Map.Entry<Integer, Integer> entry : sumMap.entrySet()) {
            if (entry.getValue() == max) {
                result.add(entry.getKey());
            }
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();

    }
}
