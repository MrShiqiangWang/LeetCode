package pkg202007;

public class L108 {

    @SuppressWarnings("unused")
    private class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(final int x) {
            this.val = x;
        }
    }

    public TreeNode sortedArrayToBST(final int[] nums) {
        return this.treeHelper(nums, 0, nums.length - 1);
    }

    private TreeNode treeHelper(final int[] nums, final int left, final int right) {
        if (left > right) {
            return null;
        }
        final int mid = (left + right) / 2;
        final TreeNode root = new TreeNode(nums[mid]);

        root.left = this.treeHelper(nums, left, mid - 1);
        root.right = this.treeHelper(nums, mid + 1, right);
        return root;
    }

}
