package history.pkg202007;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import utils.ArrayHelper;

public class L697 {

    public static void main(final String[] args) {
        System.out.println(new L697().findShortestSubArray(ArrayHelper.stringToArray("[1,2,2,3,1]")));
    }

    public int findShortestSubArray(final int[] nums) {
        // 计算数组的度，包括对应的数据的�??
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int degree = 0;
        Set<Integer> result = new HashSet<Integer>();
        // 获取度最大的数据
        for (final Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > degree) {
                degree = entry.getValue();
                result = new HashSet<>();
                result.add(entry.getKey());
            }
            else if (entry.getValue() == degree) {
                result.add(entry.getKey());
            }
            else {
                continue;
            }
        }
        int min = Integer.MAX_VALUE;
        // 获取了最大的度和相应的数�?
        // 包含这些数据的左�?
        for (final Integer key : result) {
            int left = 0, right = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == key) {
                    left = i;
                    break;
                }
            }
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] == key) {
                    right = i;
                    break;
                }
            }
            min = Math.min(min, right - left + 1);
        }
        return min;
    }
}
