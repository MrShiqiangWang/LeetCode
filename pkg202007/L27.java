package pkg202007;

import utils.ArrayHelper;

public class L27 {

    public static void main(String[] args) {
        System.out.println(new L27().removeElement(ArrayHelper.stringToArray("[4,5]"), 5));
    }

    public int removeElement(int[] nums, int val) {
        int j = nums.length;
        for (int i = 0; i < j; i++) {
            if (nums[i] == val) {
                boolean found = false;
                for (int k = j - 1; k >= i; k--) {
                    if (nums[k] != val) {
                        j = k;
                        found = true;
                        break;
                    }
                }
                if (found) {
                    nums[i] = nums[j];
                }
                else {
                    return i;
                }
            }
        }
        return j;
    }
}
