package pkg202007;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L15 {

    public List<List<Integer>> threeSum(final int[] nums) {
        Arrays.sort(nums);
        final Set<List<Integer>> result = new HashSet<List<Integer>>();
        for (int i = 0; i < nums.length - 1; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                final int value = nums[i] + nums[left] + nums[right];
                if (value == 0) {
                    final List<Integer> item = new ArrayList<>();
                    item.add(nums[i]);
                    item.add(nums[left]);
                    item.add(nums[right]);
                    result.add(item);
                    left++;
                    right--;
                }
                else if (value < 0) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return new ArrayList(result);
    }
}
