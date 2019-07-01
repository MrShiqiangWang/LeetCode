package package_in_201906;

import java.util.Arrays;

public class ConstructMaximumBinaryTree {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int index = findMax(nums);
        TreeNode treeNode = new TreeNode(nums[index]);
        if (index != 0) {
            int[] subLeft = Arrays.copyOfRange(nums, 0, index);
            treeNode.left = constructMaximumBinaryTree(subLeft);
        }
        if (index != nums.length - 1) {
            int[] subRight = Arrays.copyOfRange(nums, index + 1, nums.length);
            treeNode.right = constructMaximumBinaryTree(subRight);
        }
        return treeNode;
    }

    private int findMax(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        int[] A = { 3, 2, 1, 6, 0, 5 };
        System.out.println(new ConstructMaximumBinaryTree().constructMaximumBinaryTree(A));
    }
}
