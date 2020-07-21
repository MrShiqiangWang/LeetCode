package pkg202007;

import java.util.HashSet;
import java.util.Set;

import utils.ArrayHelper;

public class L219 {

    public static void main(final String[] args) {
        System.out.println(new L219().containsNearbyDuplicate(ArrayHelper.stringToArray("[1,2,3,1]"), 3));
    }

    public boolean containsNearbyDuplicate(final int[] nums, final int k) {
        if (k == 0) {
            return false;
        }
        final Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            if (set.size() == k) {
                set.remove(nums[i - k]);
            }

            set.add(nums[i]);
        }
        return false;
    }
}
