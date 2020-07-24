package history.pkg202007;

import utils.ArrayHelper;

public class L414 {

    public static void main(final String[] args) {
        System.out.println(new L414().thirdMax(ArrayHelper.stringToArray("[1,2,2]")));
    }

    public int thirdMax(final int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        Integer first = nums[0], second = null, third = null;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > first) {
                third = second;
                second = first;
                first = nums[i];
            }
            else if (nums[i] == first) {
                continue;
            }
            else if (second == null) {
                second = nums[i];
            }
            else if (nums[i] > second) {
                third = second;
                second = nums[i];
            }
            else if (nums[i] == second) {
                continue;
            }
            else if (third == null || nums[i] > third) {
                third = nums[i];
            }
        }
        return third == null ? first : third;
    }
}
