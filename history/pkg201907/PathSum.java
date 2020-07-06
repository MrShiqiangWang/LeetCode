package history.pkg201907;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class PathSum {

    class TmpResult {

        int val;
        List<Integer> list;
    }

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(final int x) {
            this.val = x;
        }
    }

    public List<List<Integer>> pathSum(final TreeNode root, final int sum) {

        final Stack<TreeNode> stack = new Stack<>();
        final List<List<Integer>> result = new ArrayList<>();

        final Map<TreeNode, TmpResult> map = new HashMap<>();

        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                TmpResult tmpResult = null;
                if (map.containsKey(node)) {
                    tmpResult = map.get(node);
                }
                else {
                    tmpResult = new TmpResult();
                    tmpResult.val = node.val;
                    final List<Integer> tmp = new ArrayList<>();
                    tmp.add(node.val);
                    tmpResult.list = tmp;
                    map.put(node, tmpResult);
                }
                if (node.left == null && node.right == null) {
                    // ˵����Ҷ�ӽڵ�
                    final TmpResult tmpResult2 = map.get(node);
                    if (tmpResult2.val == sum) {
                        result.add(tmpResult2.list);
                    }
                }
                if (node.left != null) {
                    if (!map.containsKey(node.left)) {
                        final TmpResult tmpResult2 = new TmpResult();
                        tmpResult2.val = tmpResult.val + node.left.val;
                        final List<Integer> list = new ArrayList<>();
                        for (int i = 0; i < tmpResult.list.size(); i++) {
                            list.add(tmpResult.list.get(i));
                        }
                        list.add(node.left.val);
                        tmpResult2.list = list;
                        map.put(node.left, tmpResult2);
                    }
                }
                node = node.left;
            }
            else {
                final TreeNode node2 = stack.pop();
                final TmpResult tmpResult = map.get(node2);

                if (node2.right != null) {
                    if (!map.containsKey(node2.right)) {
                        final TmpResult tmpResult2 = new TmpResult();
                        tmpResult2.val = tmpResult.val + node2.right.val;
                        final List<Integer> list = new ArrayList<>();
                        Collections.copy(list, tmpResult.list);
                        list.add(node2.right.val);
                        tmpResult2.list = list;
                        map.put(node2.right, tmpResult2);
                    }
                }
                node = node2.right;
            }
        }
        return result;
    }
}
