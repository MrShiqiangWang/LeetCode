package pkg202007;

import java.util.ArrayList;
import java.util.List;

public class L448 {

    public List<Integer> findDisappearedNumbers(final int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            final int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        final List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i);
            }
        }
        return result;
    }
}
