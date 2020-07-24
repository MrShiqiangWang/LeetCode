package history.pkg202007;

import java.util.TreeSet;

public class L414_1 {

    public int thirdMax(final int[] nums) {
        final TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        if (set.size() < 3) {
            return set.pollLast();
        }
        set.pollLast();
        set.pollLast();
        return set.pollLast();
    }
}
