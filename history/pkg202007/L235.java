package history.pkg202007;

import java.util.ArrayList;
import java.util.List;

import utils.TreeHelper;
import utils.TreeNode;

public class L235 {

    public static void main(final String[] args) {
        System.out.println(new L235().lowestCommonAncestor(TreeHelper.stringToTree("[6,2,8,0,4,7,9,null,null,3,5]"), new TreeNode(2), new TreeNode(4)));
    }

    public TreeNode lowestCommonAncestor(final TreeNode root, final TreeNode p, final TreeNode q) {

        final List<TreeNode> pAncestors = this.getAncestors(root, p);
        final List<TreeNode> qAncestors = this.getAncestors(root, q);
        TreeNode commNode = null;
        for (int i = 0, j = 0; i < pAncestors.size() && j < qAncestors.size(); i++, j++) {
            if (pAncestors.get(i).val == qAncestors.get(i).val) {
                commNode = pAncestors.get(i);
            }
            else {
                break;
            }
        }

        return commNode;
    }

    private List<TreeNode> getAncestors(final TreeNode root, final TreeNode p) {
        final List<TreeNode> nodes = new ArrayList<TreeNode>();
        TreeNode currentNode = root;
        while (currentNode != null) {
            nodes.add(currentNode);
            if (currentNode.val == p.val) {
                return nodes;
            }
            else if (currentNode.val < p.val) {
                currentNode = currentNode.right;
            }
            else {
                currentNode = currentNode.left;
            }
        }
        return new ArrayList<>();
    }
}
