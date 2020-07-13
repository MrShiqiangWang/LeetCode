package pkg202007;

import utils.ArrayHelper;
import utils.TreeNode;

public class M04_02 {

    public static void main(String[] args) {
        System.out.println(new M04_02().sortedArrayToBST(ArrayHelper.stringToArray("[-10,-3,0,5,9]")));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (right < left) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, left, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, right);
        return node;
    }
}
