package history.pkg202007;

import utils.ArrayHelper;

public class L747 {

    public static void main(final String[] args) {
        System.out.println(new L747().dominantIndex(ArrayHelper.stringToArray("[0,0,3,2]")));
    }

    public int dominantIndex(final int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        // 遍历数组，找出最大元素和第二大元�?
        int maxIndex = -1;
        int secondMaxIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (maxIndex == -1 || nums[i] > nums[maxIndex]) {
                if (maxIndex != -1 && nums[i] > nums[maxIndex]) {
                    secondMaxIndex = maxIndex;
                }
                maxIndex = i;
            }
            else if (nums[i] == nums[maxIndex] || secondMaxIndex == -1 || nums[i] > nums[secondMaxIndex]) {
                secondMaxIndex = i;
            }
        }
        if (maxIndex == -1) {
            return -1;
        }
        if (secondMaxIndex == -1) {
            return 0;
        }
        if (nums[maxIndex] >= nums[secondMaxIndex] * 2) {
            return maxIndex;
        }
        return -1;
    }
}
