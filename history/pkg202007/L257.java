package history.pkg202007;

import java.util.ArrayList;
import java.util.List;

import utils.TreeHelper;
import utils.TreeNode;

public class L257 {

    public static void main(final String[] args) {
        System.out.println(new L257().binaryTreePaths(TreeHelper.stringToTree("[1,2,3,null,5]")));
    }

    public List<String> binaryTreePaths(final TreeNode root) {
        return this.binaryTreePaths(root, "");
    }

    private List<String> binaryTreePaths(final TreeNode root, String path) {
        if (root == null) {
            return new ArrayList<>();
        }
        if (path.equals("")) {
            path += root.val;
        }
        else {
            path += ("->" + root.val);
        }
        final List<String> result = new ArrayList<>();
        if (root.left == null && root.right == null) {
            result.add(path);
        }
        else if (root.left == null) {
            result.addAll(this.binaryTreePaths(root.right, path));
        }
        else if (root.right == null) {
            result.addAll(this.binaryTreePaths(root.left, path));
        }
        else {
            result.addAll(this.binaryTreePaths(root.left, path));
            result.addAll(this.binaryTreePaths(root.right, path));
        }
        return result;
    }
}
