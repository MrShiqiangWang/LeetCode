package history.pkg201906;

import java.util.Arrays;

public class ConstructMaximumBinaryTree {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(final int x) {
            this.val = x;
        }
    }

    public static void main(final String[] args) {
        final int[] A = { 3, 2, 1, 6, 0, 5 };
        System.out.println(new ConstructMaximumBinaryTree().constructMaximumBinaryTree(A));
    }

    public TreeNode constructMaximumBinaryTree(final int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        final int index = this.findMax(nums);
        final TreeNode treeNode = new TreeNode(nums[index]);
        if (index != 0) {
            final int[] subLeft = Arrays.copyOfRange(nums, 0, index);
            treeNode.left = this.constructMaximumBinaryTree(subLeft);
        }
        if (index != nums.length - 1) {
            final int[] subRight = Arrays.copyOfRange(nums, index + 1, nums.length);
            treeNode.right = this.constructMaximumBinaryTree(subRight);
        }
        return treeNode;
    }

    private int findMax(final int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
