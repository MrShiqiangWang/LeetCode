package history.pkg201907;

import java.util.ArrayList;
import java.util.List;

public class FindTilt {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(final int x) {
            this.val = x;
        }
    }

    class NodeInf {

        // ��
        int sum;
        // �¶�
        int tilt;
    }

    public int findTilt(final TreeNode root) {
        final List<NodeInf> result = new ArrayList<>();
        this.findTiltMy(root, result);
        int sum = 0;
        for (final NodeInf nodeInf2 : result) {
            sum += nodeInf2.tilt;
        }
        return sum;
    }

    private NodeInf findTiltMy(final TreeNode root, final List<NodeInf> result) {
        final NodeInf nodeInf = new NodeInf();
        if (root == null) {
            nodeInf.sum = 0;
            nodeInf.tilt = 0;
            result.add(nodeInf);
            return nodeInf;
        }
        final NodeInf leftInf = this.findTiltMy(root.left, result);
        final NodeInf rightInf = this.findTiltMy(root.right, result);
        nodeInf.sum = leftInf.sum + rightInf.sum + root.val;
        nodeInf.tilt = Math.abs(leftInf.sum - rightInf.sum);
        result.add(nodeInf);
        return nodeInf;
    }
}
