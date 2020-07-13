package pkg202007;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class L315 {

    public List<Integer> countSmaller(final int[] nums) {
        final int[][] temp = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            temp[i][0] = nums[i];
            temp[i][1] = nums.length - 1 - i;
        }
        Arrays.sort(temp, new Comparator<int[]>() {

            @Override
            public int compare(final int[] o1, final int[] o2) {
                return Integer.valueOf(o2[0]).compareTo(Integer.valueOf(o1[0]));
            }
        });
        final List<Integer> result = new ArrayList<>();
        for (int i = 0; i < temp.length; i++) {
            result.add(temp[i][1]);
        }
        return result;
    }
}
