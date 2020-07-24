package history.pkg202007;

import java.util.HashMap;
import java.util.Map;

public class L169 {

    public int majorityElement(final int[] nums) {
        final Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > nums.length / 2) {
                return nums[i];
            }
        }
        return -1;
    }
}
