package history.pkg202007;

import utils.ArrayHelper;
import utils.TreeNode;

public class M04_02 {

    public static void main(final String[] args) {
        System.out.println(new M04_02().sortedArrayToBST(ArrayHelper.stringToArray("[-10,-3,0,5,9]")));
    }

    public TreeNode sortedArrayToBST(final int[] nums) {
        return this.sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(final int[] nums, final int left, final int right) {
        if (right < left) {
            return null;
        }
        final int mid = (left + right) / 2;
        final TreeNode node = new TreeNode(nums[mid]);
        node.left = this.sortedArrayToBST(nums, left, mid - 1);
        node.right = this.sortedArrayToBST(nums, mid + 1, right);
        return node;
    }
}
