package pkg202007;

import java.util.HashSet;
import java.util.Set;

import utils.ArrayHelper;

public class L217 {

    public static void main(final String[] args) {
        System.out.println(new L217().containsDuplicate(ArrayHelper.stringToArray("[3,3]")));
    }

    public boolean containsDuplicate(final int[] nums) {
        final Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
